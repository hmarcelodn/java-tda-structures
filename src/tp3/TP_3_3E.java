package tp3;

import impl.ConjuntoLD;
import api.ConjuntoTDA;

public class TP_3_3E {

	public static void main(String[] args) {
		ConjuntoTDA conjunto = new ConjuntoLD();
		conjunto.inicializarConjunto();
		
		conjunto.agregar(1);
		conjunto.agregar(2);
		conjunto.agregar(3);
		
		System.out.print("Cardinalidad Conjunto: " + cardinalidad(conjunto));
	}
	
	public static int cardinalidad(ConjuntoTDA conjunto){
		
		int contador = 0;
		
		while(!conjunto.conjuntoVacio()){
			int x = conjunto.elegir();
			conjunto.sacar(x);
			contador++;			
		}			
		
		return contador;
	}

}
