package banking.configure;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;

import banking.dao.BankingDao;
import banking.dao.BankingDaoImp;
import banking.dto.Loan;
import banking.service.BankingService;
import banking.service.BankingServiceImp;

@Configuration
@ComponentScan(basePackages = { "banking.dto.BankingDtoImp", "banking.service.BankingServiceImp" })
public class BankingConfigure {

	static MysqlDataSource ds;
	static Connection conn;
	
	static {
		 ds = new MysqlDataSource();
		
		ds.setUrl("jdbc:mysql://localhost:3306/prasanth");
		ds.setUser("root");
		ds.setPassword("Laddu@12345");
		
		try {
			 conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection dataSource() {

		return conn;
	}

	@Bean
	public BankingDao bankingDto() {

		BankingDaoImp bdi = new BankingDaoImp();
		return bdi;
	}
	
	@Bean
	public BankingService BankingService() {

		BankingServiceImp bsi = new BankingServiceImp();
		return bsi;
	}
	
	@Bean
	public Loan account() {
		Loan account = new Loan();
		return account;
	}
}
