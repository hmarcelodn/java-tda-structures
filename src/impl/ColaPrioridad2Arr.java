package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridad2Arr implements ColaPrioridadTDA {

	private int[] elementos;
	private int[] prioridades;
	private int indice;

	// Costo C
	public void inicializarCola() {
		indice = 0;
		elementos = new int[100];
		prioridades = new int[100];		
	}

	// Costo C con elementos de mayor prioridad a los existentes.
	// Cost L con elementos de menor prioridad a los existentes.
	public void acolarPrioridad(int x, int prioridad) {
		int j = indice;
		
		for(; j > 0 && prioridades[j - 1] >= prioridad; j--){
			elementos[j] = elementos[j - 1];
			prioridades[j] = prioridades[j - 1];
		}
		
		elementos[j] = x;
		prioridades[j] = prioridad;
		indice++;
	}

	// Costo C	
	public void desacolar() {
		indice--;
	}

	// Costo C	
	public int primero() {
		return elementos[indice - 1];
	}

	// Costo C	
	public boolean colaVacia() {
		return (indice == 0);
	}

	// Costo C
	public int prioridad() {
		return prioridades[indice - 1];
	}

}
