package dados;

public class ListaSimples {

	private No prim;
	private No ult;
	private int quantNos;

	public ListaSimples() {
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public No getPrim() {
		return this.prim;
	}

	public No getUlt() {
		return this.ult;
	}

	public void setQuantNos() {
		this.quantNos = quantNos++;
	}

	public void setPrim(No novoNo) {
		this.prim = novoNo;
	}

	public void setUlt(No novoNo) {
		this.ult = novoNo;
	}

	public boolean eVazia() {
		return (this.prim == null);
	}

	// insere um novo nó no final da lista ou se a lista estiver vazia, insere o
	// primeiro nó na lista
	public void inserirUltimo(Item elem) {
		No novoNo = new No(elem, null);
		if (this.eVazia()) {
			this.prim = novoNo;
		} else {
			this.ult.setProximo(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	// retorna o endereço do nó que está contendo o valor a ser procurado.
	public No pesquisarNo( char busca) {
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChegada() != busca)) {
			atual = atual.getProximo();
		}
		return atual;
	}


	// mostra todo o conteúdo da lista
	public String toString() {
		String msg = "";
		No atual = this.prim;
		int contador = 1;
		while (atual != null) {
			msg +=  contador+ "- DE: " + atual.getInfo().getPartida() + " PARA: " + atual.getInfo().getChegada() + " DISTANCIA: " + atual.getInfo().getQuilometro() + "\n"  ;
			atual = atual.getProximo();
			contador++;
		}
		return msg;
	}
	
}
