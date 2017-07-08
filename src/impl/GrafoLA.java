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
	
	NodoGrafo origen;
	
	public void inicializarGrafo() {
		origen = null;
	}

	public void agregarVertice(int v) {
		NodoGrafo aux = new NodoGrafo();
		aux.nodo = v;
		aux.arista = null;
		aux.sigNodo = origen;
		origen = aux;
	}

	public void eliminarVertice(int v) {
		if(origen.nodo== v){
			origen = origen.sigNodo;
		}
		
		NodoGrafo aux = origen;
		
		while(aux != null){
			
			// Elimina Aristas que van hacia v
			this.eliminarAristaNodo(aux, v);
			
			// Elimina Nodo
			if(aux.sigNodo != null && aux.sigNodo.nodo == v){
				aux.sigNodo = aux.sigNodo.sigNodo;
			}
			
			aux = aux.sigNodo;
		}
		
	}

	public ConjuntoTDA vertices() {
		
		ConjuntoTDA conjuntoVertices = new ConjuntoLD();
		conjuntoVertices.inicializarConjunto();
		
		NodoGrafo aux = origen;
		
		while(aux != null){
			conjuntoVertices.agregar(aux.nodo);
			aux = aux.sigNodo;
		}
		
		return conjuntoVertices;
	}

	public void agregarArista(int v1, int v2, int peso) {
		NodoGrafo auxOrigen = vert2Nodo(v1);
		NodoGrafo auxDestino = vert2Nodo(v2);
			
		NodoArista aristaAux = new NodoArista();
		aristaAux.etiqueta = peso;
		aristaAux.nodoDestino = auxDestino;
		aristaAux.sigArista = auxOrigen.arista;
		auxOrigen.arista = aristaAux;		
	}
	
	public void eliminarArista(int v1, int v2) {
		NodoGrafo auxOrigen = this.vert2Nodo(v1);		
		this.eliminarAristaNodo(auxOrigen, v2);
	}

	public boolean existeArista(int v1, int v2) {
		NodoArista arista = destino2Arista(v1, v2);
		
		return (arista != null);
	}

	public int pesoArista(int v1, int v2) {
		NodoArista arista = destino2Arista(v1, v2);
		
		return arista.etiqueta;
	}
	
	private void eliminarAristaNodo(NodoGrafo nodo, int v){
		NodoArista auxArista = nodo.arista;
		
		if(auxArista.nodoDestino.nodo == v){
			nodo.arista = auxArista.sigArista;
		}
		else{
			while(auxArista.sigArista != null && auxArista.sigArista.nodoDestino.nodo != v){
				auxArista = auxArista.sigArista.sigArista;
			}				
			
			if(auxArista != null){
				auxArista.sigArista = auxArista.sigArista.sigArista;
			}
		}	
	}
	
	private NodoGrafo vert2Nodo(int n){
		NodoGrafo aux = origen;
		
		while(aux != null && aux.nodo != n){
			aux = aux.sigNodo;
		}		
		
		return aux;
	}

	
	private NodoArista destino2Arista(int v1, int v2){
		NodoGrafo auxNodo = this.vert2Nodo(v1);
		NodoArista auxArista = auxNodo.arista;
		
		while(auxArista != null && auxArista.nodoDestino.nodo != v2){
			auxArista = auxArista.sigArista;
		}
		
		return auxArista;
	}

}
