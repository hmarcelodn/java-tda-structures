package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3B {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		// Raiz
		abb.agregarElemento(50);
		
		// Derecha
		abb.agregarElemento(30);
		abb.agregarElemento(20);
		
		// Izquierda
		abb.agregarElemento(60);
		abb.agregarElemento(70);
		
		// Analizar si elemento es Hoja
		if(esHoja(abb, 20)){
			System.out.print("Es Hoja.");
		}
		else{
			System.out.print("No es Hoja.");
		}
	}
	
	private static boolean esHoja(ABBTDA abb, int elem){
		if(!abb.arbolVacio()){
			if(abb.raiz() == elem && abb.hijoDer().arbolVacio() && abb.hijoIzq().arbolVacio()){				
				return true;
			}
			else if(abb.raiz() == elem && !abb.hijoDer().arbolVacio() && !abb.hijoIzq().arbolVacio()){
				return false;
			}
			else if(elem > abb.raiz() && !abb.hijoDer().arbolVacio()){
				return esHoja(abb.hijoDer(), elem);
			}
			else if(elem < abb.raiz() && !abb.hijoIzq().arbolVacio()){
				return esHoja(abb.hijoIzq(), elem);
			}
		}
		
		return false;
	}

}
