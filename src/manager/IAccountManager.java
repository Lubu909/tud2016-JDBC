package manager;

import java.sql.Connection;
import java.util.List;

import model.Account;

public interface IAccountManager {
	public Connection getConnection();
	public int addAccount(Account account);
	public int deleteAccount(Account account);
	public int clearAccount();
	public List<Account> getAll();
}
