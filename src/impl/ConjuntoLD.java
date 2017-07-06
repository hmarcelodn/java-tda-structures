package impl;

import api.ConjuntoTDA;

public class ConjuntoLD implements ConjuntoTDA {

	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo c;
	
	public void agregar(int x) {
		if(!this.pertenece(x)){
			Nodo aux = new Nodo();
			aux.info = x;
			aux.sig = c;
			c = aux;
		}
	}

	public boolean conjuntoVacio() {
		return (c == null);
	}

	public int elegir() {
		return c.info;
	}

	public void inicializarConjunto() {
		c = null;
	}

	public boolean pertenece(int x) {		
		Nodo aux = c;
		
		while((aux != null) && (aux.info != x)){
			aux = aux.sig;
		}
		
		return (aux != null);
	}

	public void sacar(int x) {
		Nodo aux = c;
		
		if(this.pertenece(x)){
			while(aux != null && aux.info != x){
				aux = aux.sig;
			}
			
			c = aux.sig;
		}
	}

}
