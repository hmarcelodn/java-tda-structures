package api;

public interface DiccionarioSimpleTDA {

	void inicializarDiccionario();
	
	void agregar(int clave, int valor);
	
	int clave2Indice(int clave);
	
	void eliminarClave(int clave);
	
	int recuperar(int clave);
	
	ConjuntoTDA claves();	
}
