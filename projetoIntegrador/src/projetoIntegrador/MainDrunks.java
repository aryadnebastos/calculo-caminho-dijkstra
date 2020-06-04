package projetoIntegrador;

import java.util.Scanner;
import dados.Vetor;
import javax.swing.JOptionPane;
import java.io.*;
import dados.ListaSimples;



public class MainDrunks {
	
	static Scanner entrada = new Scanner(System.in);
	static StringBuffer memoria = new StringBuffer();
	
	
	public static void main(String[] args) {
		
		int menu;
		int quantidade;
		

		
		do {
			
			System.out.println("----MENU----\n"
					+ "1- Adicionar dado\n"
					+ "2- Modificar dados\n"
					+ "3- Imprimir dados \n"
					+ "4- Excluir dados\n"
					+ "0- sair \n\n");
			
			menu = entrada.nextInt();
			
			switch (menu) {
			
			
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
			
			
		}while(menu != 0);
		

	}
	
	@SuppressWarnings("unlikely-arg-type")
	static void SearchData() {
		//pesquisa usada no delete, modify, print
		int quantidade = 8;
		Vetor armazena = new Vetor(quantidade);
		String busca = "";
		
		System.out.println("Qual o ponto a ser buscado?");
		busca = entrada.next();
		
		for (int i = 0; i < armazena.getVertices().length ; i++) {
			
		armazena.getVertices()
			
		}
	}
	
	static void ReadFile() {
		//ler o arquivo txt
	}
	
	static void FileToList() {
		//inserir cada linha do arquivo em uma lista
	}
	
	static void ListToVector() {
		//inserir as listas em um vetor
	}

	
	static void InsertData() {

		try {
			//ler o arquivo txt
			ReadFile(); 
			//inserir cada linha do arquivo em uma lista
			FileToList();
			//inserir as listas em um vetor
			ListToVector();
					
		}catch(Exception erro3){
			JOptionPane.showMessageDialog(null, "Erro de gravação!",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static void ModifyData() {
		try {
			//codigo aqui
			
				
		}catch(Exception erro3){
			JOptionPane.showMessageDialog(null, "Erro de gravação!",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static void PrintData() {
		try {
			//codigo aqui
			
		}catch(Exception erro3){
			JOptionPane.showMessageDialog(null, "Erro de gravação!",null, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static void DeleteData() {
		try {
			//codigo aqui
			
		}catch(Exception erro3){
			JOptionPane.showMessageDialog(null, "Erro de gravação!",null, JOptionPane.ERROR_MESSAGE);
		}
	}

}
