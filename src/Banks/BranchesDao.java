package Banks;

import java.util.ArrayList;
import java.util.List;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BranchesDao {

	public List<Branches> getAllBranches(String bank_name, String city_name) {

		List<Branches> branchList = new ArrayList<Branches>();

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-183-20.eu-west-1.compute.amazonaws.com:5432/d1pq68u3kuvpep?sslmode=require", "mahxsmfwyxwjbk", "128e48320cebbdb5f31d48e711a000036d482772fa712db425528279975f51db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			System.out.println("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ); ");
			ResultSet rs = stmt.executeQuery("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ) ;");
			while (rs.next()) {

				String ifsc = rs.getString("ifsc");
				int id = rs.getInt("bank_id");
				String branch = rs.getString("branch");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String district = rs.getString("district");
				String state = rs.getString("state");
				Branches branches = new Branches(ifsc, id, branch, address, city, district, state);

				branchList.add(branches);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return branchList;
	}

	public List<Branches> getAllBranches(String bank_name, String city_name, String limit) {

		List<Branches> branchList = new ArrayList<Branches>();

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-183-20.eu-west-1.compute.amazonaws.com:5432/d1pq68u3kuvpep?sslmode=require", "mahxsmfwyxwjbk", "128e48320cebbdb5f31d48e711a000036d482772fa712db425528279975f51db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			System.out.println("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + URLEncoder.encode(bank_name, "UTF-8")
					+ "' ) " + limit + ";");
			ResultSet rs = stmt.executeQuery("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ) " + limit + ";");
			while (rs.next()) {

				String ifsc = rs.getString("ifsc");
				int id = rs.getInt("bank_id");
				String branch = rs.getString("branch");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String district = rs.getString("district");
				String state = rs.getString("state");
				Branches branches = new Branches(ifsc, id, branch, address, city, district, state);

				branchList.add(branches);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return branchList;
	}

	public List<Branches> getAllBranches(String bank_name, String city_name, String limit, String offset) {
		// TODO Auto-generated method stub

		List<Branches> branchList = new ArrayList<Branches>();

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://ec2-176-34-183-20.eu-west-1.compute.amazonaws.com:5432/d1pq68u3kuvpep?sslmode=require", "mahxsmfwyxwjbk", "128e48320cebbdb5f31d48e711a000036d482772fa712db425528279975f51db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			System.out.println("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ) " + limit + " " + offset
					+ ";");
			ResultSet rs = stmt.executeQuery("select * from branches where city = '" + city_name
					+ "' and bank_id = (select id from banks where name ='" + bank_name + "' ) " + limit + " " + offset
					+ ";");
			while (rs.next()) {

				String ifsc = rs.getString("ifsc");
				int id = rs.getInt("bank_id");
				String branch = rs.getString("branch");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String district = rs.getString("district");
				String state = rs.getString("state");
				Branches branches = new Branches(ifsc, id, branch, address, city, district, state);

				branchList.add(branches);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return branchList;

	}

}
