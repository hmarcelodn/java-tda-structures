package impl;

import api.ColaTDA;

// Estrategia 1: Primero ultimo en el arreglo.
public class ColaPU implements ColaTDA{

	private int[] elementos;
	private int indice;
	
	// Costo C
	public void inicializarCola() {
		indice = 0;
		elementos = new int[100];
	}

	// Costo L
	public void acolar(int x) {
		for(int i = indice; i >= 0; i--){
			elementos[i] = elementos[i - 1];
		}
		
		elementos[0] = x;
		indice++;
	}

	// Costo C
	public void desacolar() {
		indice--;
	}

	// Costo C
	public boolean colaVacia() {
		return (indice == 0);
	}

	// Costo C
	public int primero() {
		return elementos[indice];
	}

}
