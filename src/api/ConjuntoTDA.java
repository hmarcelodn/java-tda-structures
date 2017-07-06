package api;

public interface ConjuntoTDA {

	void agregar(int x);
	
	boolean conjuntoVacio();
	
	int elegir();
	
	void inicializarConjunto();
	
	boolean pertenece(int x);

	void sacar(int x);
	
}
