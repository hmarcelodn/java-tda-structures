package tp3;

import impl.ColaPrioridadLD;
import impl.DicMultipleA;
import api.ColaPrioridadTDA;
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class TP_3_4A {

	public static void main(String[] args) {
		ColaPrioridadTDA colaPrioridad = new ColaPrioridadLD();
		colaPrioridad.inicializarCola();
		
		colaPrioridad.acolarPrioridad(100, 1);
		colaPrioridad.acolarPrioridad(100, 2);
		colaPrioridad.acolarPrioridad(200, 3);
		colaPrioridad.acolarPrioridad(200, 4);
		
		DiccionarioMultipleTDA diccionarioResultado = obtenerPrioridadesPorValor(colaPrioridad);
		ConjuntoTDA conjuntoClaves = diccionarioResultado.claves();
		
		while(!conjuntoClaves.conjuntoVacio()){
			int clave = conjuntoClaves.elegir();
			conjuntoClaves.sacar(clave);
			System.out.print("Clave: " + clave + "\n");
			
			ConjuntoTDA valores = diccionarioResultado.recuperar(clave);
			
			while(!valores.conjuntoVacio()){
				int valor = valores.elegir();
				valores.sacar(valor);
				System.out.print(valor + "\n");				
			}			
		}
	}
	
	public static DiccionarioMultipleTDA obtenerPrioridadesPorValor(ColaPrioridadTDA colaPrioridad){
		DiccionarioMultipleTDA diccionarioMultiple = new DicMultipleA();
		diccionarioMultiple.inicializarDiccionario();
		
		while(!colaPrioridad.colaVacia()){
			int val = colaPrioridad.primero();
			int prio = colaPrioridad.prioridad();
			
			colaPrioridad.desacolar();
			diccionarioMultiple.agregar(val, prio);						
		}
		
		
		return diccionarioMultiple;
	}

}
