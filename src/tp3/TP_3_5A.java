package tp3;

import impl.DicMultipleA;
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class TP_3_5A {

	public static void main(String[] args) {
		DiccionarioMultipleTDA diccionarioA = new DicMultipleA();
		DiccionarioMultipleTDA diccionarioB = new DicMultipleA();
		
		diccionarioA.inicializarDiccionario();
		diccionarioB.inicializarDiccionario();
		
		diccionarioA.agregar(100, 1);
		diccionarioA.agregar(100, 2);
		diccionarioA.agregar(200, 3);
		
		diccionarioB.agregar(100, 4);
		diccionarioB.agregar(200, 6);
		
		DiccionarioMultipleTDA diccionarioResultado = obtenerValoressPorClaves(diccionarioA, diccionarioB);		
		ConjuntoTDA claves = diccionarioResultado.claves();
		
		while(!claves.conjuntoVacio()){
			int clave = claves.elegir();
			claves.sacar(clave);
			
			System.out.print("Clave: " + clave + "\n");
			
			ConjuntoTDA valores = diccionarioResultado.recuperar(clave);
			
			while(!valores.conjuntoVacio()){
				int valor = valores.elegir();
				valores.sacar(valor);
				
				System.out.print("> " + valor + "\n");
			}
		}
	}
	
	private static DiccionarioMultipleTDA obtenerValoressPorClaves(DiccionarioMultipleTDA diccionarioA, 
																   DiccionarioMultipleTDA diccionarioB ){
		
		DiccionarioMultipleTDA diccionarioAux = new DicMultipleA();
		diccionarioAux.inicializarDiccionario();
		
		ConjuntoTDA clavesDiccionarioA = diccionarioA.claves();
		ConjuntoTDA clavesDiccionarioB = diccionarioB.claves();
		
		while(!clavesDiccionarioA.conjuntoVacio() || !clavesDiccionarioB.conjuntoVacio()){			
			if(!clavesDiccionarioA.conjuntoVacio()){
				int clave = clavesDiccionarioA.elegir();
				clavesDiccionarioA.sacar(clave);
				
				ConjuntoTDA valores = diccionarioA.recuperar(clave);
				
				while(!valores.conjuntoVacio()){
					int valor = valores.elegir();
					valores.sacar(valor);
					diccionarioAux.agregar(clave, valor);
				}
			}
			
			if(!clavesDiccionarioB.conjuntoVacio()){
				int clave = clavesDiccionarioB.elegir();
				clavesDiccionarioB.sacar(clave);
				
				ConjuntoTDA valores = diccionarioB.recuperar(clave);
				
				while(!valores.conjuntoVacio()){
					int valor = valores.elegir();
					valores.sacar(valor);
					diccionarioAux.agregar(clave, valor);
				}
			}
		}
		
		return diccionarioAux;
	}

}

