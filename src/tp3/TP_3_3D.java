package tp3;

import impl.ConjuntoLD;
import api.ConjuntoTDA;

public class TP_3_3D {

	public static void main(String[] args) {
		ConjuntoTDA conjuntoA = new ConjuntoLD();
		ConjuntoTDA conjuntoB = new ConjuntoLD();
		
		conjuntoA.inicializarConjunto();
		conjuntoB.inicializarConjunto();
		
		conjuntoA.agregar(1);
		conjuntoA.agregar(2);
		conjuntoA.agregar(3);
		
		conjuntoB.agregar(1);
		conjuntoB.agregar(2);
		conjuntoB.agregar(3);
		
		if(compararConjuntos(conjuntoA, conjuntoB)){
			System.out.print("Los conjuntos son iguales.");
		}
		else{
			System.out.print("Los conjuntos no son iguales.");
		}
	}
	
	private static boolean compararConjuntos(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){
		while(!conjuntoA.conjuntoVacio()){
			int x = conjuntoA.elegir();
			
			if(!conjuntoB.pertenece(x)){
				return false;
			}
			
			conjuntoA.sacar(x);
			conjuntoB.sacar(x);
		}		
		
		return (conjuntoA.conjuntoVacio() && conjuntoB.conjuntoVacio());
	}

}
