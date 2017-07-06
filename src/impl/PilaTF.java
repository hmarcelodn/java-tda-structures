package impl;

import api.PilaTDA;

public class PilaTF implements PilaTDA {

	private int[] arr;
	private int indice;
	
	// Costo C
	public void inicializarPila() {
		arr = new int[100];
		indice = 0;
	}

	// Costo C
	public void apilar(int x) {
		arr[indice] = x;
		indice++;
	}

	// Costo C
	public void desapilar() {
		indice--;
	}

	// Costo C
	public boolean pilaVacia() {
		return (indice == 0);
	}

	// Costo C
	public int tope() {
		return arr[indice - 1];
	}

}
