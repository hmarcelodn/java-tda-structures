package tp3;

import impl.ConjuntoLD;
import impl.PilaLD;
import api.ConjuntoTDA;
import api.PilaTDA;

public class TP_3_1D {

	public static void main(String[] args) {
		PilaTDA pila = new PilaLD();
		pila.inicializarPila();
		
		pila.apilar(6);
		pila.apilar(6);
		pila.apilar(4);
		pila.apilar(2);
		pila.apilar(4);
		pila.apilar(1);
		
		ConjuntoTDA repetidos = obtenerRepeditos(pila);
		
		while(!repetidos.conjuntoVacio()){
			int valor = repetidos.elegir();
			repetidos.sacar(valor);
			
			System.out.print(valor + "\n");			
		}
	}

	private static ConjuntoTDA obtenerRepeditos(PilaTDA pila){		
		ConjuntoTDA conjuntoAux = new ConjuntoLD();		
		ConjuntoTDA conjuntoRep = new ConjuntoLD();
		
		conjuntoAux.inicializarConjunto();
		conjuntoRep.inicializarConjunto();
		
		while(!pila.pilaVacia()){
			if(!conjuntoAux.pertenece(pila.tope())){
				conjuntoAux.agregar(pila.tope());
			}
			else{
				conjuntoRep.agregar(pila.tope());
			}
			
			pila.desapilar();
		}
		
		return conjuntoRep;
	}
	
}
