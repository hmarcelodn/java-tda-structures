package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3F {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		abb.agregarElemento(1);
		abb.agregarElemento(2);
		abb.agregarElemento(3);
		abb.agregarElemento(4);
		abb.agregarElemento(10);
		
		System.out.print("Suma Elementos Arbol: " + sumaElementos(abb));
	}
	
	private static int sumaElementos(ABBTDA abb){
		if(!abb.arbolVacio()){
			return abb.raiz() + sumaElementos(abb.hijoDer()) + sumaElementos(abb.hijoIzq());
		}
		
		return 0;
	}

}
