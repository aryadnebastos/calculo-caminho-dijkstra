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
import dijkstra.*;

public class MainDrunks {

	static Scanner entrada = new Scanner(System.in);
	static StringBuffer memoria = new StringBuffer();
	static ArrayList<ListaSimples> rotasLista = null;

	static int tamanhoVet = 6;

	public static void main(String[] args) throws IOException {
		int menu;

		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("Digite o que deseja fazer :"
	                + "\n1 - Ler Arquivo txt"
					+ "\n2 - Calcular Menor Rota"
	                + "\n0 - Sair"));
			
			switch(menu){
	        case 1 :
	    		Path path = ReadFile();
	    		
	    		List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
	    		String[] a = list.toArray(new String[list.size()]); 
	    		
	    		rotasLista = InsertData(a);
	    		JOptionPane.showMessageDialog(null, "Inserido com sucesso! Veja o resultado no Console.");
	    		
	        break;
	        
	        case 2:
	        	
	        	CalculatePath();
	        	JOptionPane.showMessageDialog(null,"Rota Calculada");
	        break;

	        case 0:
	        	JOptionPane.showMessageDialog(null,"FIM DA EXECU��O");
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
			JOptionPane.showMessageDialog(null, "Nome de arquivo inv�lido");
		else
			return arquivo.toPath();
		return null;
	}

	static ArrayList<ListaSimples> InsertData(String[] arquivo) {
		ArrayList<ListaSimples> projeto = new ArrayList<ListaSimples>();
		try {
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
				System.out.println(lista.toString());
				projeto.add(lista);
			}
			
			return projeto;
			
		} catch (Exception erro3) {
			JOptionPane.showMessageDialog(null, "Erro de grava��o!", null, JOptionPane.ERROR_MESSAGE);
		}
		return projeto;
	}

	public static void AddOnList(ListaSimples lista, char pontoA, char pontoB, double valor) {
		Item informacao = new Item(pontoA, pontoB, valor);
		lista.inserirUltimo(informacao);
	}
	
	public static void CalculatePath() {

        Dijkstra dijkstra = new Dijkstra();

        
        ListaSimples[] arrayDeLista = rotasLista.toArray(new ListaSimples[rotasLista.size()]);
        
        Vertex v1 = null;
        
	    Vertex v2 = null;

		for (int i = 0; i < arrayDeLista.length; i++) {
			
			No atual = arrayDeLista[i].getPrim();
			
			int contador = 1;
			
		    v1 = new Vertex(atual.getInfo().getPartida() + "");
		    
		    char vertexAux = 0;
		    
		   
			
			while (atual != null) {
				
				char chegada =  atual.getInfo().getChegada();
				
				if (vertexAux != chegada) {
					vertexAux = chegada;
					
				    v2 = new Vertex(chegada + "");
				    
				    v1.addAdjacente(new Edge(atual.getInfo().getQuilometro(), v1, v2));
				} else { 
				    v1.addAdjacente(new Edge(atual.getInfo().getQuilometro(), v1, v2));
				}

				//msg +=  contador+ "- DE: " + atual.getInfo().getPartida() + " PARA: " + atual.getInfo().getChegada() + " DISTANCIA: " + atual.getInfo().getQuilometro() + "\n"  ;
				atual = atual.getProximo();
				contador++;
			}
		
	        dijkstra.calcularRota(v1);
			
			System.out.println(dijkstra.getShortestPathTo(v2));
		}
		

	
	}
	


}
