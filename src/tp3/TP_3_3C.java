package tp3;

import impl.ConjuntoLD;
import api.ConjuntoTDA;

public class TP_3_3C {

	public static void main(String[] args) {
		ConjuntoTDA conjuntoA = new ConjuntoLD();
		ConjuntoTDA conjuntoB = new ConjuntoLD();
		
		conjuntoA.inicializarConjunto();
		conjuntoB.inicializarConjunto();
		
		conjuntoA.agregar(1);
		conjuntoA.agregar(2);
		conjuntoA.agregar(3);
		
		conjuntoB.agregar(1);
		conjuntoB.agregar(5);
		conjuntoB.agregar(6);
		
		ConjuntoTDA conjuntoDiferencia = diferencia(conjuntoA, conjuntoB);
		
		while(!conjuntoDiferencia.conjuntoVacio()){
			int x = conjuntoDiferencia.elegir();
			conjuntoDiferencia.sacar(x);			
			System.out.print(x + "\n");
		}
	}

	private static ConjuntoTDA interseccion(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){
		ConjuntoTDA conjuntoInterseccion = new ConjuntoLD();
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		
		conjuntoInterseccion.inicializarConjunto();		
		conjuntoAux.inicializarConjunto();

		while(!conjuntoA.conjuntoVacio()){
			int x = conjuntoA.elegir();
			
			if(conjuntoB.pertenece(x)){
				if(!conjuntoInterseccion.pertenece(x)){
					conjuntoInterseccion.agregar(x);
				}				
			}
			
			conjuntoA.sacar(x);
			conjuntoAux.agregar(x);
		}
		
		while(!conjuntoAux.conjuntoVacio()){
			conjuntoA.agregar(conjuntoAux.elegir());
			conjuntoAux.sacar(conjuntoAux.elegir());
		}
		
		return conjuntoInterseccion;		
	}
	
	private static ConjuntoTDA union(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){		
		ConjuntoTDA conjuntoUnion = new ConjuntoLD();
		ConjuntoTDA conjuntoAuxA = new ConjuntoLD();
		ConjuntoTDA conjuntoAuxB = new ConjuntoLD();
		
		conjuntoUnion.inicializarConjunto();
		conjuntoAuxA.inicializarConjunto();
		conjuntoAuxB.inicializarConjunto();
		
		while(!conjuntoA.conjuntoVacio() || !conjuntoB.conjuntoVacio()){
			
			if(!conjuntoA.conjuntoVacio()){
				int valA = conjuntoA.elegir();
				
				if(!conjuntoUnion.pertenece(valA)){
					conjuntoUnion.agregar(valA);
				}				
				
				conjuntoAuxA.agregar(valA);
				conjuntoA.sacar(valA);
			}
			
			if(!conjuntoB.conjuntoVacio()){
				int valB = conjuntoB.elegir();
								
				if(!conjuntoUnion.pertenece(valB)){
					conjuntoUnion.agregar(valB);
				}
				
				conjuntoAuxB.agregar(valB);
				conjuntoB.sacar(valB);
			}			
		}
		
		while(!conjuntoAuxA.conjuntoVacio() || !conjuntoAuxB.conjuntoVacio()){
			if(!conjuntoAuxA.conjuntoVacio()){
				int x = conjuntoAuxA.elegir();
				conjuntoA.agregar(x);
				conjuntoAuxA.sacar(x);
			}
			
			if(!conjuntoAuxB.conjuntoVacio()){
				int x = conjuntoAuxB.elegir();
				conjuntoB.agregar(x);
				conjuntoAuxB.sacar(x);
			}			
		}		
		
		return conjuntoUnion;
	}
	
	private static ConjuntoTDA diferencia(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){
		ConjuntoTDA conjuntoDiferencia = new ConjuntoLD();		
		conjuntoDiferencia.inicializarConjunto();
		
		ConjuntoTDA conjuntoInterseccion = interseccion(conjuntoA, conjuntoB);
		ConjuntoTDA conjuntoUnion = union(conjuntoA, conjuntoB);
		
		while(!conjuntoUnion.conjuntoVacio()){
			int x = conjuntoUnion.elegir();
			
			if(!conjuntoInterseccion.pertenece(x)){
				conjuntoDiferencia.agregar(x);
			}
			
			conjuntoUnion.sacar(x);
		}
		
		return conjuntoDiferencia;
	}
	
}
