package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadLD implements ColaPrioridadTDA {
	
	class NodoPrioridad{
		int info;
		int prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad mayorPrioridad;
	
	public void inicializarCola() {
		mayorPrioridad = null;
	}

	public void acolarPrioridad(int x, int prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.info = x;
		nuevo.prioridad = prioridad;
		
		// Si la cola esta vacia o bien es m´as prioritario que
		// el primero hay que agregarlo al principio
		if(mayorPrioridad == null || prioridad > mayorPrioridad.prioridad){
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		}
		else{
			NodoPrioridad aux = mayorPrioridad;
			
			while(aux.sig != null && aux.sig.prioridad >= prioridad){
				aux = aux.sig; // Sigo con el siguiente
			}
			
			nuevo.sig = aux.sig; //El actual es ahora sucesor del nuevo
			aux.sig = nuevo; // El de menor prioridad es pisado por el nuevo. Piso la referencia.
		}
		
	}

	public void desacolar() {
		mayorPrioridad = mayorPrioridad.sig;
	}

	public int primero() {
		return mayorPrioridad.info;
	}

	public boolean colaVacia() {
		return (mayorPrioridad == null);
	}

	public int prioridad() {
		return mayorPrioridad.prioridad;
	}

}
