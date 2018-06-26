package com.toshiominei.amazonviewer.db;

import java.sql.DriverManager;
import java.sql.Connection;
import static com.toshiominei.amazonviewer.db.DataBase.*;

public interface IDBConnection {
	
	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL + DB, USER, PASSWORD);
			
			if(connection != null)
				System.out.println("Se estableció la conexión");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
}
