package tp3;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import impl.ConjuntoLD;
import impl.DicMultipleA;

public class TP_3_5D {

	public static void main(String[] args) {
		DiccionarioMultipleTDA diccionarioA = new DicMultipleA();
		DiccionarioMultipleTDA diccionarioB = new DicMultipleA();
		
		diccionarioA.inicializarDiccionario();
		diccionarioB.inicializarDiccionario();
		
		diccionarioA.agregar(100, 1);
		diccionarioA.agregar(100, 2);
		diccionarioA.agregar(200, 2);
		
		diccionarioB.agregar(100, 1);
		diccionarioB.agregar(100, 2);
		diccionarioB.agregar(100, 3);
		diccionarioB.agregar(200, 1);
		
		DiccionarioMultipleTDA dicResultado = clavesComunesElementosComunes(diccionarioA, diccionarioB);
		
		ConjuntoTDA claves = dicResultado.claves();
		
		while(!claves.conjuntoVacio()){
			int clave = claves.elegir();
			claves.sacar(clave);
			
			ConjuntoTDA valores = dicResultado.recuperar(clave);
			
			System.out.print("Clave: " + clave + "\n");
			System.out.print("----------" + "\n");
			while(!valores.conjuntoVacio()){
				int valor = valores.elegir();
				valores.sacar(valor);
				
				System.out.print("> " + valor + "\n");
			}
		}		
	}

	private static DiccionarioMultipleTDA clavesComunesElementosComunes(DiccionarioMultipleTDA dicA, DiccionarioMultipleTDA dicB){
		DiccionarioMultipleTDA diccionarioAux = new DicMultipleA();
		diccionarioAux.inicializarDiccionario();
		
		ConjuntoTDA clavesA = dicA.claves();
		ConjuntoTDA clavesB = dicB.claves();
		
		// Claves Comunes
		ConjuntoTDA clavesComunes = interseccion(clavesA, clavesB);
				
		while(!clavesComunes.conjuntoVacio()){
			int clave = clavesComunes.elegir();
			clavesComunes.sacar(clave);			
			
			// Elementos Comunes
			ConjuntoTDA elementosComunes = interseccion(dicA.recuperar(clave), dicB.recuperar(clave));
			
			while(!elementosComunes.conjuntoVacio()){
				int valor = elementosComunes.elegir();
				elementosComunes.sacar(valor);				
				diccionarioAux.agregar(clave, valor);
			}
		}
		
		return diccionarioAux;
	}
	
	private static ConjuntoTDA interseccion(ConjuntoTDA conjuntoA, ConjuntoTDA conjuntoB){
		ConjuntoTDA conjuntoInterseccion = new ConjuntoLD();
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		
		conjuntoInterseccion.inicializarConjunto();		
		conjuntoAux.inicializarConjunto();

		while(!conjuntoA.conjuntoVacio()){
			int x = conjuntoA.elegir();
			
			if(conjuntoB.pertenece(x)){
				if(!conjuntoInterseccion.pertenece(x)){
					conjuntoInterseccion.agregar(x);
				}				
			}
			
			conjuntoA.sacar(x);
			conjuntoAux.agregar(x);
		}
		
		while(!conjuntoAux.conjuntoVacio()){
			conjuntoA.agregar(conjuntoAux.elegir());
			conjuntoAux.sacar(conjuntoAux.elegir());
		}
		
		return conjuntoInterseccion;		
	}	
	
}
