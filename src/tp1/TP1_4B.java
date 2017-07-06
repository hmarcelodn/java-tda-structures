package tp1;

import impl.Cola;
import impl.Pila;
import api.ColaTDA;
import api.PilaTDA;

/**
 *  Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
 * @author hdelnegro
 *
 */
public class TP1_4B {

	public static void main(String[] args) {
		ColaTDA cola = new Cola();
		
		cola.inicializarCola();
		
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);
		
		invertirCola(cola);
	}

	private static void invertirCola(ColaTDA cola){
		PilaTDA pilaAux = new Pila();
		pilaAux.inicializarPila();
		
		while(!cola.colaVacia()){
			pilaAux.apilar(cola.primero());
			cola.desacolar();
		}
		
		while(!pilaAux.pilaVacia()){
			cola.acolar(pilaAux.tope());
			pilaAux.desapilar();
		}
	}
	
}
