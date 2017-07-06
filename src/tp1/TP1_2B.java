package tp1;

import api.PilaTDA;
import impl.PilaTF;
import impl.PilaTI;

/** 
 *  Copiar una Pila en otra (dejándola en el mismo orden que la original) 
 * @author hdelnegro
 *
 */
public class TP1_2B {

	public static void main(String[] args) {
		PilaTDA pila1 = new PilaTI();
		PilaTDA pila2 = new PilaTI();
		
		pila1.inicializarPila();
		pila2.inicializarPila();
		
		pila1.apilar(1);
		pila1.apilar(2);
		pila1.apilar(3);
		
		copiarPilaAPila(pila1, pila2);
	}
	
	public static void copiarPilaAPila(PilaTDA origen, PilaTDA destino){
		PilaTDA pilaAux = new PilaTF();
		pilaAux.inicializarPila();
		
		while(!origen.pilaVacia()){
			pilaAux.apilar(origen.tope());			
			origen.desapilar();
		}
		
		while(!pilaAux.pilaVacia()){
			destino.apilar(pilaAux.tope());
			pilaAux.desapilar();
		}
	}

}
