package com.agencia.menu;

import java.util.Scanner;

public class SubMenu {

	
	public static int menu(Scanner scanner) {
		System.out.println("Escolha uma opção de 1 - 4\n" + "1 - Cliente\n" + "2 - Destinos\n" + "3 - Passagem\n" + "4 - Sair");
		
		
		return scanner.nextInt();
	}
}
