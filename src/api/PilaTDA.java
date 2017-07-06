package api;

// TDA LIFO
public interface PilaTDA {
		
	void inicializarPila();
	
	//Pre-Condicion: Pila Inicializada.
	void apilar(int x);
	
	//Pre-Condicion: Pila Inicializada.
	void desapilar();
	
	//Siempre que la pila este vacia.
	boolean pilaVacia();
	
	//Pre-Condicion: Pila Inicializada y no vacia.
	int tope();
}
