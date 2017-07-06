package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3D {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		abb.agregarElemento(100);
		abb.agregarElemento(120);
		abb.agregarElemento(80);
		abb.agregarElemento(20);
		abb.agregarElemento(1);
		abb.agregarElemento(0);
		
		System.out.print("Menor Elemento en Arbol: " + menorElemento(abb));
	}

	private static int menorElemento(ABBTDA abb){		
		if(!abb.arbolVacio()){
			if(!abb.hijoIzq().arbolVacio()){
				return menorElemento(abb.hijoIzq());
			}
			else{
				return abb.raiz();
			}
		}
		
		return 0;
	}
	
}
