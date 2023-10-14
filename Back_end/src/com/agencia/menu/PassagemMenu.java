package com.agencia.menu;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.agencia.dao.PassagemDAO;
import com.agencia.database.DatabaseConnection;
import com.agencia.model.Cliente;
import com.agencia.model.Destinos;
import com.agencia.model.Passagem;

public class PassagemMenu {

	static Connection connection = DatabaseConnection.createConnection();
	static PassagemDAO passagemDAO = new PassagemDAO(connection);

	public static int SubMenuPassagem(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		do {
			System.out.println("MENU PASSAGEM\n" + "1 - Comprar passagem\n" + "2 - Consultar Passagem\n"
					+ "3 - Atualizar\n" + "4 - Deletar" + "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Passagem passagem = new Passagem();
				System.out.print("Infome a data a viagem com dd/MM/yyyy HH:mm:ss: ");
				String dataEhoraViagem = scanner.nextLine();
				passagem.setDataViagem(LocalDateTime.parse(dataEhoraViagem, formatter));
				System.out.print("Digite o ID do Cliente: ");
				Cliente clientePassagem = new Cliente();
				clientePassagem.setIdCliente(scanner.nextInt());
				System.out.print("Digite o ID do Destino: ");
				Destinos destinosPassagem = new Destinos();
				destinosPassagem.setIdDestino(scanner.nextInt());

				passagemDAO.createPassagem(passagem);
				break;
			case 2:
				passagemDAO.readAllPassagens();
				break;
			case 3:
				Passagem passagemAtualizada = new Passagem();
				System.out.println("Digite o ID da Passagem para ser ATUALIZADA ");
				passagemAtualizada.setIdPassagem(scanner.nextInt());
				scanner.nextLine();
				System.out.print("Infome a data a viagem com dd/MM/yyyy HH:mm:ss: ");
				String dataEhoraViagemAtualizada = scanner.nextLine();
				passagemAtualizada.setDataViagem(LocalDateTime.parse(dataEhoraViagemAtualizada, formatter));
				System.out.print("Digite o ID do Cliente: ");
				Cliente clientePassagemAtualizado = new Cliente();
				clientePassagemAtualizado.setIdCliente(scanner.nextInt());
				System.out.print("Digite o ID do Destino");
				Destinos destinosPassagemAtualizado = new Destinos();
				destinosPassagemAtualizado.setIdDestino(scanner.nextInt());

				passagemDAO.updatePassagem(passagemAtualizada);
				break;
			case 4:
				System.out.println("Digite o ID da Passagem para ser DELETADA: ");
				int idPassagem = scanner.nextInt();
				passagemDAO.deletePassagem(idPassagem);

				break;
			default:
				System.out.println("Digite uma opção valida");

			}

		} while (option != 0);

		return option;
	}
}
