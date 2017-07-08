package tp6;

import impl.ConjuntoLD;
import impl.GrafoLA;
import api.ConjuntoTDA;
import api.GrafoTDA;

public class TP_6_8 {

	public static void main(String[] args) {
		GrafoTDA grafo= new GrafoLA();
		grafo.inicializarGrafo();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(2, 3, 0); 
		grafo.agregarArista(1, 5, 0);
		grafo.agregarArista(5, 6, 0);
		
		ConjuntoTDA puentes1 = obtenerVerticesPuente(grafo, 1, 3);
		ConjuntoTDA puentes2 = obtenerVerticesPuente(grafo, 1, 6);
		
		while(!puentes1.conjuntoVacio()){
			int vertice = puentes1.elegir();
			puentes1.sacar(vertice);
			
			System.out.print("Puente: " + vertice + "\n");
		}		
		
		while(!puentes2.conjuntoVacio()){
			int vertice = puentes2.elegir();
			puentes2.sacar(vertice);
			
			System.out.print("Puente: " + vertice + "\n");
		}			
	}
	
	private static ConjuntoTDA obtenerVerticesPuente(GrafoTDA grafo, int vertice01, int vertice02){
		ConjuntoTDA puentes = new ConjuntoLD();
		puentes.inicializarConjunto();
		
		ConjuntoTDA vertices = grafo.vertices();
		
		while(!vertices.conjuntoVacio()){
			int verticeAux = vertices.elegir();
			vertices.sacar(verticeAux);
			
			if(grafo.existeArista(vertice01, verticeAux) && grafo.existeArista(verticeAux, vertice02)){
				puentes.agregar(verticeAux);
			}
		}
		
		return puentes;
	}

}
