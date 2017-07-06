package impl;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class GrafoLA implements GrafoTDA{

	private class NodoGrafo{
		int nodo;
		NodoGrafo sigNodo;
		NodoArista arista;
	}
	
	private class NodoArista{
		int etiqueta;
		NodoGrafo nodoDestino;
		NodoArista sigArista;
	}
	
	public void inicializarGrafo() {
		// TODO Auto-generated method stub
		
	}

	public void agregarVertice(int v) {
		// TODO Auto-generated method stub
		
	}

	public void eliminarVertice(int v) {
		// TODO Auto-generated method stub
		
	}

	public ConjuntoTDA vertices() {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregarArista(int v1, int v2, int peso) {
		// TODO Auto-generated method stub
		
	}

	public void eliminarArista(int v1, int v2) {
		// TODO Auto-generated method stub
		
	}

	public boolean existeArista(int v1, int v2) {
		// TODO Auto-generated method stub
		return false;
	}

	public int pesoArista(int v1, int v2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
