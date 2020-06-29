package dijkstra;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");

        v1.addAdjacente(new Edge(1, v1, v2));
        v1.addAdjacente(new Edge(10, v1, v2));

        v2.addAdjacente(new Edge(1, v2, v3));

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.calcularRota(v1);

        System.out.println(dijkstra.getShortestPathTo(v3));

	}

}
