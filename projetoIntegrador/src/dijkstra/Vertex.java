package dijkstra;

import java.util.ArrayList;
import java.util.List;

import dijkstra.Edge;

public class Vertex implements Comparable<Vertex> {
    private String nome;
    private List<Edge> edges;
    private boolean visitado;
    private Vertex vertexAnterior;
    private double distanciaMin = Double.MAX_VALUE;

    public Vertex(String nome) {
        this.nome = nome;
        this.edges = new ArrayList<>();
    }

    public void addAdjacente(Edge edge) {
        this.edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public boolean eVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visited) {
        this.visitado = visited;
    }

    public Vertex getVertexAnterior() {
        return vertexAnterior;
    }

    public void setVertexAnterior(Vertex previosVertex) {
        this.vertexAnterior = previosVertex;
    }

    public double getDistanciaMin() {
        return distanciaMin;
    }

    public void setDistanciaMin(double minDistance) {
        this.distanciaMin = minDistance;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distanciaMin, otherVertex.distanciaMin);
    }
}