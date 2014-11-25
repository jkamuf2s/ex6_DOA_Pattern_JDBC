package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

public class DataBaseConnect {

	private static String dbLocation = "jdbc:postgresql://dumbo.inf.h-brs.de/";

	private static Properties prop = new Properties();

	public static void init() {
		prop.setProperty("user", "jkamuf2s");
		prop.setProperty("password", "jkamuf2s");
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static LinkedList<LinkedList<String>> exeQurry(String querry) throws SQLException  {
		LinkedList<LinkedList<String>> Results = new LinkedList<LinkedList<String>>();
			Connection con = DriverManager.getConnection(dbLocation, prop);

			Statement stat = con.createStatement();
			ResultSet res = stat.executeQuery(querry);

			ResultSetMetaData meta = res.getMetaData();
			int columnCount = meta.getColumnCount();

			while (res.next()) {
				LinkedList<String> row = new LinkedList<String>();
				for (int i = 1; i <= columnCount; i++) {
					row.add(res.getString(i).trim());
				}
				Results.add(row);
			}
			return Results;


		// TODO Auto-generated method stub

	}

    public static void exeUpdate(String querry) throws SQLException  {

        Connection con = DriverManager.getConnection(dbLocation, prop);

        Statement stat = con.createStatement();
        stat.executeUpdate(querry);


    }

}
