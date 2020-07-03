package projetoIntegrador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	//GRUPO: ARYADNE BASTOS, ROGÉRIO, PEDRO ARAUJO;
	//PROJETO INTEGRADOR: ESTRUTURA DE DADOS E MATEMÁTICA DISCRETA;
	//PROFESSORES ORIENTADORES: DANIEL OLIVEIRA, RENATA LARANJA, ELIANA CAUS;

	static Scanner entrada = new Scanner(System.in);
	static StringBuffer memoria = new StringBuffer();
	static ArrayList<ListaSimples> rotasLista = null;

	static int tamanhoVet = 6;

	public static void main(String[] args) throws IOException {
		int menu;

		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("Digite o que deseja fazer :" + "\n1 - Ler Arquivo txt"
					+ "\n2 - Calcular Menor Rota" + "\n0 - Sair"));

			switch (menu) {
			case 1:
				Path path = lerArquivo();

				List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
				String[] a = list.toArray(new String[list.size()]);

				rotasLista = InsertData(a);
				JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

				break;

			case 2:

				calcularRota();
				JOptionPane.showMessageDialog(null, "Rota Calculada");
				break;

			case 0:
				JOptionPane.showMessageDialog(null, "FIM DA EXECUÇÃO");
				break;
			}

		} while (menu != 0);

	}

	// metodo pra ler o arquivo TXT com as informações
	public static Path lerArquivo() {
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
	//insere os dados 
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

					addNaLista(lista, pontoA, pontoB, distancia);
				}
				
				projeto.add(lista);
			}
			System.out.println("ARQUIVO LIDO COM SUCESSO");
			return projeto;

		} catch (Exception erro3) {
			JOptionPane.showMessageDialog(null, "Erro de gravação!", null, JOptionPane.ERROR_MESSAGE);
		}
		return projeto;
	}

	//adiciona na lista
	public static void addNaLista(ListaSimples lista, char pontoA, char pontoB, double valor) {
		Item informacao = new Item(pontoA, pontoB, valor);
		lista.inserirUltimo(informacao);
	}

	public static void calcularRota() {

		Dijkstra dijkstra = new Dijkstra();

		ListaSimples[] arrayDeLista = rotasLista.toArray(new ListaSimples[rotasLista.size()]);

		// armazena as informações
		Map<String, Vertex> map = new HashMap<String, Vertex>();

		Vertex teste = map.get("A");

		for (int i = 0; i < arrayDeLista.length; i++) {

			No atual = arrayDeLista[i].getPrim();

			map.put(atual.getInfo().getPartida() + "", new Vertex(atual.getInfo().getPartida() + ""));
		}

		// coleta informação da partida
		for (int i = 0; i < arrayDeLista.length; i++) {

			No atual = arrayDeLista[i].getPrim();

			Vertex v1 = map.get(atual.getInfo().getPartida() + "");

			// pra coletar a informação da chegada
			while (atual != null) {

				char chegada = atual.getInfo().getChegada();

				Vertex v2 = map.get(chegada + "");

				v1.addAdjacente(new Edge(atual.getInfo().getQuilometro(), v1, v2));

				atual = atual.getProximo();

			}

		}
		// calcula menor rota entre os pontos

		dijkstra.calcularRota(map.get("A"));

		char rota;

		// escolhe o destino e calcula

		rota = JOptionPane
				.showInputDialog("Escolha o destino:" + "\nB" + "\nC" + "\nD" + "\nE" + "\nF" + "\nG" + "\nH").charAt(0);
		rota = Character.toUpperCase(rota);
		
		JOptionPane.showMessageDialog(null,"A menor rota para este ponto é: " + dijkstra.getMenorRotaPara(map.get(rota + "")));

	}

}
