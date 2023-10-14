package com.agencia;

import java.util.Scanner;

import com.agencia.menu.ClienteMenu;
import com.agencia.menu.DestinosMenu;
import com.agencia.menu.PassagemMenu;
import com.agencia.menu.SubMenu;


public class Main {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {

			option = SubMenu.menu(scanner);

			switch (option) {
			case 1:
				ClienteMenu.SubMenuCliente(scanner);
				break;
			case 2:
				DestinosMenu.SubMenuDestinos(scanner);
				break;
			case 3:
				PassagemMenu.SubMenuPassagem(scanner);

			default:
				System.out.println("Saindo...");
				break;

			}

		} while (option != 4);
		scanner.close();

	}
}
