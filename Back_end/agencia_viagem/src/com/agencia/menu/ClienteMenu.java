package com.agencia.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.agencia.dao.ClienteDAO;
import com.agencia.database.DatabaseConnection;
import com.agencia.model.Cliente;

public class ClienteMenu {
	
	static Connection connection = DatabaseConnection.createConnection();
	static ClienteDAO clienteDAO = new ClienteDAO(connection);
	
	public static int SubMenuCliente(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		
		do {
			System.out.println("MENU CLIENTE\n" + "1 - Cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n" + "4 - Deletar"
					+ "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Cliente cliente = new Cliente();
				System.out.print("Nome completo: ");
				cliente.setNomeCliente(scanner.nextLine());
				System.out.print("CPF: ");
				cliente.setCpfCliente(scanner.nextLine().trim());
				System.out.print("Telefone: ");
				cliente.setTelefoneCliente(scanner.nextLine());
				System.out.print("Endereço: ");
				cliente.setEnderecoCliente(scanner.nextLine());
				System.out.print("Email: ");
				cliente.setEmailCliente(scanner.nextLine());
				System.out.println();
				

				clienteDAO.createCliente(cliente);
				break;
			case 2:
				clienteDAO.readAllClientes();
				break;
			case 3:
				scanner.nextLine();
				Cliente clienteUp = new Cliente();
				System.out.println("Digite o ID do cliente a ser atualizado: ");
				clienteUp.setIdCliente(scanner.nextInt());
				scanner.nextLine();
				System.out.print("Nome completo: ");
				clienteUp.setNomeCliente(scanner.nextLine());
				System.out.print("CPF: ");
				clienteUp.setCpfCliente(scanner.nextLine().trim());
				System.out.print("Telefone: ");
				clienteUp.setTelefoneCliente(scanner.nextLine());
				System.out.print("Endereço: ");
				clienteUp.setEnderecoCliente(scanner.nextLine());
				System.out.print("Email: ");
				clienteUp.setEmailCliente(scanner.nextLine());
				System.out.println();

				clienteDAO.updateCreate(clienteUp);
				break;
			case 4:
				System.out.println("Digite o ID do Cliente a ser DELETADO");
				int idCliente = scanner.nextInt();
				clienteDAO.deleteCliente(idCliente);
				
				break;
			default:
				System.out.println("Digite uma opção valida");

			}

		} while (option != 0);
		
		return option;
	}
		
	}

