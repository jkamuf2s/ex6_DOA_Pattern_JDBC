package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class simpleJDBCConnect {
	private static String sceemName = "ex6";
	private static String costumerTable = "product";

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new org.postgresql.Driver());
		String url = "jdbc:postgresql://dumbo.inf.h-brs.de/";
		Properties prop = new Properties();
		prop.setProperty("user", "jkamuf2s");
		prop.setProperty("password", "jkamuf2s");

		Connection con = DriverManager.getConnection(url, prop);

		Statement stat = con.createStatement();
		ResultSet res = stat.executeQuery("SELECT * FROM " + sceemName + "."
				+ costumerTable);

		ResultSetMetaData meta = res.getMetaData();
		int columnCount = meta.getColumnCount();

		while (res.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print("| " + res.getString(i).trim() + " |");
			}
			System.out.println();
		}

		System.out.println("done");
	}

}
