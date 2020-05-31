package dados;

public class ListaDupla {
	
	private No prim;
	private No ult;
	private int totalNo;
	
	public ListaDupla(){
		this.prim = null;
		this.ult = null;
		this.totalNo = 0;
	}
	public int getQuantNos(){
		return this.totalNo;
	}
	public No getPrim(){
		return this.prim;
	}
	public No getUlt(){
		return this.ult;
	}
	public void setQuantNos(int valorNovo){
		this.totalNo = valorNovo;
	}
	public void setPrim(No novoNo){
		this.prim = novoNo;
	}
	public void setUlt(No novoNo){
		this.ult = novoNo;
	}
	public boolean eVazia (){
		return (this.prim == null);
	}
	//insere um novo nó no final da lista ou se a lista estiver vazia, insere
	// o primeiro nó na lista
	public void inserirNo (Item elem){
		No novoNo = new No (elem);
		if (this.eVazia())
			this.prim = novoNo;
		else { 
			novoNo.setAnterior(this.ult);
			this.ult.setProximo(novoNo);
		}	
		this.ult = novoNo;
		this.totalNo++;
	}
	//retorna o endereço do nó que está contendo o valor a ser procurado.
	public No pesquisarNo (int chave){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave))
			atual = atual.getProximo();
		return atual;
	}
	//remove um determinado nó em qualquer posição na lista.
	public boolean removerNo (int chave){
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave()!= chave)){
			atual = atual.getProximo();
		}
		if (atual == null)
			return false;
		else 
			if (atual == this.prim){
				this.prim = prim.getProximo();
				if (this.prim == null) //se a lista tem somente um nó
					this.ult=null;
				else 
					this.prim.setAnterior(null);
			}
			else 
				if (atual == this.ult){
					this.ult = this.ult.getAnterior();
					this.ult.setProximo(null);
				}
				else {
					atual.getProximo().setAnterior(atual.getAnterior());
					atual.getAnterior().setProximo(atual.getProximo());
				}
		this.totalNo--;
		return true;
	}

}
