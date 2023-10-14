package com.agencia.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.agencia.dao.DestinosDAO;
import com.agencia.database.DatabaseConnection;
import com.agencia.model.Destinos;

public class DestinosMenu {

	static Connection connection = DatabaseConnection.createConnection();
	static DestinosDAO destinosDAO = new DestinosDAO(connection);

	public static int SubMenuDestinos(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU DESTINO\n" + "1 - Cadastrar Destino\n" + "2 - Consultar Destinos\n" + "3 - Atualizar\n"
					+ "5 - Deletar" + "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Destinos destinos = new Destinos();
				System.out.print("Nome Destino: ");
				destinos.setNomeDestino(scanner.nextLine());
				System.out.print("Localização: ");
				destinos.setLocalizacaoDestino(scanner.nextLine());
				System.out.print("Descrição: ");
				destinos.setDescricaoDestino(scanner.nextLine());
				System.out.print("Preço: ");
				destinos.setPrecoDestino(scanner.nextDouble());

				destinosDAO.createDestinos(destinos);
				break;
			case 2:
				destinosDAO.readAllDestinos();
				break;
			case 3:
				scanner.nextLine();
				Destinos destinosUp = new Destinos();
				System.out.println("Digite o ID do cliente a ser atualizado: ");
				System.out.print("Nome Destino: ");
				destinosUp.setNomeDestino(scanner.nextLine());
				System.out.print("Localização: ");
				destinosUp.setLocalizacaoDestino(scanner.nextLine());
				System.out.print("Descrição: ");
				destinosUp.setDescricaoDestino(scanner.nextLine());
				System.out.print("Preço: ");
				destinosUp.setPrecoDestino(scanner.nextDouble());

				destinosDAO.updateCreate(destinosUp);
				break;
			case 4:
				System.out.println("Digite o ID do Destino a ser DELETADO");
				int idDestino = scanner.nextInt();
				destinosDAO.deleteDestinos(idDestino);

				break;
			default:
				System.out.println("Digite uma opção valida");

			}

		} while (option != 0);

		return option;
	}
}
