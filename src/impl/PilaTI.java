package impl;

import api.PilaTDA;

public class PilaTI implements PilaTDA {

	private int[] arr;
	private int indice;
	
	// Costo C
	public void inicializarPila() {		
		arr = new int[100];
		indice = 0;
	}

	// Costo L
	public void apilar(int x) {
		for(int i = (indice - 1); i >= 0; i--){
			arr[i + 1] = arr[i];
		}
		
		arr[0] = x;
		indice++;
	}

	// Costo L
	public void desapilar() {
		for(int i = 0; i < indice; i++){
			arr[i] = arr[i + 1];
		}
		
		indice--;
	}
	
	// Costo C
	public boolean pilaVacia() {
		return (indice == 0);
	}

	// Costo C
	public int tope() {
		return arr[0];
	}

}
