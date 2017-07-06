package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3L3 {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		abb.agregarElemento(15);
		abb.agregarElemento(14);
		abb.agregarElemento(20);
		abb.agregarElemento(19);	
	
		postOrder(abb);
	}
	
	private static void postOrder(ABBTDA abb){
		if(!abb.arbolVacio()){
			
			// Por Izquierda
			postOrder(abb.hijoIzq());
			
			// Por Derecha
			postOrder(abb.hijoDer());
			
			// Raiz
			System.out.print(abb.raiz() + "\n");
		}
	}

}
