package banking.service;

import java.util.ArrayList;

import banking.dto.Loan;

public interface BankingService {

	public String validate(String id,String pass);
	public String resetvalidate(String id,String number);
	public String reset(String cpass,String id);
	public String checkBal(String id);
	public String transfer(String fromAcc,String toAcc, String name, String amount, String mode, String remarks);
	public ArrayList<String> statment(String id);
	public String recharge(String operator,String amount, String number,String id, String password);
	public String loan(Loan loan, String id);
	public String status(String id);
}
