package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

	public void calcularRota(Vertex vertexOrigem) {
		vertexOrigem.setDistanciaMin(0);
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(vertexOrigem);

		while (!priorityQueue.isEmpty()) {
			Vertex vertex = priorityQueue.poll();

			for (Edge edge : vertex.getEdges()) {
				Vertex v = edge.getVerticeDestino();
//                Vertex u = edge.getStartVertex();
				double peso = edge.getPeso();
				double minDistance = vertex.getDistanciaMin() + peso;

				if (minDistance < v.getDistanciaMin()) {
					priorityQueue.remove(vertex);
					v.setVertexAnterior(vertex);
					v.setDistanciaMin(minDistance);
					priorityQueue.add(v);
				}
			}
		}
	}

	// calcula a menor rota pro ponto alvo
	public List<Vertex> getMenorRotaPara(Vertex vertexAlvo) {
		List<Vertex> rota = new ArrayList<>();

		for (Vertex vertex = vertexAlvo; vertex != null; vertex = vertex.getVertexAnterior()) {
			rota.add(vertex);
		}

		Collections.reverse(rota);
		return rota;
	}
}