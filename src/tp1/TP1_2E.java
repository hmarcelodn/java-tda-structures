package tp1;

import impl.PilaTF;
import api.PilaTDA;

/**
 * Sumar los elementos de una Pila
 * @author hdelnegro
 *
 */
public class TP1_2E {

	public static void main(String[] args) {
		
		PilaTDA pila = new PilaTF();

		pila.inicializarPila();
		
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);

		
		System.out.print("Suma Pila: " + sumarPila(pila));
	}

	public static int sumarPila(PilaTDA pila){
		int acum = 0;
		
		while(!pila.pilaVacia()){
			acum += pila.tope();
			pila.desapilar();
		}
		
		return acum;
	}
}
