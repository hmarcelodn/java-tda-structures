package tp3;

import impl.ConjuntoLD;
import impl.DicMultipleA;
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class TP_3_5C {

	public static void main(String[] args) {
		DiccionarioMultipleTDA diccionarioMultipleA = new DicMultipleA();
		DiccionarioMultipleTDA diccionarioMultipleB = new DicMultipleA();
		
		diccionarioMultipleA.inicializarDiccionario();
		diccionarioMultipleB.inicializarDiccionario();
		
		diccionarioMultipleA.agregar(100, 1);
		diccionarioMultipleA.agregar(100, 2);
		diccionarioMultipleA.agregar(100, 3);
		diccionarioMultipleA.agregar(200, 1);
		
		diccionarioMultipleB.agregar(100, 1);
		diccionarioMultipleB.agregar(100, 2);
		diccionarioMultipleB.agregar(100, 6);
		diccionarioMultipleA.agregar(300, 1);
		
		DiccionarioMultipleTDA dicResultado = diccionarioComun(diccionarioMultipleA, diccionarioMultipleB);
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

	private static DiccionarioMultipleTDA diccionarioComun(DiccionarioMultipleTDA dicA, DiccionarioMultipleTDA dicB){
		DiccionarioMultipleTDA diccionarioAux = new DicMultipleA();
		diccionarioAux.inicializarDiccionario();
		
		ConjuntoTDA clavesDicA = dicA.claves();
		ConjuntoTDA clavesDicB = dicB.claves();
		
		ConjuntoTDA clavesComunes = new ConjuntoLD();
		clavesComunes.inicializarConjunto();
		
		while(!clavesDicA.conjuntoVacio()){
			int clave = clavesDicA.elegir();
			clavesDicA.sacar(clave);
			
			if(clavesDicB.pertenece(clave)){
				ConjuntoTDA elementosA = dicA.recuperar(clave);
				ConjuntoTDA elementosB = dicB.recuperar(clave);
				
				while(!elementosA.conjuntoVacio() || !elementosB.conjuntoVacio()){
					agregarElementoDiccionario(diccionarioAux, elementosA, clave);
					agregarElementoDiccionario(diccionarioAux, elementosB, clave);
				}
			}						
		}
		
		return diccionarioAux;
	} 
	
	private static void agregarElementoDiccionario(DiccionarioMultipleTDA dic, ConjuntoTDA elementos, int clave){
		if(!elementos.conjuntoVacio()){
			int valor = elementos.elegir();
			elementos.sacar(valor);
			dic.agregar(clave, valor);
		}		
	}
}
