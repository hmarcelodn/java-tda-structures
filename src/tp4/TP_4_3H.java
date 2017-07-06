package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3H {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		abb.agregarElemento(100);
		abb.agregarElemento(120);
		abb.agregarElemento(123);
		abb.agregarElemento(80);
		abb.agregarElemento(81);
		abb.agregarElemento(20);
		abb.agregarElemento(1);
		abb.agregarElemento(0);
	
		System.out.print("Altura ABB: " + calcularAltura(abb));;
	}

	private static int calcularAltura(ABBTDA abb){		
		if(!abb.arbolVacio()){
			
			int derecha = calcularAltura(abb.hijoDer());
			int izquierda = calcularAltura(abb.hijoIzq());
			
			if(derecha > izquierda){
				return derecha + 1;
			}
			
			return izquierda + 1;
		}
		
		return -1;
	}
	
}
