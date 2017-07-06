package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3L2 {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		abb.agregarElemento(15);
		abb.agregarElemento(14);
		abb.agregarElemento(20);
		abb.agregarElemento(19);	
		
		preOrder(abb);
	}
	
	private static void preOrder(ABBTDA abb){
		if(!abb.arbolVacio()){
			// Raiz
			System.out.print(abb.raiz() + "\n");
			
			// Por Izquierda
			preOrder(abb.hijoIzq());
			
			// Por Derecha
			preOrder(abb.hijoDer());
		}
	}

}
