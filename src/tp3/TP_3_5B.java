package tp3;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import impl.ConjuntoLD;
import impl.DicMultipleA;

public class TP_3_5B {

	public static void main(String[] args) {
		DiccionarioMultipleTDA diccionarioMultipleA = new DicMultipleA();
		DiccionarioMultipleTDA diccionarioMultipleB = new DicMultipleA();
		
		diccionarioMultipleA.inicializarDiccionario();
		diccionarioMultipleB.inicializarDiccionario();
		
		diccionarioMultipleA.agregar(100, 1);
		diccionarioMultipleA.agregar(100, 2);
		diccionarioMultipleA.agregar(100, 3);
		
		diccionarioMultipleB.agregar(100, 1);
		diccionarioMultipleB.agregar(100, 2);
		diccionarioMultipleB.agregar(100, 6);
		
		DiccionarioMultipleTDA dicResultado = obtenerClavesElementosComunes(diccionarioMultipleA, diccionarioMultipleB);
		
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
	
	private static DiccionarioMultipleTDA obtenerClavesElementosComunes(DiccionarioMultipleTDA dicA, DiccionarioMultipleTDA dicB){
		DiccionarioMultipleTDA diccionarioAux = new DicMultipleA();
		diccionarioAux.inicializarDiccionario();
		
		ConjuntoTDA dicAClaves = dicA.claves();
		ConjuntoTDA dicBClaves = dicB.claves();
		ConjuntoTDA dicClavesComunes = new ConjuntoLD();
		dicClavesComunes.inicializarConjunto();
		
		// Claves Comunes
		while(!dicAClaves.conjuntoVacio()){
			int clave = dicAClaves.elegir();
			dicAClaves.sacar(clave);
			
			if(dicBClaves.pertenece(clave)){
				dicClavesComunes.agregar(clave);
			}
		}
		
		// Elementos Comunes de Claves Comunes
		while(!dicClavesComunes.conjuntoVacio()){
			int claveComun = dicClavesComunes.elegir();
			dicClavesComunes.sacar(claveComun);
			
			ConjuntoTDA elementosDicA = dicA.recuperar(claveComun);
			ConjuntoTDA elementosDicB = dicB.recuperar(claveComun);
			
			ConjuntoTDA elementosComunes = new ConjuntoLD();
			elementosComunes.inicializarConjunto();
			
			while(!elementosDicA.conjuntoVacio()){
				int elemento = elementosDicA.elegir();
				elementosDicA.sacar(elemento);
				
				if(elementosDicB.pertenece(elemento)){
					diccionarioAux.agregar(claveComun, elemento);
					dicAClaves.sacar(claveComun);
					dicBClaves.sacar(claveComun);
				}
				
				elementosDicA.sacar(elemento);
			}
		}
		
		// Guardo en el diccionario el resto de las claves
		while(!dicAClaves.conjuntoVacio() || !dicBClaves.conjuntoVacio()){
			if(!dicAClaves.conjuntoVacio()){
				int x = dicAClaves.elegir();
				dicAClaves.sacar(x);		
				
				ConjuntoTDA elementos = dicA.recuperar(x);
				
				while(!elementos.conjuntoVacio()){
					int valor = elementos.elegir();
					elementos.sacar(valor);
					
					diccionarioAux.agregar(x, valor);
				}
			}
		}
				
		return diccionarioAux;
	}

}
