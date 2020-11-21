package banking.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import org.springframework.stereotype.Repository;

import banking.configure.BankingConfigure;
import banking.dto.Loan;

@Repository("BankingDto")
public class BankingDaoImp implements BankingDao {

	@Override
	public String validate(String id, String pass) {

		String status = "failure";

		try {
			Connection conn = BankingConfigure.dataSource();
			PreparedStatement stmt = conn.prepareStatement("select * from login where id=? and password=?");
			stmt.setString(1, id);
			stmt.setString(2, pass);
			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString("name");
				status = "success - " + name;
			} else {
				status = "failure";
				return status;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return status;
		}

		return status;
	}

	@Override
	public String resetvalidate(String id, String number) {

		String status = "failure";

		try {
			Connection conn = BankingConfigure.dataSource();
			PreparedStatement stmt = conn.prepareStatement("select * from login where id=? and number=?");
			stmt.setString(1, id);
			stmt.setString(2, number);
			ResultSet resultSet = stmt.executeQuery();

			if (resultSet.next()) {
				status = "success";
			} else {
				status = "failure";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String reset(String cpass, String id) {

		String status = "failure";

		try {
			Connection conn = BankingConfigure.dataSource();
			PreparedStatement stmt = conn.prepareStatement("update login set password=? where id=?");
			stmt.setString(1, cpass);
			stmt.setString(2, id);
			int i = stmt.executeUpdate();

			if (i == 1) {
				status = "success";
			} else {
				status = "failure";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String checkBal(String id) {

		try {
			Connection conn = BankingConfigure.dataSource();
			PreparedStatement stmt = conn.prepareStatement("select * from account where id=?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String bal = rs.getString("balance");
				return bal;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "failure";
		}

		return "failure";
	}

	@Override
	public String transfer(String fromAcc, String toAcc, String name, String amount, String mode, String remarks) {

		String status = "failure";
		Connection conn = BankingConfigure.dataSource();

		try {
			PreparedStatement stmt1 = conn.prepareStatement("select * from account where account=?");

			stmt1.setString(1, fromAcc);
			ResultSet rs = stmt1.executeQuery();
			if (rs.next()) {
				int bal = Integer.parseInt(rs.getString("balance"));
				if ((bal - 500) > Integer.parseInt(amount)) {

					PreparedStatement stmt2 = conn
							.prepareStatement("select * from account where account =? and name=?");
					stmt2.setString(1, toAcc);
					stmt2.setString(2, name);
					ResultSet rs1 = stmt2.executeQuery();

					if (rs1.next()) {

						String rbal = rs1.getString("balance");
						int newRbal = Integer.parseInt(rbal) + Integer.parseInt(amount);

						try {
							int newbal = bal - Integer.parseInt(amount);
							PreparedStatement stmt3 = conn
									.prepareStatement("update account set balance=? where account=?");
							stmt3.setInt(1, newbal);
							stmt3.setString(2, fromAcc);
							conn.setAutoCommit(false);
							int j = stmt3.executeUpdate();
							if (j > 0) {
//								conn.commit();
//								conn.setAutoCommit(true);
								PreparedStatement stmt4 = conn
										.prepareStatement("update account set balance=? where account=?");
								stmt4.setInt(1, newRbal);
								stmt4.setString(2, toAcc);
								conn.setAutoCommit(false);
								int k = stmt4.executeUpdate();
								if (k > 0) {
//									conn.commit();
//									conn.setAutoCommit(true);

									if (k > 0) {
										PreparedStatement stmt = conn.prepareStatement(
												"insert into statement(toaccount,name,amount,paymentmode,remarks,fromaccount) values(?,?,?,?,?,?)");
										stmt.setString(2, name);
										stmt.setString(1, toAcc);
										stmt.setString(4, mode);
										stmt.setString(5, remarks);
										stmt.setString(3, amount);
										stmt.setString(6, fromAcc);
										conn.setAutoCommit(false);
										int i = stmt.executeUpdate();

										if (i > 0) {
											conn.commit();
											conn.setAutoCommit(true);
											PreparedStatement stmt0 = conn
													.prepareStatement("select * from account where account=?");
											stmt0.setString(1, fromAcc);
											ResultSet resultSet = stmt0.executeQuery();
											if (resultSet.next()) {
												String updatedBal = resultSet.getString("balance");
												status = "success - " + updatedBal;

												return status;
											}
										} else {
											conn.rollback();
											conn.setAutoCommit(true);
											status = "failure";
										}
									}
								} else {
									conn.rollback();
									conn.setAutoCommit(true);
									status = "failure";
									return status;
								}
							} else {
								conn.rollback();
								conn.setAutoCommit(true);
								status = "failure";
								return status;
							}

						} catch (SQLException e) {
							conn.rollback();
							conn.setAutoCommit(true);
							status = "failure";
							e.printStackTrace();
						}
					}else {
						status = "user account not exist";
						return status;
					}

				} else {
					status = "balance not avilable";
					return status;
				}
			} else {
				status = "user account not exist";
				return status;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return status;
	}

	@Override
	public ArrayList<String> statment(String id) {

		ArrayList<String> list = new ArrayList<String>();

		Connection conn = BankingConfigure.dataSource();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from account where id=?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String acc = rs.getString("account");

				PreparedStatement stmt1 = conn.prepareStatement("select * from statement where fromaccount=?");
				stmt1.setString(1, acc);
				ResultSet rs1 = stmt1.executeQuery();

				while (rs1.next()) {

					list.add(rs1.getString("toaccount"));
					list.add(rs1.getString("name"));
					list.add(rs1.getString("paymentmode"));
					list.add(rs1.getString("remarks"));
					list.add(rs1.getString("amount"));

				}

			} else {
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}

		return list;
	}

	@Override
	public String recharge(String operator, String amount, String number, String id, String password) {

		Connection conn = BankingConfigure.dataSource();
		String status = "failure";

		try {
			PreparedStatement stmt = conn.prepareStatement("select * from login where id=? and password=?");
			stmt.setString(1, id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				PreparedStatement stmt1 = conn.prepareStatement("select * from account where id=?");
				stmt1.setString(1, id);
				ResultSet rs1 = stmt1.executeQuery();

				if (rs1.next()) {
					String acc = rs1.getString("account");
					String bal = rs1.getString("balance");

					int newbal = Integer.parseInt(bal) - Integer.parseInt(amount);
					PreparedStatement stmt2 = conn.prepareStatement("update account set balance=? where id=?");
					stmt2.setInt(1, newbal);
					stmt2.setString(2, id);
					conn.setAutoCommit(false);
					int i = stmt2.executeUpdate();

					if (i > 0) {
						PreparedStatement stmt3 = conn.prepareStatement("insert into statement "
								+ "(fromaccount,toaccount,name,amount,paymentmode) values(?,?,?,?,?)");
						stmt3.setString(1, acc);
						stmt3.setString(2, operator + " recharge");
						stmt3.setString(3, operator);
						stmt3.setString(4, amount);
						stmt3.setString(5, "recharge");
						int j = stmt3.executeUpdate();

						if (j > 0) {
							PreparedStatement stmt4 = conn.prepareStatement("select * from account where id=?");
							stmt4.setString(1, id);
							ResultSet rs2 = stmt4.executeQuery();

							if (rs2.next()) {
								String updatedBal = rs2.getString("balance");

								conn.commit();
								conn.setAutoCommit(true);
								status = "success - " + updatedBal;
								return status;
							}
						} else {
							conn.rollback();
							conn.setAutoCommit(true);
							status = "failure";
							return status;
						}

					}
				} else {
					conn.rollback();
					conn.setAutoCommit(true);
					status = "failure";
					return status;
				}

			} else {
				status = "password incorrect";
				return status;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return status;
		}
		return status;
	}

	@Override
	public String loan(Loan loan, String id) {
		String status="failure";
		Connection conn = BankingConfigure.dataSource();
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into loan(id,name,dob,number,address,statement,photo,sign) values (?,?,?,?,?,?,?,?)");
			 
			stmt.setString(1, id);
			stmt.setString(2, loan.getName());
			stmt.setString(3, loan.getDob());
			stmt.setString(4, loan.getNumber());
			stmt.setString(5, loan.getAddress());
			stmt.setBlob(6, loan.getStmt());
			stmt.setBlob(7, loan.getPhoto());
			stmt.setBlob(8, loan.getSign());
			int i = stmt.executeUpdate();
			
			if(i>0) {
				status="success";
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String status(String id) {
		String status="null";
		Connection conn = BankingConfigure.dataSource();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from loan where id=?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				 status = rs.getString("status");
				 String remark = rs.getString("remarks");
				return status+" - "+remark;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return status;
		}
		return status;
	}

}
