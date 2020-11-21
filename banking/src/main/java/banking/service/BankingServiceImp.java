package banking.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import banking.dao.BankingDao;
import banking.dto.Loan;

@Component("BankingService")
public class BankingServiceImp implements BankingService{

	@Autowired
	private BankingDao bankingDao;
	
	@Override
	public String validate(String id,String pass) {
		
		return bankingDao.validate(id, pass);

	}

	@Override
	public String resetvalidate(String id, String number) {
		
		return bankingDao.resetvalidate(id, number);
	}

	@Override
	public String reset(String cpass,String id) {
		return bankingDao.reset(cpass,id);
	}

	@Override
	public String checkBal(String id) {
		return bankingDao.checkBal(id);
	}

	@Override
	public String transfer(String fromAcc, String toAcc, String name, String amount, String mode, String remarks) {
		return bankingDao.transfer(fromAcc, toAcc, name, amount, mode, remarks);
	}

	@Override
	public ArrayList<String> statment(String id) {
		return bankingDao.statment(id);
	}

	@Override
	public String recharge(String operator, String amount, String number,String id, String password) {
		return bankingDao.recharge(operator,amount, number,id, password);
	}

	@Override
	public String loan(Loan loan, String id) {
		return bankingDao.loan(loan, id);
	}

	@Override
	public String status(String id) {
		return bankingDao.status(id);
	}

}
