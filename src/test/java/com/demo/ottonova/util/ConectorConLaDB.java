package com.demo.ottonova.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConectorConLaDB {

	private static Connection laConexionConSQL = DBAdminSQL.conectorBaseDeDatosSQL();
	private static List arrayDeAvisosYaIncluidos = new ArrayList<String>();
	private static List array2 = new ArrayList<String>();

	private static PreparedStatement preparedStatement = null;

	public static List dbConsultaSiExisteTitulosDeAvisos(List listaDeAvisosAConsultarALaDB) {
		Connection laConexionConLaDB;
		laConexionConLaDB = DBAdminSQL.conectorBaseDeDatosSQL();
		ResultSet resultSet = null;

		try {

			preparedStatement = laConexionConLaDB.prepareStatement("" + "select title from avisos_vistos where "
					+ "customer = 1 and " + "title = ? or " + "title = ? or " + "title = ? or " + "title = ? or "
					+ "title = ? or " + "title = ? or " + "title = ? or " + "title = ? or " + "title = ? " + "");

			for (int i = 0; i < listaDeAvisosAConsultarALaDB.size(); i++) {
				preparedStatement.setString(i + 1, (String) listaDeAvisosAConsultarALaDB.get(i));
			}

			resultSet = preparedStatement.executeQuery();

			// este while va a recorrer todos los valores obtenidos dentro del
			// resultset.
			while (resultSet.next()) {
				// este for va a recorrer todo el array dentro obtenido
				// originalmente y si encuentra que es igual al valor obtenido
				// dentro del resultset, va a eliminar la posicion entera
				for (int i = 0; i < listaDeAvisosAConsultarALaDB.size(); i++) {
					if (listaDeAvisosAConsultarALaDB.get(i) == resultSet.getString("title")) {
						listaDeAvisosAConsultarALaDB.remove(i);
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Se genero un error al consultar sobre la existencia de alguns avisos: " + e);
		}
		return listaDeAvisosAConsultarALaDB;
	}

	public static String generadorDeConexion() {
		Connection laConexionConLaDB;
		laConexionConLaDB = DBAdminSQL.conectorBaseDeDatosSQL();
		String valorUrlConPort = null;

		try {
			Statement stmt = laConexionConLaDB.createStatement();
			String queryAEnviar = "select url from ports where flag=0 limit 1";

			String pepe = "call get_url(@nico);";
			String pepe2 = "select @nico;";

			stmt.executeQuery(pepe);
			ResultSet resultadoDelSelect = stmt.executeQuery(pepe2);

			while (resultadoDelSelect.next()) {
				valorUrlConPort = resultadoDelSelect.getString("@nico");
			}
		} catch (Exception e) {
			System.out.println("Se genero un error al momento de obtener los datos desde la DB, Error: " + e);
		}
		return valorUrlConPort;
	}

	public static void colocaLosFlagsDeLaDBEnCero() {
		Connection laConexionConLaDB;
		laConexionConLaDB = DBAdminSQL.conectorBaseDeDatosSQL();

		try {
			Statement stmt = laConexionConLaDB.createStatement();
			String queryAEnviar = "update ports set flag=0;";

			PreparedStatement preparadorDeLaDeclaracionSQLoStatement;
			preparadorDeLaDeclaracionSQLoStatement = laConexionConSQL.prepareStatement(queryAEnviar);
			preparadorDeLaDeclaracionSQLoStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(
					"Se produjo un error al momento de generar la limpieza de los Flags de la DB. Error: " + e);
		}
	}

	public static void cerrarLaConexionConLaDB() {
		try {
			DBAdminSQL.conectorBaseDeDatosSQL().close();
		} catch (Exception e) {
			System.out.println("Se genero un error al momento de intentar cerrar la conexion con la DB. Error: " + e);
		}
	}

}
