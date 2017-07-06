package tp1;

import impl.PilaTF;
import api.PilaTDA;

/**
 * Calcular el promedio de los elementos de una Pila
 * @author hdelnegro
 *
 */
public class TP1_2F {

	public static void main(String[] args) {
		
		PilaTDA pila = new PilaTF();

		pila.inicializarPila();
		
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		
		System.out.print("Promedio Pila: " + promedioPila(pila));
	}
	
	public static int promedioPila(PilaTDA pila){
		int cont = 0;
		int acum = 0;
		
		while(!pila.pilaVacia()){
			cont ++;
			acum += pila.tope();
			
			pila.desapilar();
		}
		
		return acum/cont;
	}

}
