package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3J {

	public static void main(String[] args) {
		ABBTDA abb01 = new ABB();		
		ABBTDA abb02 = new ABB();
		
		abb01.inicializarArbol();
		abb02.inicializarArbol();
		
		abb01.agregarElemento(15);
		abb01.agregarElemento(20);
		abb01.agregarElemento(14);
		abb01.agregarElemento(19);
		
		abb02.agregarElemento(15);
		abb02.agregarElemento(20);
		abb02.agregarElemento(14);
		abb02.agregarElemento(19);
		
		if(sonArbolesIguales(abb01, abb02)){
			System.out.print("Son arboles iguales.");
		}
		else{
			System.out.print("No son arboles iguales.");
		}
	}
	
	private static boolean sonArbolesIguales(ABBTDA abb01, ABBTDA abb02){		
		if(!abb01.arbolVacio() && !abb02.arbolVacio()){
			return abb01.raiz() == abb02.raiz() &&
					sonArbolesIguales(abb01.hijoIzq(), abb02.hijoIzq()) &&
					sonArbolesIguales(abb01.hijoDer(), abb02.hijoDer());
		}
		else if (abb01.arbolVacio() == abb02.arbolVacio()){
			return true;
		}
		
		return false;
	}

}
