package tp1;

import impl.Cola;
import api.ColaTDA;

/**
 * Invertir el contenido de una Cola (NO pueden usarse Pilas auxiliares)
 * @author hdelnegro
 *
 */
public class TP1_4C {

	public static void main(String[] args) {
		ColaTDA cola = new Cola();
		cola.inicializarCola();
		
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);
		
		invertirCola(cola);
	}
	
	private static void invertirCola(ColaTDA cola){
		
		int primero = cola.primero();
		cola.desacolar();
		
		if(!cola.colaVacia()){
			invertirCola(cola);
		}
		
		cola.acolar(primero);
		
	}

}
