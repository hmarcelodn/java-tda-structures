package impl;

import api.PilaTDA;

public class PilaLD implements PilaTDA {

	class Nodo{
		public int info;
		public Nodo sig;
	}
	
	Nodo primero;
	
	public void inicializarPila() {
		primero = null;
	}

	public void apilar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = primero;
		
		primero = aux;
	}

	public void desapilar() {
		primero = primero.sig;
	}

	public boolean pilaVacia() {
		return (primero == null);
	}

	public int tope() {
		return primero.info;
	}

}
