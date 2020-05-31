package projetoIntegrador;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.*;

public class MainDrunks {

	public static void main(String[] args) {
		
		int menu;
		
		do {
			
			switch (menu){
			
			System.out.println("----MENU----\n"
					+ "1- Adicionar dado\n"
					+ "2- Modificar dados\n"
					+ "3- Imprimir dados \n"
					+ "4- Excluir dados\n"
					+ "0- sair \n\n");
			
			case 1:
				InsertData();
			case 2:
				ModifyData();
			case 3:
				PrintData();
			case 4:
				DeleteData();
			case 0:
				System.out.println("FIM");
				break;
			default :
				System.out.println("TENTE NOVAMENTE");
				break;
			}
			
			
		}while(menu =!0);
		

	}

}
