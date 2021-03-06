package main.java.com.tud2016JDBC.manager;

import java.sql.Connection;
import java.util.List;

import main.java.com.tud2016JDBC.model.Account;

public interface IAccountManager {
	public Connection getConnection();
	public int addAccount(Account account);
	public int deleteAccount(Account account);
	public int clearAccount();
	public Account getAccount(String login);
	public Account getAccount(int id);
	public List<Account> getAll();
}
