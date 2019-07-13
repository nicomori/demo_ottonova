package com.demo.ottonova.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBAdminSQL {

	public static Connection conectorBaseDeDatosSQL() {

		Connection conexion = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			String urlDbConnector = "jdbc:mysql://localhost/pisofinder?"
            + "user=root&password=a4610b";
            
			conexion = DriverManager.getConnection(urlDbConnector);

		} catch (Exception ex) {
			System.out.println(ex);
			;
			conexion = null;
		}
		return conexion;
	}

//	public void desconectar() {
//		connection = null;
//	}

}
