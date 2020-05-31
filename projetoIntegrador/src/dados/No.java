package dados;

public class No {
	private Item info;
	private No proximo;
	private No anterior;
	
	
	public No(Item elem) {
		
		this.info = elem;
		this.proximo = null;
		this.anterior = null;
	}


	public Item getInfo() {
		return info;
	}


	public void setInfo(Item info) {
		this.info = info;
	}


	public No getProximo() {
		return proximo;
	}


	public void setProximo(No proximo) {
		this.proximo = proximo;
	}


	public No getAnterior() {
		return anterior;
	}


	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}
	
	
	
	
	
	

	
	
}
