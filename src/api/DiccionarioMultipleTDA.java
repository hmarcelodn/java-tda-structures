package api;

public interface DiccionarioMultipleTDA {

	void inicializarDiccionario();
	
	void agregar(int clave, int valor);
	
	int clave2Indice(int clave);
	
	void eliminarClave(int clave);
	
	void eliminarValor(int clave, int valor);
	
	ConjuntoTDA recuperar(int clave);
	
	ConjuntoTDA claves();	
	
}
