package tp1;

import api.ColaPrioridadTDA;
import impl.ColaPrioridad2Arr;
import impl.ColaPrioridadStruct;

/**
 *  a) Combinar dos colas con prioridades CP1 y CP2, generando una nueva cola con prioridades. 
 *     Considerar que a igual prioridad, los elementos de la CP1 son más prioritarios que los de la CP2.
 * @author hdelnegro
 *
 */
public class TP1_6A {
	
	public static void main(String[] args) {
		ColaPrioridadTDA cp1 = new ColaPrioridad2Arr();
		ColaPrioridadTDA cp2 = new ColaPrioridad2Arr();
		
		cp1.inicializarCola();
		cp2.inicializarCola();
		
		cp1.acolarPrioridad(10, 1);
		cp1.acolarPrioridad(10, 2);
		cp1.acolarPrioridad(2, 3);
		
		cp2.acolarPrioridad(20, 1);
		cp2.acolarPrioridad(20, 2);
		cp2.acolarPrioridad(2, 3);
		
		ColaPrioridadTDA cp3 = combinarColasPrioridad(cp1, cp2);
		
		// Resultado
		while(!cp3.colaVacia()){
			System.out.print("[" + cp3.prioridad() + "," + cp3.primero() + "]\n");
			cp3.desacolar();
		}
		
	}

	private static ColaPrioridadTDA combinarColasPrioridad(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2){
		ColaPrioridadTDA colaPrioridadCombinada = new ColaPrioridadStruct();
		colaPrioridadCombinada.inicializarCola();
		
		if(cp1.colaVacia() && cp2.colaVacia()){			
			return colaPrioridadCombinada;
		}
		
		if(cp1.colaVacia() && !cp2.colaVacia()){
			return  cp2;
		}
		
		if(!cp1.colaVacia() && cp2.colaVacia()){
			return cp1;
		}
		
		while(!cp1.colaVacia()){						
			colaPrioridadCombinada.acolarPrioridad(cp1.primero(), cp1.prioridad());
			cp1.desacolar();
		}
		
		while(!cp2.colaVacia()){		
			colaPrioridadCombinada.acolarPrioridad(cp2.primero(), cp2.prioridad());
			cp2.desacolar();
		}
		
		return colaPrioridadCombinada;
		
	}
	
}
