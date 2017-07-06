package tp3;

import impl.PilaLD;
import api.PilaTDA;

public class TP_3_1C {

	public static void main(String[] args) {
		PilaTDA pila = new PilaLD();
		
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		pila.apilar(4);
		pila.apilar(5);
		pila.apilar(6);
		
		PilaTDA m2 = obtenerMitades(pila);
		
		System.out.print("M1 \n");
		System.out.print("--\n");
		while(!pila.pilaVacia()){
			System.out.print(pila.tope());						
			pila.desapilar();			
		}
		
		System.out.print("\nM2 \n");
		System.out.print("-- \n");		
		while(!m2.pilaVacia()){
			System.out.print(m2.tope());
			m2.desapilar();
		}
		
	}
	
	private static PilaTDA obtenerMitades(PilaTDA pila){
		
		PilaTDA pilaAux = new PilaLD();
		PilaTDA m2 = new PilaLD();
		
		pilaAux.inicializarPila();
		m2.inicializarPila();
		
		int cont = 0;
		int mitad = 0;
		
		while(!pila.pilaVacia()){						
			pilaAux.apilar(pila.tope());
			pila.desapilar();
			cont++;
		}
		
		mitad = cont / 2;
		
		while(!pilaAux.pilaVacia() && mitad != 0){
			m2.apilar(pilaAux.tope());
			pilaAux.desapilar();
			mitad--;
		}
		
		while(!pilaAux.pilaVacia()){
			pila.apilar(pilaAux.tope());
			pilaAux.desapilar();
		}
		
		return m2;
	}

}
