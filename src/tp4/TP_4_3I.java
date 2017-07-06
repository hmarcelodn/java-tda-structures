package tp4;

import impl.ABB;
import api.ABBTDA;

public class TP_4_3I {

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
		
		if(igualEstructura(abb01, abb02)){
			System.out.print("Son arboles con estructuras iguales.");
		}
		else{
			System.out.print("No son arboles con estructuras iguales.");
		}
	}
	
	private static boolean igualEstructura(ABBTDA abb01, ABBTDA abb02){
		if(!abb01.arbolVacio() && !abb02.arbolVacio()){
			return 
				igualEstructura(abb01.hijoIzq(), abb02.hijoIzq()) && 
				igualEstructura(abb01.hijoDer(), abb02.hijoDer());
		}
		else if(abb01.arbolVacio() == abb02.arbolVacio()){
			return true;
		}
		
		return false;
	}
	
}
