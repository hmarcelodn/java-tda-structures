package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3A {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		//Raiz
		abb.agregarElemento(30);
		
		//Derecha
		abb.agregarElemento(31);
		abb.agregarElemento(40);
		
		//Izq
		abb.agregarElemento(5);
		abb.agregarElemento(19);	
		
		// Busqueda Recursiva
		if(existeElemento(abb, 5)){
			System.out.print("Existe Elemento en ABB.");
		}
		else{
			System.out.print("El elemento no existe en ABB.");
		}
	}
	
	private static boolean existeElemento(ABBTDA abb, int elem){		
		if(!abb.arbolVacio()){
			if(abb.raiz() == elem){
				return true;
			}
			else if(elem > abb.raiz() && !abb.hijoDer().arbolVacio()){
				return existeElemento(abb.hijoDer(), elem);
			}
			else if(elem < abb.raiz() && !abb.hijoIzq().arbolVacio()){
				return existeElemento(abb.hijoIzq(), elem);
			}
		}
		
		return false;
	}

}
