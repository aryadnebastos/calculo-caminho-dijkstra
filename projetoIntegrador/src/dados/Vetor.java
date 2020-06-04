package dados;

public class Vetor {
	private ListaSimples [] vertices;
	
	public Vetor (int tamanho) {
		this.vertices = new ListaSimples[tamanho];
	}

	public Vetor(ListaSimples[] vertices) {
		this.vertices = vertices;
	}

	public ListaSimples[] getVertices() {
		return vertices;
	}

	public void setVertices(ListaSimples[] vertices) {
		this.vertices = vertices;
	}
	
	
	

}
