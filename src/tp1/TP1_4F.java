package tp1;

import api.ColaTDA;
import api.PilaTDA;
import impl.ColaTI;
import impl.PilaTI;

/**
 * Problema 4E: Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán inversas, 
 * si tienen los mismos elementos pero en orden inverso.
 * Tip: Recursivo.
 * @author hdelnegro
 *
 */
public class TP1_4F {

	public static void main(String[] args) {
		ColaTDA c1 = new ColaTI();
		ColaTDA c2 = new ColaTI();
		
		c1.inicializarCola();
		c2.inicializarCola();
		
		c1.acolar(1);
		c1.acolar(2);
		c1.acolar(3);
		
		c2.acolar(3);
		c2.acolar(2);
		c2.acolar(1);
		
		if(esColaInversa(c1, c2)){
			System.out.print("C1/C2 son colas inversas.");
		}
		else{
			System.out.print("C1/C2 no son colas inversas.");
		}		
	}

	private static boolean esColaInversa(ColaTDA c1, ColaTDA c2){
		
		PilaTDA pilaAux = new PilaTI();
		ColaTDA colaAux = new ColaTI();
		
		pilaAux.inicializarPila();
		colaAux.inicializarCola();
		
		while(!c1.colaVacia() && !c2.colaVacia()){			
			colaAux.acolar(c1.primero());
			pilaAux.apilar(c2.primero());
			
			c1.desacolar();
			c2.desacolar();
		}
		
		if(c1.colaVacia() == c2.colaVacia()){
			while(!pilaAux.pilaVacia() && !colaAux.colaVacia()){
				if(pilaAux.tope() == colaAux.primero()){
					pilaAux.desapilar();
					colaAux.desacolar();
				}
				else{
					break;
				}
			}
			
			if(pilaAux.pilaVacia() && colaAux.colaVacia()){
				return true;
			}
		}
		
		return false;
	}
	
}
