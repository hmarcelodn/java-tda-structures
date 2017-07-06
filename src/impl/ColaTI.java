package impl;

import api.ColaTDA;

// Estrategia 2: Primero al Principio / Tope Inicial
public class ColaTI implements ColaTDA{

	private int[] elementos;
	private int indice;
	
	// Costo C
	public void inicializarCola() {
		elementos = new int[100];
		indice = 0;
	}

	// Costo C
	public void acolar(int x) {
		elementos[indice] = x;
		indice++;
	}

	// Costo L
	public void desacolar() {
		for(int i = 0; i < indice; i++){
			elementos[i] = elementos[i + 1];
		}
		
		indice--;
	}

	// Costo C
	public boolean colaVacia() {
		return (indice == 0);
	}
	
	// Costo C
	public int primero() {
		return elementos[0];
	}

}
