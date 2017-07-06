package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3L1 {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		abb.agregarElemento(15);
		abb.agregarElemento(14);
		abb.agregarElemento(20);
		abb.agregarElemento(19);
		
		inOrder(abb);
	}

	private static void inOrder(ABBTDA abb){
		if(!abb.arbolVacio()){
			
			// Por Izquierda
			inOrder(abb.hijoIzq());
			
			// Raiz
			System.out.print(abb.raiz() + "\n");
			
			// Por derecha
			inOrder(abb.hijoDer());
		}
	}
	
}
