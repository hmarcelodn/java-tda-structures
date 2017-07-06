package tp1;

import api.ColaTDA;
import api.PilaTDA;
import impl.ColaTI;
import impl.PilaTI;

/**
 *  Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir  que el primer 
 *  elemento es igual al último, el segundo igual al penúltimo, etc.
 * @author hdelnegro
 *
 */
public class TP1_4E {

	public static void main(String[] args) {		
		ColaTDA cola = new ColaTI();
		cola.inicializarCola();
		
		cola.acolar(3);
		cola.acolar(2);
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);		
		
		if(esColaCapicua(cola)){
			System.out.print("Es cola capicua.");
		}
		else{
			System.out.print("No es cola capicua.");
		}
	}
	
	private static boolean esColaCapicua(ColaTDA cola){
		
		int contador = 0;
		PilaTDA pilaAux = new PilaTI();
		ColaTDA colaAux = new ColaTI();		
		
		pilaAux.inicializarPila();
		colaAux.inicializarCola();
		
		while(!cola.colaVacia()){			
			int item = cola.primero();
			cola.desacolar();
			contador++;
			
			pilaAux.apilar(item);
			colaAux.acolar(item);						
		}
		
		int mitad = (contador /  2);

		while(mitad != 0){			
			if(pilaAux.tope() == colaAux.primero()){
				pilaAux.desapilar();
				colaAux.desacolar();
				mitad--;
			}
			else{
				break;
			}			
		}
		
		return (mitad == 0);
	}

}
