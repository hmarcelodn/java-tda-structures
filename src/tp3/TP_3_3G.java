package tp3;

import impl.ColaLD;
import impl.ConjuntoLD;
import impl.PilaLD;
import api.ColaTDA;
import api.ConjuntoTDA;
import api.PilaTDA;

public class TP_3_3G {

	public static void main(String[] args) {
		PilaTDA pila = new PilaLD();
		ColaTDA cola = new ColaLD();
		
		pila.inicializarPila();
		cola.inicializarCola();
		
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);	
		cola.acolar(3);	
		
		if(igualesElementos(pila, cola)){
			System.out.print("Cola y Pila Iguales.");
		}
		else{
			System.out.print("No son Iguales.");
		}
	}
	
	private static boolean igualesElementos(PilaTDA pila, ColaTDA cola){
		ConjuntoTDA conjuntoA = new ConjuntoLD();
		ConjuntoTDA conjuntoB = new ConjuntoLD();
		
		conjuntoA.inicializarConjunto();
		conjuntoB.inicializarConjunto();
		
		while(!pila.pilaVacia() || !cola.colaVacia()){
			if(!pila.pilaVacia()){
				if(!conjuntoA.pertenece(pila.tope())){
					conjuntoA.agregar(pila.tope());
					pila.desapilar();					
				}
			}
			
			if(!cola.colaVacia()){
				if(!conjuntoB.pertenece(cola.primero())){
					conjuntoB.agregar(cola.primero());
					cola.desacolar();					
				}
			}
		}		
		
		ConjuntoTDA conjuntoDiferencia = diferenciaSimetrica(conjuntoA, conjuntoB);
		
		return (conjuntoDiferencia.conjuntoVacio());
	}
	
	private static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){						
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		ConjuntoTDA conjuntoRep = new ConjuntoLD();
		
		conjuntoAux.inicializarConjunto();
		conjuntoRep.inicializarConjunto();
		
		// Conjunto A / Comparacion
		while(!conjuntoA.conjuntoVacio()){
			int x = conjuntoA.elegir();
			
			if(conjuntoB.pertenece(x)){
				conjuntoRep.agregar(x);
			}
			else{
				conjuntoAux.agregar(x);
			}
			
			conjuntoA.sacar(x);
		}
		
		// Conjunto B / Comparacion
		while(!conjuntoB.conjuntoVacio()){
			int x = conjuntoB.elegir();
			
			if(!conjuntoRep.pertenece(x)){
				conjuntoAux.agregar(x);
			}
			
			conjuntoB.sacar(x);
		}
		
		return conjuntoAux;
	}

}
