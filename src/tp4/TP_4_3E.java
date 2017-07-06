package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3E {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		abb.agregarElemento(100);
		abb.agregarElemento(120);
		abb.agregarElemento(80);
		abb.agregarElemento(81);
		abb.agregarElemento(20);
		abb.agregarElemento(1);
		abb.agregarElemento(0);
		
		System.out.print("Cantidad de nodos: " + contarArbol(abb));
	}
	
	private static int contarArbol(ABBTDA abb){
		if(!abb.arbolVacio()){
			return 1 + contarArbol(abb.hijoDer()) + contarArbol(abb.hijoIzq());
		}
		
		return 0;
	}

}
