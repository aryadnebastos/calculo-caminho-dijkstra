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

	public void setQuantNos(int novoValor) {
		this.quantNos = novoValor;
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
		No novoNo = new No(elem);
		if (this.eVazia()) {
			this.prim = novoNo;
		} else {
			this.ult.setProximo(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	// retorna o endereço do nó que está contendo o valor a ser procurado.
	public No pesquisarNo(int chave) {
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProximo();
		}
		return atual;
	}



	//  remover determinado Nó
	public boolean removerNó(int x) {
		if (this.eVazia()) {
			return false;
		} else {
			if (this.prim.getInfo().getChave() == x) {
				if (this.prim.getProximo() == null) {// se for único nó da lista
					this.ult = null;
				}
				// remover o primeiro nó da lista
				this.prim = this.prim.getProximo();
			} else {
				No atual = this.prim;
				while ((atual.getProximo() != null) && (atual.getProximo().getInfo().getChave() != x)) {
					atual = atual.getProximo();
				}
				if (atual.getProximo() == null) {// não achou o valor na lista
					return false;
				} else {
					if (atual.getProximo() == this.ult) {// se for o último nó
						atual.setProximo(null);
						this.ult = atual;
					} else { // remove o nó no meio da lista
						atual.setProximo(atual.getProximo().getProximo());
					}
				}
			}
			this.quantNos--;
			return true;

		}
	}

	// mostra todo o conteúdo da lista
	public String toString() {
		String msg = "";
		No atual = this.prim;
		while (atual != null) {
			msg += atual.getInfo().getChave() + "\n";
			atual = atual.getProximo();
		}
		return msg;
	}
	
}
