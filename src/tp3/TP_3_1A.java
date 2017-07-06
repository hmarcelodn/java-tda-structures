package tp3;

import api.ColaTDA;
import api.PilaTDA;
import impl.ColaLD;
import impl.PilaLD;
import impl.PilaTI;

/**
 * Comprobar si una Pila P es capicúa (el elemento del tope es igual al de la base,
	el segundo igual al anteúltimo, etc.)
 * @author alu503
 *
 */
public class TP_3_1A {	
	
	
	public static void main(String[] args) {
		PilaTDA pila = new PilaTI();		
		pila.inicializarPila();
		
		pila.apilar(3);
		pila.apilar(2);
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		
		if(esCapicua(pila)){
			System.out.print("La pila es capicua.");
		}
		else{
			System.out.print("La pila no es capicua.");
		}		
	}
	
	private static boolean esCapicua(PilaTDA pila){
		
		ColaTDA colaAux = new ColaLD();
		PilaTDA pilaAux = new PilaLD();
		
		colaAux.inicializarCola(); 
		pilaAux.inicializarPila(); 
		
		int mitad;
		int cont = 0;
		
		while(!pila.pilaVacia()){ 
			int valor = pila.tope();
			
			colaAux.acolar(valor);
			pilaAux.apilar(valor);
			
			pila.desapilar();
			cont++;
		}
		
		mitad = cont / 2;
		
		while(mitad != 0){			
			if(colaAux.primero() == pilaAux.tope()){
				mitad--;
			}
			else{
				break;
			}			
		}
		
		
		return (mitad == 0);
	}

}

