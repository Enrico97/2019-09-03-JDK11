package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	FoodDao dao = new FoodDao();
	Graph<Portion, DefaultWeightedEdge> grafo;
	
	
	public Graph<Portion, DefaultWeightedEdge> creaGrafo(int calorie) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo, dao.vertici(calorie));
		for (Adiacenze a : dao.archi()) {
			if(grafo.vertexSet().contains(a.getP1()) && grafo.vertexSet().contains(a.getP2()))
				Graphs.addEdge(grafo, a.getP1(), a.getP2(), a.getPeso());
		}
		return grafo;
	}
	
	public List<Portion> box() {
		List<Portion> box = new ArrayList<>();
		for(Portion p : grafo.vertexSet())
			box.add(p);
		return box;
	}
	
	public List<Portion> vicini(Portion p) {
		List<Portion> vicini = new ArrayList<>();
		vicini.addAll(Graphs.neighborListOf(grafo, p));
		return vicini;
	}
}
