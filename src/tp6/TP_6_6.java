package tp6;

import impl.ConjuntoLD;
import impl.GrafoLA;
import api.ConjuntoTDA;
import api.GrafoTDA;

public class TP_6_6 {

	public static void main(String[] args) {
		GrafoTDA grafo= new GrafoLA();
		grafo.inicializarGrafo();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(10);
		grafo.agregarVertice(4);
		
		grafo.agregarArista(1, 10, 0);
		grafo.agregarArista(2, 10, 0); 
		grafo.agregarArista(3, 10, 0);
		grafo.agregarArista(4, 10, 0);
		
		ConjuntoTDA predecesores = obtenerPredecesores(grafo, 10);
		
		while(!predecesores.conjuntoVacio()){
			int vertice = predecesores.elegir();
			predecesores.sacar(vertice);
			
			System.out.print("Predecesor: " + vertice + "\n");
		}
	}
	
	public static ConjuntoTDA obtenerPredecesores(GrafoTDA grafo, int vertice){
		ConjuntoTDA predecesores = new ConjuntoLD();
		predecesores.inicializarConjunto();
		
		ConjuntoTDA vertices = grafo.vertices();
		
		while(!vertices.conjuntoVacio()){
			int verticeAux = vertices.elegir();			
			
			if(grafo.existeArista(verticeAux, vertice)){
				predecesores.agregar(verticeAux);
			}
			
			vertices.sacar(verticeAux);
		}
		
		return predecesores;
	}

}
