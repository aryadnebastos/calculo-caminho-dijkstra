package projetoIntegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import dados.*;

public class MainDrunks {

	static Scanner entrada = new Scanner(System.in);
	static StringBuffer memoria = new StringBuffer();

	static int tamanhoVet = 6;

	public static void main(String[] args) throws IOException {
		int menu;
		
		Path path = ReadFile();
		
		List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
		String[] a = list.toArray(new String[list.size()]); 

		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("Digite o que deseja fazer :"
	                + "\n1 - Inserir Dados"
	                + "\n0 - Sair"));
			
			switch(menu){
	        case 1 :
	    		InsertData(a);
	        break;

	        case 0:
	        	JOptionPane.showInputDialog("FIM DA EXECUÇÃO");
	        break;
			}
			
		}while(menu != 0);
		
		

	}

	public static Path ReadFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.CANCEL_OPTION)
			return null;
		File arquivo = fileChooser.getSelectedFile();
		if (arquivo == null || arquivo.getName().equals(""))
			JOptionPane.showMessageDialog(null, "Nome de arquivo inválido");
		else
			return arquivo.toPath();
		return null;
	}

	static void InsertData(String[] arquivo) {

		try {
			ArrayList<ListaSimples> projeto = new ArrayList<ListaSimples>();

			for (int i = 0; i < arquivo.length; i++) {
				ListaSimples lista = new ListaSimples();
				String[] informacoes = arquivo[i].split(";");
				for (int j = 0; j < informacoes.length; j++) {
					String[] valores = informacoes[j].split("\t");

					char pontoA = valores[0].charAt(0);
					char pontoB = valores[1].charAt(0);
					double distancia = Double.parseDouble(valores[2]);

					AddOnList(lista, pontoA, pontoB, distancia);
				}
				projeto.add(lista);
			}
		} catch (Exception erro3) {
			JOptionPane.showMessageDialog(null, "Erro de gravação!", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void AddOnList(ListaSimples lista, char pontoA, char pontoB, double valor) {
		Item informacao = new Item(pontoA, pontoB, valor);
		lista.inserirUltimo(informacao);
	}
	


}
