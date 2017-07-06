package tp1;

import api.PilaTDA;
import impl.PilaTI;

/**
 * Problema 2A: Pasar una Pila a otra (dejándola en orden inverso)
 * @author hdelnegro
 *
 */

public class TP1_2A {

	public static void main(String[] args) {
		PilaTDA pila1 = new PilaTI();
		PilaTDA pila2 = new PilaTI();
		
		pila1.inicializarPila();
		pila2.inicializarPila();
		
		pila1.apilar(1);
		pila1.apilar(2);
		pila1.apilar(3);
		
		pasarPilaAPila(pila1, pila2);		
	}
	
	public static void pasarPilaAPila(PilaTDA origen, PilaTDA destino){
		while(!origen.pilaVacia()){
			destino.apilar(origen.tope());
			origen.desapilar();
		}
	}

}
