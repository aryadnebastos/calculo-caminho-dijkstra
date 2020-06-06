package dados;

public class Item {
	private double quilometro;
	private char partida;
	private char chegada;
	
	public Item (char partida, char chegada, double quilometro){
		this.quilometro = quilometro;
		this.partida = partida;
		this.chegada = chegada;
	}

	public double getQuilometro() {
		return quilometro;
	}

	public void setQuilometro(double quilometro) {
		this.quilometro = quilometro;
	}

	public char getPartida() {
		return partida;
	}

	public void setPartida(char partida) {
		this.partida = partida;
	}

	public char getChegada() {
		return chegada;
	}

	public void setChegada(char chegada) {
		this.chegada = chegada;
	}
	
	
}
