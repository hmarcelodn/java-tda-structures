package tp3;

import impl.ColaLD;
import impl.ConjuntoLD;
import impl.PilaLD;
import api.ColaTDA;
import api.ConjuntoTDA;
import api.PilaTDA;

public class TP_3_3F {

	public static void main(String[] args) {
		PilaTDA pila = new PilaLD();
		ColaTDA cola = new ColaLD();
		
		pila.inicializarPila();
		cola.inicializarCola();
		
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		
		cola.acolar(1);
		cola.acolar(4);
		cola.acolar(3);
		
		ConjuntoTDA conjuntoComun = obtenerConjuntoComun(pila, cola);
		
		while(!conjuntoComun.conjuntoVacio()){
			int x = conjuntoComun.elegir();			
			System.out.print(x + "\n");
			conjuntoComun.sacar(x);
		}
	}
	
	private static ConjuntoTDA interseccion(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){
		ConjuntoTDA conjuntoInterseccion = new ConjuntoLD();
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		
		conjuntoInterseccion.inicializarConjunto();		
		conjuntoAux.inicializarConjunto();

		while(!conjuntoA.conjuntoVacio()){
			int x = conjuntoA.elegir();
			
			if(conjuntoB.pertenece(x)){
				if(!conjuntoInterseccion.pertenece(x)){
					conjuntoInterseccion.agregar(x);
				}				
			}
			
			conjuntoA.sacar(x);
			conjuntoAux.agregar(x);
		}
		
		while(!conjuntoAux.conjuntoVacio()){
			conjuntoA.agregar(conjuntoAux.elegir());
			conjuntoAux.sacar(conjuntoAux.elegir());
		}
		
		return conjuntoInterseccion;		
	}
	
	private static ConjuntoTDA obtenerConjuntoComun(PilaTDA pila, ColaTDA cola){
		ConjuntoTDA conjuntoPila = new ConjuntoLD();
		ConjuntoTDA conjuntoCola = new ConjuntoLD();
		ConjuntoTDA conjuntoInterseccion = new ConjuntoLD();
		
		conjuntoPila.inicializarConjunto();
		conjuntoCola.inicializarConjunto();
		
		while(!pila.pilaVacia() || !cola.colaVacia()){
			if(!pila.pilaVacia()){
				conjuntoPila.agregar(pila.tope());
				pila.desapilar();
			}
			
			if(!cola.colaVacia()){
				conjuntoCola.agregar(cola.primero());
				cola.desacolar();
			}
		}
		
		conjuntoInterseccion = interseccion(conjuntoPila, conjuntoCola);
		
		return conjuntoInterseccion;
	}

}
