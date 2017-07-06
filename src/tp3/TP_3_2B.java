package tp3;

import impl.ColaLD;
import api.ColaTDA;

public class TP_3_2B {

	public static void main(String[] args) {
		ColaTDA cola = new ColaLD();		
		cola.inicializarCola();
		
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);
		cola.acolar(4);
		
		ColaTDA colaM2 = dividirCola(cola);
		
		System.out.print("M1 \n");
		System.out.print("-- \n");
		while(!cola.colaVacia()){
			System.out.print(cola.primero() + "\n");
			cola.desacolar();
		}
		
		System.out.print("M2 \n");
		System.out.print("-- \n");		
		while(!colaM2.colaVacia()){
			System.out.print(colaM2.primero() + "\n");
			colaM2.desacolar();
		}
		
	}
	
	private static ColaTDA dividirCola(ColaTDA cola){
		ColaTDA colaAux = new ColaLD();
		ColaTDA colaM2 = new ColaLD();
		
		colaAux.inicializarCola();
		colaM2.inicializarCola();
		
		int cont = 0;
		
		while(!cola.colaVacia()){
			colaAux.acolar(cola.primero());
			cola.desacolar();
			cont++;
		}
		
		int med = cont / 2;
		
		while(med != 0){
			cola.acolar(colaAux.primero());
			colaAux.desacolar();
			med--;			
		}
		
		while(!colaAux.colaVacia()){
			colaM2.acolar(colaAux.primero());
			colaAux.desacolar();
		}
		
		return colaM2;
	}

}
