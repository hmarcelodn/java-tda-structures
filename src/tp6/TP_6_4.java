package tp6;

import api.ColaTDA;
import api.ConjuntoTDA;
import api.GrafoTDA;
import impl.ColaLD;
import impl.ConjuntoLD;
import impl.GrafoLA;
import impl.GrafoMA;

public class TP_6_4 {

	public static void main(String[] args) {
		GrafoTDA grafo= new GrafoLA();
		grafo.inicializarGrafo();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(10);
		grafo.agregarVertice(5);
		
		grafo.agregarArista(1, 2, 0); // 1 > 2
		grafo.agregarArista(2, 3, 0); // 2 > 3
		grafo.agregarArista(1, 10, 0); // 1 > 10 // No es doblemente adyacente	
		grafo.agregarArista(10, 5, 0);
		
		// Busco doble adyacencia
		ConjuntoTDA conjunto = verticesDobleAdyacencia(grafo, 1);
		
		while(!conjunto.conjuntoVacio()){
			int dobleAdyacente = conjunto.elegir();
			System.out.print(dobleAdyacente + "\n");
			conjunto.sacar(dobleAdyacente);
		}
	}
	
	private static ConjuntoTDA verticesDobleAdyacencia(GrafoTDA grafo, int verticeOrigen){
		
		ConjuntoTDA vertices = grafo.vertices();
		vertices.sacar(verticeOrigen);
		
		ConjuntoTDA verticesMedios = new ConjuntoLD();		
		ConjuntoTDA verticesDobles = new ConjuntoLD();
		ColaTDA verticesNoMedios = new ColaLD();
		
		verticesDobles.inicializarConjunto();
		verticesMedios.inicializarConjunto();
		verticesNoMedios.inicializarCola();
		
		// Busco los vertices conectados a v y los saco del conjunto
		while(!vertices.conjuntoVacio()){
			int verticeDestino = vertices.elegir();
			
			if(grafo.existeArista(verticeOrigen, verticeDestino)){
				verticesMedios.agregar(verticeDestino);				
			}
			else{
				verticesNoMedios.acolar(verticeDestino);
			}
			
			vertices.sacar(verticeDestino);
		}		
		
		// Busco aquellos vertices restantes y verifico que esten conectados a los nodos anteriores						
		while(!verticesMedios.conjuntoVacio()){
			int verticeMedio = verticesMedios.elegir();
			int primero = Integer.MIN_VALUE;
			
			while(!(verticesNoMedios.primero() == primero)){
				int verticeDoble = verticesNoMedios.primero();
				
				if(grafo.existeArista(verticeMedio, verticeDoble)){
					verticesDobles.agregar(verticeDoble);				
				}

				verticesNoMedios.desacolar();
				verticesNoMedios.acolar(verticeDoble);	
				
				if(primero == Integer.MIN_VALUE){
					primero = verticeDoble;
				}
			}		
			
			verticesMedios.sacar(verticeMedio);
		}
		
		return verticesDobles;
		
	}

}
