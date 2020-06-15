package it.polito.tdp.food.model;

public class Adiacenze {

	private Portion p1;
	private Portion p2;
	private int peso;
	
	
	public Adiacenze(Portion p1, Portion p2, int peso) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.peso = peso;
	}


	public Portion getP1() {
		return p1;
	}


	public Portion getP2() {
		return p2;
	}


	public int getPeso() {
		return peso;
	}


	@Override
	public String toString() {
		return p1.getPortion_display_name() + " - " + p2.getPortion_display_name() + " | " + peso;
	}
	
	
	
}
