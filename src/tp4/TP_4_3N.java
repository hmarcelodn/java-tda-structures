package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3N {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		int k = 14;
		
		abb.agregarElemento(15);
		abb.agregarElemento(14);
		abb.agregarElemento(20);
		abb.agregarElemento(19);
		
		System.out.print("Predecesor: " + obtenerPredecesor(abb, k));
	}
	
	private static int obtenerPredecesor(ABBTDA abb, int k){		
		if(!abb.arbolVacio()){
			if(!abb.hijoIzq().arbolVacio() && abb.hijoIzq().raiz() == k){
				return abb.raiz();
			}
			else if(!abb.hijoDer().arbolVacio() && abb.hijoDer().raiz() == k){
				return abb.raiz();
			}
			else{
				int derecha = obtenerPredecesor(abb.hijoIzq(), k);
				int izquierda = obtenerPredecesor(abb.hijoDer(), k);
				
				if(derecha != 0){
					return derecha;
				}
				else if(izquierda != 0){
					return izquierda;
				}
			}
		}
		
		return 0;
	}

}
