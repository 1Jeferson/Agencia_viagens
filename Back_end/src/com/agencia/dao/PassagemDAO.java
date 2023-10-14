package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.agencia.model.Cliente;
import com.agencia.model.Destinos;
import com.agencia.model.Passagem;

public class PassagemDAO {

	private static String sql;
	private final Connection connection;

	public PassagemDAO(Connection connection) {
		this.connection = connection;
	}

	public void createPassagem(Passagem passagem) {
		sql = "INSERT INTO Passagem (dataViagem, precoPassagem, idCliente, idDestinos) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			Timestamp sqlDataViagem = Timestamp.valueOf(passagem.getDataViagem());
			stmt.setTimestamp(1, sqlDataViagem);
			stmt.setDouble(2, passagem.getPrecoPassagem());
			stmt.setInt(3, passagem.getCliente().getIdCliente());
			stmt.setInt(4, passagem.getDestinos().getIdDestino());

			stmt.executeUpdate();
			System.out.println("Compra efetuada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void readAllPassagens() {
		sql = "SELECT * FROM passagem";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Passagem passagem = new Passagem();

				passagem.setIdPassagem(result.getInt("idPassagem"));
				passagem.setDataViagem(result.getTimestamp("dataViagem").toLocalDateTime());
				passagem.setPrecoPassagem(result.getDouble("precoPassagem"));

				Cliente cliente = new Cliente();
				cliente.setIdCliente(result.getInt("idCliente"));

				Destinos destinos = new Destinos();
				destinos.setIdDestino(result.getInt("idDestinos"));

				System.out.println("ID Passagem: " + passagem.getIdPassagem() + "\nData da Viagem: "
						+ passagem.getDataViagem() + "\nID Cliente: " + cliente.getNomeCliente() + "\nID Destino: "
						+ destinos.getNomeDestino() + "\nPreço: " + passagem.getPrecoPassagem());

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updatePassagem(Passagem passagem) {
		sql = "UPDATE Passagem SET dataViagem = ?, precoPassagem = ?, idCliente = ?, idDestinos = ? WHERE idPassagem = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			Timestamp sqlDataViagem = Timestamp.valueOf(passagem.getDataViagem());
			stmt.setTimestamp(1, sqlDataViagem);
			stmt.setDouble(2, passagem.getPrecoPassagem());
			stmt.setInt(3, passagem.getCliente().getIdCliente());
			stmt.setInt(4, passagem.getDestinos().getIdDestino());
			stmt.setInt(5, passagem.getIdPassagem());

			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletePassagem(int id) {
		sql = "DELETE FROM passagem WHERE idPassagem = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
