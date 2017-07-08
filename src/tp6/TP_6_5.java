package tp6;

import impl.GrafoLA;
import api.ConjuntoTDA;
import api.GrafoTDA;

public class TP_6_5 {

	public static void main(String[] args) {
		GrafoTDA grafo= new GrafoLA();
		grafo.inicializarGrafo();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(10);
		grafo.agregarVertice(5);
		
		grafo.agregarArista(1, 2, 2);
		grafo.agregarArista(1, 3, 5); 
		grafo.agregarArista(1, 10, 0);
		grafo.agregarArista(1, 5, 1);
		
		int costo = calcularMayorCostoAristaSaliente(grafo, 1);
		
		System.out.print("Costo: " + costo);
	}

	private static int calcularMayorCostoAristaSaliente(GrafoTDA grafo, int vertice){
		int pesoMayor = Integer.MIN_VALUE;
		ConjuntoTDA vertices = grafo.vertices();
		vertices.sacar(vertice);
		
		while(!vertices.conjuntoVacio()){
			int verticeAux = vertices.elegir();
			
			if(grafo.existeArista(vertice, verticeAux)){
				int pesoArista = grafo.pesoArista(vertice, verticeAux);
				
				if(pesoArista > pesoMayor){
					pesoMayor = pesoArista;
				}
			}
			
			vertices.sacar(verticeAux);
		}
		
		return pesoMayor;
	}
	
}
