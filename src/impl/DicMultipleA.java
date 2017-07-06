package impl;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class DicMultipleA implements DiccionarioMultipleTDA {

	private class Elemento{
		int clave;
		int cant;
		int[] valores;
	}
	
	private Elemento[] elementos;
	private int cant;	
	
	// Costo L
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
			elementos[cant].valores = new int[100];
			elementos[cant].valores[0] = valor;
			elementos[cant].cant++;
			cant++;
		}
		else{
			Elemento el = elementos[pos];				
			el.valores[el.cant] = valor;	
			el.cant++;
		}	
	}

	// Costo L
	public int clave2Indice(int clave) {		
		int i = cant - 1;
		
		while(i >= 0 && elementos[i].clave != clave){
			i--;
		}
		
		return i;
	}

	// Costo L
	public int clave2Indice(Elemento e, int valor){
		int i = e.cant;
		
		while(i >= 0 && e.valores[i] != valor){
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
	public void eliminarValor(int clave, int valor) {
		int pos = this.clave2Indice(clave);
		
		if(pos != -1){
			Elemento el = elementos[pos];
			
			int posV = clave2Indice(el, valor);
			
			if(posV != -1){
				el.valores[posV] = el.valores[el.cant - 1];
				el.cant--;
				
				if(el.cant == -1){
					eliminarClave(clave);
				}
			}
		}
	}	

	// Costo L
	public ConjuntoTDA claves() {
		ConjuntoTDA conjuntoClaves = new ConjuntoTA();
		conjuntoClaves.inicializarConjunto();
		
		for(int i = 0; i < cant; i++){
			conjuntoClaves.agregar(elementos[i].clave);
		}
		
		
		return conjuntoClaves;
	}

	// Costo L
	public ConjuntoTDA recuperar(int clave) {
		int pos = this.clave2Indice(clave);
		
		ConjuntoTDA conjuntoValores = new ConjuntoTA();
		conjuntoValores.inicializarConjunto();
		
		if(pos != -1){
			Elemento e = elementos[pos];
			
			for(int i = 0; i < e.cant; i++){
				conjuntoValores.agregar(e.valores[i]);
			}
		}
		
		return conjuntoValores;
	}

}
