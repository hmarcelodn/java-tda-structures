package tp3;

import impl.ColaLD;
import impl.ColaTI;
import impl.ConjuntoLD;
import api.ColaTDA;
import api.ConjuntoTDA;

public class TP_3_2A {

	public static void main(String[] args) {
		ColaTDA cola = new ColaTI();		
		cola.inicializarCola();
		
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);
		cola.acolar(3);
		cola.acolar(4);
		cola.acolar(4);
		cola.acolar(5);
		
		eliminarRepetidos(cola);
		
		while(!cola.colaVacia()){
			int valor = cola.primero();
			cola.desacolar();
			System.out.print(valor);						
		}
		
	}

	private static void eliminarRepetidos(ColaTDA cola){		
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		ColaTDA colaAux = new ColaLD();
		
		conjuntoAux.inicializarConjunto();
		colaAux.inicializarCola();
		
		while(!cola.colaVacia()){			
			if(!conjuntoAux.pertenece(cola.primero())){
				conjuntoAux.agregar(cola.primero());
				colaAux.acolar(cola.primero());				
			}
			cola.desacolar();
		}
		
		while(!colaAux.colaVacia()){
			cola.acolar(colaAux.primero());
			colaAux.desacolar();
		}		
	}
	
}
