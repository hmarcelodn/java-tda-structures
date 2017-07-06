package tp1;

import impl.ColaPrioridad2Arr;
import api.ColaPrioridadTDA;

/**
 * b) Determinar si dos Colas con prioridad son idénticas.
 * @author Marcelo
 *
 */
public class TP1_6B {	
	
	public static void main(String[] args) {
		ColaPrioridadTDA cp1 = new ColaPrioridad2Arr();
		ColaPrioridadTDA cp2 = new ColaPrioridad2Arr();
				
		cp1.inicializarCola();
		cp2.inicializarCola();
		
		cp1.acolarPrioridad(10, 1);
		cp1.acolarPrioridad(10, 2);
		cp1.acolarPrioridad(10, 3);
		
		cp2.acolarPrioridad(10, 1);
		cp2.acolarPrioridad(10, 2);
		cp2.acolarPrioridad(10, 3);
		
		if(compararIgualdadColasPrioridad(cp1, cp2)){
			System.out.print("Colas de prioridad cp1/cp2 iguales");
		}
		else{
			System.out.print("Colas de prioridad cp1/cp2 no iguales");
		}		
	}
	
	private static boolean compararIgualdadColasPrioridad(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2){
		
		while(!cp1.colaVacia() && !cp2.colaVacia()){
			if((cp1.prioridad() != cp2.prioridad()) || (cp1.primero() != cp2.primero())){
				break;
			}
			
			cp1.desacolar();
			cp2.desacolar();
		}
		
		if(cp1.colaVacia() == cp2.colaVacia()){
			return true;
		}
		
		return false;
	}

}
