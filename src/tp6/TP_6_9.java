package tp6;

import impl.GrafoLA;
import api.ConjuntoTDA;
import api.GrafoTDA;

public class TP_6_9 {

	public static void main(String[] args) {
		GrafoTDA grafo= new GrafoLA();
		grafo.inicializarGrafo();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		
		grafo.agregarArista(2, 7, 0);
		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(2, 3, 0); 
		grafo.agregarArista(1, 5, 0);
		grafo.agregarArista(5, 6, 0);
		
		System.out.print("Grado Grafo: " + obtenerGradoGrafo(grafo, 2));
	}
	
	public static int obtenerGradoGrafo(GrafoTDA grafo, int vertice){
		int entrantes = 0;
		int salientes = 0;
		
		ConjuntoTDA vertices = grafo.vertices();
		
		while(!vertices.conjuntoVacio()){
			int verticeAux = vertices.elegir();
			vertices.sacar(verticeAux);
			
			if(grafo.existeArista(verticeAux, vertice)){
				entrantes++;
			}
			
			if(grafo.existeArista(vertice, verticeAux)){
				salientes++;
			}
		}
		
		return (salientes - entrantes);
	}

}
