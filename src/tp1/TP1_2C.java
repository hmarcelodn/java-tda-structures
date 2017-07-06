package tp1;

import api.ColaTDA;
import api.PilaTDA;
import impl.Cola;
import impl.Pila;

/** 
 *  Invertir el contenido de una Pila. 
 * @author hdelnegro
 *
 */
public class TP1_2C {

	public static void main(String[] args) {
		
		PilaTDA pila1 = new Pila();
		
		pila1.inicializarPila();
		
		pila1.apilar(1);
		pila1.apilar(2);
		pila1.apilar(3);
		
		invertirPila(pila1);
	}
	
	public static void invertirPila(PilaTDA pila){
		ColaTDA colaAux = new Cola();
		
		while(!pila.pilaVacia()){
			colaAux.acolar(pila.tope());
			pila.desapilar();
		}
		
		while(!colaAux.colaVacia()){
			pila.apilar(colaAux.primero());
			colaAux.desacolar();
		}
	}

}
