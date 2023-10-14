package com.agencia.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/viagem_do_tour";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado! Mensagem: " + e.getMessage());

		}
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conectado com sucesso!");
			return connection;
		} catch (SQLException e) {
			System.out.println("Não foi possivel conectar ao banco! Mensagem: " + e.getMessage());
			return null;
		}
	}

}
