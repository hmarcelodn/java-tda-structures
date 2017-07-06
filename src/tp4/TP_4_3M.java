package tp4;

import impl.ABB;
import impl.ConjuntoLD;
import api.ABBTDA;
import api.ConjuntoTDA;

public class TP_4_3M {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		ConjuntoTDA conjunto = new ConjuntoLD();
		
		abb.inicializarArbol();
		conjunto.inicializarConjunto();
		
		int k = 15;
		
		abb.agregarElemento(15);
		abb.agregarElemento(14);
		abb.agregarElemento(20);
		abb.agregarElemento(19);	
		
		mayores(abb, conjunto ,k);
		
		while(!conjunto.conjuntoVacio()){
			int x = conjunto.elegir();
			conjunto.sacar(x);			
			System.out.print(x + "\n");
		}
	}
	
	private static void mayores(ABBTDA abb, ConjuntoTDA conjunto ,int k){
		if(!abb.arbolVacio()){
			if(abb.raiz() > k){
				conjunto.agregar(abb.raiz());
			}
						
			mayores(abb.hijoIzq(), conjunto, k);
			mayores(abb.hijoDer(), conjunto, k);
		}
	}

}
