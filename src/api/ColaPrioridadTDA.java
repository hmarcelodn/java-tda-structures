package api;

public interface ColaPrioridadTDA {
	
	void inicializarCola();
	
	//Pre-Condicion: Cola inicializada.
	void acolarPrioridad(int x, int prioridad);
	
	//Pre-Condicion: Cola inicializada y no vacia.
	void desacolar();
	
	//Pre-Condicion: Cola inicializada y no vacia.
	int primero();
	
	//Pre-Condicion: Cola inicializada.
	boolean colaVacia();
	
	//Pre-Condicion: Cola inicializada y no vacia.
	int prioridad();
	
}
