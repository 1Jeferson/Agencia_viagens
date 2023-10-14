package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Destinos;

public class DestinosDAO {

	private static String sql;
	private final Connection connection;

	public DestinosDAO(Connection connection) {
		this.connection = connection;
	}

	public void createDestinos(Destinos destinos) {
		sql = "INSERT INTO destinos (nomeDestino, localizacaoDestino, descricaoDestino, precoDestino) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destinos.getNomeDestino());
			stmt.setString(2, destinos.getLocalizacaoDestino());
			stmt.setString(3, destinos.getDescricaoDestino());
			stmt.setDouble(4, destinos.getPrecoDestino());

			stmt.executeUpdate();
			System.out.println("Destino cadastrado.\n");

		} catch (SQLException e) {
			System.out.println("Não foi possivel cadastrar. " + e.getMessage());
		}
	}

	public void readAllDestinos() {
		sql = "SELECT * FROM destinos";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				Destinos destinos = new Destinos();
				destinos.setNomeDestino(result.getString("nomeDestino"));
				destinos.setLocalizacaoDestino(result.getString("localizacaoDestino"));
				destinos.setDescricaoDestino(result.getString("descricaoDestino"));
				destinos.setPrecoDestino(result.getDouble("precoDestino"));
				destinos.setIdDestino(result.getInt("idDestinos"));

				System.out.println("ID: " + destinos.getIdDestino() + " Nome: " + destinos.getNomeDestino() + " Localização: " + destinos.getLocalizacaoDestino() + 
						" Descrição: " + destinos.getDescricaoDestino() + " Preço: " + destinos.getPrecoDestino());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateCreate(Destinos destinos) {
		sql = "UPDATE destinos SET nomeDestino = ?, locaolizacaodestino = ?, desricaoDestino = ?, precoDestino = ? WHERE idDestino = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destinos.getNomeDestino());
			stmt.setString(2, destinos.getLocalizacaoDestino());
			stmt.setString(3, destinos.getDescricaoDestino());
			stmt.setDouble(4, destinos.getPrecoDestino());
			stmt.setInt(5, destinos.getIdDestino());
			
			stmt.executeUpdate();
			System.out.println("Nome: " + destinos.getNomeDestino() + " Localização: " + destinos.getLocalizacaoDestino() + " Descrição: " + destinos.getDescricaoDestino() + " Preço: " + destinos.getPrecoDestino());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteDestinos(int id) {
		sql = "DELETE FROM destinos WHERE idDestinos = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			System.out.println("Destino deletado. \n");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
