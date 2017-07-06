package api;

// TDA FIFO
public interface ColaTDA {
	
	void inicializarCola();
	
	//Pre-Condicion: Cola Inicializada
	void acolar(int x);
	
	//Pre-Condicion: Cola Inicializada y no vacia.
	void desacolar();
	
	//Pre-Condicion: Cola inicializada.
	boolean colaVacia();
	
	//Pre-Condicion: Cola inicializada y no vacia.
	int primero();
}
