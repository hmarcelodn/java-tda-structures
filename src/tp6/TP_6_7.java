package tp6;

import impl.ColaLD;
import impl.ConjuntoLD;
import impl.GrafoLA;
import api.ColaTDA;
import api.ConjuntoTDA;
import api.GrafoTDA;

public class TP_6_7 {

	public static void main(String[] args) {
		GrafoTDA grafo= new GrafoLA();
		grafo.inicializarGrafo();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(10);
		grafo.agregarVertice(4);
		grafo.agregarVertice(7);
		
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(2, 3, 0); 
		grafo.agregarArista(3, 10, 0);
		grafo.agregarArista(4, 10, 0);
		
		ConjuntoTDA aislados = obtenerVerticesAislados(grafo);
		
		while(!aislados.conjuntoVacio()){
			int vertice = aislados.elegir();
			aislados.sacar(vertice);
			
			System.out.print("Predecesor: " + vertice + "\n");
		}
	}
	
	private static ConjuntoTDA obtenerVerticesAislados(GrafoTDA grafo){
		ConjuntoTDA aislados = new ConjuntoLD();
		ConjuntoTDA vertices = grafo.vertices();
		ConjuntoTDA verticesAux = grafo.vertices();
		ColaTDA colaVertices = new ColaLD();
		
		aislados.inicializarConjunto();
		colaVertices.inicializarCola();
		
		while(!vertices.conjuntoVacio()){
			int vertice = vertices.elegir();
			
			colaVertices.acolar(vertice);
			vertices.sacar(vertice);
		}
		
		while(!verticesAux.conjuntoVacio()){
			int vertice = verticesAux.elegir();
			int primero = Integer.MIN_VALUE;
			
			while(!(colaVertices.primero() == primero)){
				int verticeAux = colaVertices.primero();
				colaVertices.desacolar();
				colaVertices.acolar(verticeAux);
				
				if(primero == Integer.MIN_VALUE){
					primero = verticeAux;
				}
				
				if(grafo.existeArista(vertice, verticeAux) || grafo.existeArista(verticeAux, vertice)){
					break;
				}
				
				if(colaVertices.primero() == primero){
					aislados.agregar(vertice);
				}								
			}
			
			verticesAux.sacar(vertice);			
		}		
		
		return aislados;
	}

}
