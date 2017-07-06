package tp1;

import api.ColaTDA;
import impl.ColaLD;

/**
 *  Problema 4D: Determinar si el final de la Cola C1 coincide o no con la Cola C2.
 * @author hdelnegro
 *
 */
public class TP1_4D {

	public static void main(String[] args) {		
		ColaTDA c1 = new ColaLD();
		c1.inicializarCola();
		
		ColaTDA c2 = new ColaLD();
		c2.inicializarCola();
		
		c1.acolar(1);
		c1.acolar(2);
		c1.acolar(3);
		
		c2.acolar(1);
		c2.acolar(2);
		c2.acolar(5);
		c2.acolar(3);
		
		if(determinarFinalColas(c1, c2)){
			System.out.print("El final de las colas c1/c2 es igual.");
		}
		else{
			System.out.print("El final de las colas c1/c2 es diferente.");
		}
	}
	
	private static boolean determinarFinalColas(ColaTDA c1, ColaTDA c2){		
		int valorc1 = 0;
		int valorc2 = 0;
		
		while(!c1.colaVacia() || !c2.colaVacia()){
			
			if(!c1.colaVacia()){
				valorc1 = c1.primero();
				c1.desacolar();
			}
			
			if(!c2.colaVacia()){
				valorc2 = c2.primero();
				c2.desacolar();
			}			
			
			if(c1.colaVacia() && c2.colaVacia()){
				return (valorc1 == valorc2);
			}
		}
		
		return false;		
	}

}
