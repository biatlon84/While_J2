package com.mysql.ferst.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connector {

	private ResultSet rs;
	private ArrayList<String> strRes;

	public Connector() {
		this.strRes = new ArrayList<String>();
	}

	public ArrayList<String> getS(String ss) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String URL = "jdbc:mysql://localhost/books";
			String USER = "kwas";
			String PASSWORD = "Sql1234567890@";

			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection OK");

			Statement st = connection.createStatement();// --
			String query;
			if (ss == null) {
				query = "SELECT * FROM lib";
			} else {
				query = ss;
			}
			// String query = "INSERT INTO lib (name, year) values ('pascal', 1998)";
			rs = st.executeQuery(query);// --
			// st.execute(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String namE = rs.getString("name");
				int year = rs.getInt("year");

				// System.out.format("%d, %s, %d\n", id, namE, year);
				strRes.add(id + " " + namE + " " + year + "\n");
			}

			st.close();
			connection.close();
			System.out.println("Disconnect OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC not faund!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error!");
		}
		return strRes;
	}

	public boolean setS(String ss, int year) {
		boolean w = true;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String URL = "jdbc:mysql://localhost/books";
			String USER = "kwas";
			String PASSWORD = "Sql1234567890@";

			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection OK");

			Statement st = connection.createStatement();// --
			String query;

			query = "INSERT INTO lib (name, year) values ('" + ss + "', '" + year + "')";

			w = st.execute(query);

			st.close();
			connection.close();
			System.out.println("Disconnect OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC not faund!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error!");
		}
		return w;
	}
}
