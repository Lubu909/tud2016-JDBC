package main.java.com.tud2016JDBC.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.com.tud2016JDBC.model.Account;

public class AccountManager implements IAccountManager{
	private Connection conn;
	private Statement stmt;
	
	private PreparedStatement addAccountStmt;
	private PreparedStatement delAccountStmt;
	private PreparedStatement delAllAccountStmt;
	private PreparedStatement getAccountStmt;
	private PreparedStatement getAccountIdStmt;
	private PreparedStatement listAccountStmt;
	
	public AccountManager(){
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/projekt");
			stmt = conn.createStatement();
			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Account".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
			if (!tableExists) stmt.executeUpdate("CREATE TABLE Account(idAccount int UNIQUE GENERATED BY DEFAULT AS IDENTITY, login varchar(30) UNIQUE, password varchar(25), registrationDate date DEFAULT CURRENT_DATE, lastLogin date DEFAULT CURRENT_DATE)");
			addAccountStmt = conn.prepareStatement("INSERT INTO Account(login, password) VALUES (?,?)");
			delAccountStmt = conn.prepareStatement("DELETE FROM Account WHERE idAccount = ?");
			delAllAccountStmt = conn.prepareStatement("DELETE FROM Account");
			getAccountStmt = conn.prepareStatement("SELECT * FROM Account WHERE login = ?");
			getAccountIdStmt = conn.prepareStatement("SELECT * FROM Account WHERE idAccount = ?");
			listAccountStmt = conn.prepareStatement("SELECT * FROM Account");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection getConnection() {
		return conn;
	}
	
	@Override
	public int addAccount(Account account) {
		int ilosc = 0;
		try {
			conn.setAutoCommit(false);
			addAccountStmt.setString(1, account.getLogin());
			addAccountStmt.setString(2, account.getPassword());
			ilosc = addAccountStmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ilosc;
	}

	@Override
	public int deleteAccount(Account account) {
		int ilosc = 0;
		try{
			conn.setAutoCommit(false);
			delAccountStmt.setInt(1, account.getId());
			ilosc = delAccountStmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ilosc;
	}

	@Override
	public int clearAccount() {
		int ilosc = 0;
		try{
			conn.setAutoCommit(false);
			ilosc = delAllAccountStmt.executeUpdate();
			conn.commit();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return ilosc;
	}
	
	@Override
	public List<Account> getAll(){
		List<Account> accounts = new ArrayList<Account>();
		try{
			ResultSet rs = listAccountStmt.executeQuery();
			while(rs.next()){
				Account acc = new Account();
				acc.setId(rs.getInt("idAccount"));
				acc.setLogin(rs.getString("login"));
				acc.setPassword(rs.getString("password"));
				acc.setRegistrationDate(rs.getString("registrationDate"));
				acc.setLastLoginDate(rs.getString("lastLogin"));
				accounts.add(acc);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account getAccount(String login) {
		Account acc = new Account();
		try{
			getAccountStmt.setString(1, login);
			ResultSet rs = getAccountStmt.executeQuery();
			while(rs.next()){
				acc.setId(rs.getInt("idAccount"));
				acc.setLogin(rs.getString("login"));
				acc.setPassword(rs.getString("password"));
				acc.setRegistrationDate(rs.getString("registrationDate"));
				acc.setLastLoginDate(rs.getString("lastLogin"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return acc;
	}
	
	@Override
	public Account getAccount(int id) {
		Account acc = new Account();
		try{
			getAccountIdStmt.setInt(1, id);
			ResultSet rs = getAccountIdStmt.executeQuery();
			while(rs.next()){
				acc.setId(rs.getInt("idAccount"));
				acc.setLogin(rs.getString("login"));
				acc.setPassword(rs.getString("password"));
				acc.setRegistrationDate(rs.getString("registrationDate"));
				acc.setLastLoginDate(rs.getString("lastLogin"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return acc;
	}
}
