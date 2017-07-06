package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3C {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		// Elemento de busqueda
		int elem = 80;
		
		// Raiz
		abb.agregarElemento(50);
		
		// Izquierda
		abb.agregarElemento(20);
		abb.agregarElemento(30);
		
		// Derecha
		abb.agregarElemento(61);
		abb.agregarElemento(80);
		abb.agregarElemento(100);
		
		System.out.print("Profundidad Arbol: " + calcularProfundidad(abb, elem));
	}

	private static int calcularProfundidad(ABBTDA abb, int elem){
		if(!abb.arbolVacio()){
			if(abb.raiz() == elem){
				return 0;
			}
			else if(elem > abb.raiz() && !abb.hijoDer().arbolVacio()){
				return calcularProfundidad(abb.hijoDer(), elem) + 1;
			}
			else if(elem < abb.raiz() && !abb.hijoIzq().arbolVacio()){
				return calcularProfundidad(abb.hijoIzq(), elem) + 1;
			}			
		}	
		
		return 0;
	}
	
}
