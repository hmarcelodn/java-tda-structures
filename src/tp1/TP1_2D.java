package tp1;

import impl.PilaTI;
import api.PilaTDA;

/**
 * Problema 2D: Contar los elementos de una Pila
 * @author hdelnegro
 *
 */
public class TP1_2D {

	public static void main(String[] args) {
		
		PilaTDA pila = new PilaTI();

		pila.inicializarPila();
		
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
				
		System.out.println("Elementos en pila: " + contarPila(pila));
	}
	
	public static int contarPila(PilaTDA pila){
		int cont = 0;
		
		while(!pila.pilaVacia()){			
			cont++;
			pila.desapilar();
		}
		
		return cont;
	} 

}
