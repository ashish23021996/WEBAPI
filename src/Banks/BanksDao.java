package Banks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BanksDao {
public List<Bank> getAllBanks(String ifsc){
	List<Bank> bankList = new ArrayList<Bank>();
	
	Connection c = null;
	Statement stmt = null;
	try {
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-183-20.eu-west-1.compute.amazonaws.com:5432/d1pq68u3kuvpep?sslmode=require", "mahxsmfwyxwjbk", "128e48320cebbdb5f31d48e711a000036d482772fa712db425528279975f51db");
		c.setAutoCommit(false);
		System.out.println("Opened database successfully");

		stmt = c.createStatement();
		System.out.println("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc + "');");
		ResultSet rs = stmt.executeQuery("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc + "');");
		while (rs.next()) {

			String name = rs.getString("name");
			int id = rs.getInt("id");
			Bank bank = new Bank(name,id);

			bankList.add(bank);

		}
		rs.close();
		stmt.close();
		c.close();
	} catch (Exception e) {
		System.err.println(e.getClass().getName() + ": " + e.getMessage());
		System.exit(0);
	}
	System.out.println("Operation done successfully");

	return  bankList;
}

public List<Bank> getAllBanks(String ifsc, String limit) {

	List<Bank> bankList = new ArrayList<Bank>();
	
	Connection c = null;
	Statement stmt = null;
	try {
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-183-20.eu-west-1.compute.amazonaws.com:5432/d1pq68u3kuvpep?sslmode=require", "mahxsmfwyxwjbk", "128e48320cebbdb5f31d48e711a000036d482772fa712db425528279975f51db");
		c.setAutoCommit(false);
		System.out.println("Opened database successfully");

		stmt = c.createStatement();
		System.out.println("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc + "') " + limit + ";");
		ResultSet rs = stmt.executeQuery("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc + "')  " + limit + ";");
		while (rs.next()) {

			String name = rs.getString("name");
			int id = rs.getInt("id");
			Bank bank = new Bank(name,id);

			bankList.add(bank);

		}
		rs.close();
		stmt.close();
		c.close();
	} catch (Exception e) {
		System.err.println(e.getClass().getName() + ": " + e.getMessage());
		System.exit(0);
	}
	System.out.println("Operation done successfully");

	return  bankList;

}

public List<Bank> getAllBanks(String ifsc, String limit, String offset) {


	List<Bank> bankList = new ArrayList<Bank>();
	
	Connection c = null;
	Statement stmt = null;
	try {
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-183-20.eu-west-1.compute.amazonaws.com:5432/d1pq68u3kuvpep?sslmode=require", "mahxsmfwyxwjbk", "128e48320cebbdb5f31d48e711a000036d482772fa712db425528279975f51db");
		c.setAutoCommit(false);
		System.out.println("Opened database successfully");

		stmt = c.createStatement();
		System.out.println("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc + "' ) " + limit + " " + offset + ";");
		ResultSet rs = stmt.executeQuery("select *  from banks where id = (select bank_id from branches where ifsc = '" + ifsc + "' )  " + limit + " " + offset + ";");
		while (rs.next()) {

			String name = rs.getString("name");
			int id = rs.getInt("id");
			Bank bank = new Bank(name,id);

			bankList.add(bank);

		}
		rs.close();
		stmt.close();
		c.close();
	} catch (Exception e) {
		System.err.println(e.getClass().getName() + ": " + e.getMessage());
		System.exit(0);
	}
	System.out.println("Operation done successfully");

	return  bankList;


}
}
