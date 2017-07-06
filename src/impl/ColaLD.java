package impl;

import api.ColaTDA;

public class ColaLD implements ColaTDA {

	class Nodo{
		public int info;
		public Nodo sig;
	}
	
	private Nodo primero;
	private Nodo ultimo;
	
	public void inicializarCola() {
		primero = null;
		ultimo = null;
	}

	public void acolar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = null;
		
		if(ultimo != null){
			ultimo.sig = aux;
		}
		
		ultimo = aux;
		
		
		if(primero == null){
			primero = ultimo;
		}
	}

	public void desacolar() {
		primero = primero.sig;
		
		if(primero == null){
			ultimo = null;
		}
	}

	public boolean colaVacia() {
		return (ultimo == null);
	}

	public int primero() {
		return primero.info;
	}

}
