package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Cliente;

public class ClienteDAO {

	private static String sql;
	private final Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	public void createCliente(Cliente cliente) {
		sql = "INSERT INTO cliente (nomeCliente, cpfCliente, telefoneCliente, enderecoCliente, emailCliente) VALUES (?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getTelefoneCliente());
			stmt.setString(4, cliente.getEnderecoCliente());
			stmt.setString(5, cliente.getEmailCliente());

			stmt.executeUpdate();
			System.out.println("Cadastrado com sucessos.\n");

		} catch (SQLException e) {
			System.out.println("Não foi possivel cadastrar. " + e.getMessage());
		}
	}

	public void readAllClientes() {
		sql = "SELECT * FROM cliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Cliente cliente = new Cliente();
				cliente.setNomeCliente(result.getString("nomeCliente"));
				cliente.setCpfCliente(result.getString("cpfCliente"));
				cliente.setTelefoneCliente(result.getString("telefoneCliente"));
				cliente.setEnderecoCliente(result.getString("enderecoCliente"));
				cliente.setEmailCliente(result.getString("emailCliente"));
				cliente.setIdCliente(result.getInt("idCliente"));

				System.out.printf("ID: %d\n Nome: %s\n CPF: %s\n Telefone: %s\n Endereco: %s\n Email: %s\n \n ",
						cliente.getIdCliente(), cliente.getNomeCliente(), cliente.getCpfCliente(),
						cliente.getTelefoneCliente(), cliente.getEnderecoCliente(), cliente.getEmailCliente());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateCreate(Cliente cliente) {
		sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, telefoneCliente = ?, enderecoCliente = ?, emailCliente = ? WHERE idCliente  = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getTelefoneCliente());
			stmt.setString(4, cliente.getEnderecoCliente());
			stmt.setString(5, cliente.getEmailCliente());
			stmt.setInt(6, cliente.getIdCliente());

			stmt.executeUpdate();
			System.out.printf(
					" Nome: %s\n CPF: %s\n Telefone: %s\n Endereco: %s\n Email: %s\n \n Dados atualizados com sucesso.\n \n",
					cliente.getNomeCliente(), cliente.getCpfCliente(), cliente.getTelefoneCliente(),
					cliente.getEnderecoCliente(), cliente.getEmailCliente());

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteCliente(int id) {
		sql = "DELETE FROM cliente WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println("Dados deletados.\n");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
