package tp3;

import impl.ConjuntoLD;
import api.ConjuntoTDA;

public class TP_3_3B {

	public static void main(String[] args) {
		ConjuntoTDA conjuntoA = new ConjuntoLD();
		ConjuntoTDA conjuntoB = new ConjuntoLD();
		
		conjuntoA.inicializarConjunto();
		conjuntoB.inicializarConjunto();
		
		conjuntoA.agregar(1);
		conjuntoA.agregar(2);
		conjuntoA.agregar(3);
		conjuntoA.agregar(6);
		
		conjuntoB.agregar(3);
		conjuntoB.agregar(4);
		conjuntoB.agregar(5);
		
		ConjuntoTDA diferencia = diferenciaSimetrica(conjuntoA, conjuntoB);
		
		while(!diferencia.conjuntoVacio()){
			int x = diferencia.elegir();
			diferencia.sacar(x);
			System.out.print(x + "\n");
		}
	}
	
	private static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){						
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		ConjuntoTDA conjuntoRep = new ConjuntoLD();
		
		conjuntoAux.inicializarConjunto();
		conjuntoRep.inicializarConjunto();
		
		// Conjunto A / Comparacion
		while(!conjuntoA.conjuntoVacio()){
			int x = conjuntoA.elegir();
			
			if(conjuntoB.pertenece(x)){
				conjuntoRep.agregar(x);
			}
			else{
				conjuntoAux.agregar(x);
			}
			
			conjuntoA.sacar(x);
		}
		
		// Conjunto B / Comparacion
		while(!conjuntoB.conjuntoVacio()){
			int x = conjuntoB.elegir();
			
			if(!conjuntoRep.pertenece(x)){
				conjuntoAux.agregar(x);
			}
			
			conjuntoB.sacar(x);
		}
		
		return conjuntoAux;
	}

}
