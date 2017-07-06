package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadStruct implements ColaPrioridadTDA {

	private class Elemento{		
		int valor;
		int prioridad;
	}
	
	private Elemento[] elementos;
	private int indice;
	
	// Costo C
	public void inicializarCola() {
		indice = 0;
		elementos = new Elemento[100];
	}

	// Costo C con elementos de mayor prioridad a los existentes.
	// Cost L con elementos de menor prioridad a los existentes.
	public void acolarPrioridad(int x, int prioridad) {
		int j = indice;
		
		for(; j > 0 && elementos[j - 1 ].prioridad >= prioridad; j--){
			elementos[j] = elementos[j - 1];
		}
		
		elementos[j] = new Elemento();
		elementos[j].prioridad = prioridad;
		elementos[j].valor = x;
		indice++;
	}

	// Costo C
	public void desacolar() {
		elementos[indice - 1] = null;
		indice--;
	}

	// Costo C
	public int primero() {
		return elementos[indice - 1].valor;
	}

	// Costo C
	public boolean colaVacia() {
		return (indice == 0);
	}

	// Costo C
	public int prioridad() {
		return elementos[indice - 1].prioridad;
	}

}
