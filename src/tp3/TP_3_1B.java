package tp3;

import impl.ConjuntoLD;
import impl.PilaLD;
import api.ConjuntoTDA;
import api.PilaTDA;

/**
 * Eliminar de una Pila P las repeticiones de elementos, dejando un representante
	de cada uno de los elementos presentes originalmente. Se deberá respetar el
	orden original de los elementos, y en el caso de los repetidos se conservará el
	primero que haya ingresado en P
 * @author alu503
 *
 */
public class TP_3_1B {

	public static void main(String[] args) {
		PilaTDA pila = new PilaLD();
		pila.inicializarPila();
		
		pila.apilar(3);
		pila.apilar(3);
		pila.apilar(2);
		pila.apilar(0);
		pila.apilar(1);
		pila.apilar(0);
		
		eliminarRepeticiones(pila);
		
		while(!pila.pilaVacia()){
			System.out.print(pila.tope() + "\n");
			pila.desapilar();
		}
	}
	
	private static void eliminarRepeticiones(PilaTDA pila){
		PilaTDA pilaAux = new PilaLD();
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		
		pilaAux.inicializarPila();
		conjuntoAux.inicializarConjunto();
		
		while(!pila.pilaVacia()){
			if(!conjuntoAux.pertenece(pila.tope())){
				conjuntoAux.agregar(pila.tope());
				pilaAux.apilar(pila.tope());				
			}
			
			pila.desapilar();
		}
		
		while(!pilaAux.pilaVacia()){
			pila.apilar(pilaAux.tope());
			pilaAux.desapilar();
		}
		
	}

}
