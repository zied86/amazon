package com.e2eTests.automatedTests.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetInfoFromDB {
	

	public static String etatHubRestitution;
	public static String main ()
	{
		try
		{
			// create our mysql database connection
			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:oracle:thin:@database-pp.prodsi.msv:1521:re7";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "ifibre", "ifibre");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "";
			
			System.out.println(query);

			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
							System.out.println(" Etat Hub Restitution "+rs.getObject(1).toString());
							etatHubRestitution = rs.getObject(1).toString();
				return etatHubRestitution;
			}

			st.close();
		}

		catch (Exception e)
		{
			System.err.println("Got an exception! Etat Hub Restitution");
			System.err.println(e.getMessage());
		}

		return etatHubRestitution;
	}

}
