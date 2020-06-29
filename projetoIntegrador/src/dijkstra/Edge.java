package dijkstra;

public class Edge {
    private double peso;
    private Vertex vertexInicial;
    private Vertex verticeDestino;

    public Edge(double peso, Vertex vertexInicial, Vertex verticeDestino) {
        this.peso = peso;
        this.vertexInicial = vertexInicial;
        this.verticeDestino = verticeDestino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Vertex getVerticeInicial() {
        return vertexInicial;
    }

    public void setVerticeInicial(Vertex verticeInicial) {
        this.vertexInicial = verticeInicial;
    }

    public Vertex getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(Vertex verticeDestino) {
        this.verticeDestino = verticeDestino;
    }
}