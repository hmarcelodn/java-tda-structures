package impl;

import api.ConjuntoTDA;

public class ConjuntoTA implements ConjuntoTDA {

	private int[] elementos;
	private int cant;
	
	// Costo L
	public void agregar(int x) {
		if(!this.pertenece(x)){
			elementos[cant] = x;
			cant++;
		}
	}

	// Costo C
	public boolean conjuntoVacio() {
		return (cant == 0);
	}

	// Costo C
	public int elegir() {
		return elementos[cant - 1];
	}

	// Costo C
	public void inicializarConjunto() {
		cant = 0;
		elementos = new int[100];
	}

	// Costo L
	public boolean pertenece(int x) {

		int i = 0;
		
		while(i < cant && elementos[i] != x){
			i++;
		}
		
		return (i < cant);
	}

	// Costo L
	public void sacar(int x) {
		int i = 0;
		
		while(i < cant && elementos[i] != x){
			i++;
		}
		
		if(i < cant){
			elementos[i] = elementos[cant - 1];
			cant--;
		}		
	}

}
