package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3G {

	public static void main(String[] args) {
		ABBTDA abb = new ABB();
		abb.inicializarArbol();
		
		abb.agregarElemento(100);
		abb.agregarElemento(120);
		abb.agregarElemento(80);
		abb.agregarElemento(81);
		abb.agregarElemento(20);
		abb.agregarElemento(1);
		
		System.out.print("Cantidad Hojas: " + contarHojas(abb));
	}

	private static int contarHojas(ABBTDA abb){
		if(!abb.arbolVacio() && abb.hijoDer().arbolVacio() && abb.hijoIzq().arbolVacio()){
			return 1;
		}
		
		if(abb.arbolVacio()){
			return 0;
		}
		
		return contarHojas(abb.hijoDer()) + contarHojas(abb.hijoIzq());
	}
	
}
