package impl;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DicSimpleA implements DiccionarioSimpleTDA {

	private class Elemento{
		int clave;
		int valor;
	}
	
	private int cant;
	private Elemento[] elementos;
	
	// Costo C
	public void inicializarDiccionario() {
		elementos = new Elemento[100];
		cant = 0;
	}

	// Costo L
	public void agregar(int clave, int valor) {
		int pos = this.clave2Indice(clave);
		
		if(pos == -1){
			elementos[cant] = new Elemento();
			elementos[cant].clave = clave;
			elementos[cant].valor = valor;
		}
		
		cant++;
	}

	// Costo L
	public int clave2Indice(int clave) {		
		int i = cant;
		
		while(i < cant && elementos[i].clave != clave){
			i--;
		}
		
		return i;
	}

	// Costo L
	public void eliminarClave(int clave) {
		int pos = this.clave2Indice(clave);
		
		if(pos != -1){
			elementos[pos] = elementos[cant - 1];
			cant--;
		}
	}

	// Costo L
	public int recuperar(int clave) {
		int pos = this.clave2Indice(clave);
		return elementos[pos].valor;
	}

	// Costo L
	public ConjuntoTDA claves() {
		
		ConjuntoTDA claves = new ConjuntoTA();
		claves.inicializarConjunto();
		
		for(int i = 0; i < cant; i++){
			claves.agregar(elementos[i].clave);
		}
		
		return claves;
	}

}
