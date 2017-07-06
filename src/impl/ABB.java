package impl;

import api.ABBTDA;

public class ABB implements ABBTDA {

	class Nodo{
		int info;
		ABBTDA hijoIzquierdo;
		ABBTDA hijoDerecho;
	}
	
	Nodo raiz;
	
	public int raiz() {
		return raiz.info;
	}

	public ABBTDA hijoIzq() {
		return raiz.hijoIzquierdo;
	}

	public ABBTDA hijoDer() {
		return raiz.hijoDerecho;
	}

	public boolean arbolVacio() {
		return (raiz == null);
	}

	public void inicializarArbol() {
		raiz = null;
	}

	public void agregarElemento(int x) {
		// Si el arbol esta vacio inicializo raiz y sus hijos laterales
		if(raiz == null){
			raiz = new Nodo();
			raiz.info = x;
			raiz.hijoDerecho = new ABB();
			raiz.hijoIzquierdo = new ABB();
		}
		// Si el valor x es menor que la raiz actual entonces lo agregamos en el arbol derecho.
		else if(raiz.info > x){
			raiz.hijoIzquierdo.agregarElemento(x);
		}
		// Si el valor x es mayor que la raiz actual entonces lo agregamos en el arbol izquierdo.
		else{
			raiz.hijoDerecho.agregarElemento(x);
		}
	}

	public void eliminarElemento(int x) {
		if(raiz != null){
			// Si estoy en el raiz nuleo la referencia.
			if(raiz.info == x && (raiz.hijoDerecho.arbolVacio() && raiz.hijoIzquierdo.arbolVacio())){
				raiz = null;
			}
			// Si encontro el valor en un nodo, buscar un sustituto entre los mayores.
			if(raiz.info == x && !raiz.hijoIzquierdo.arbolVacio()){
				raiz.info = mayor(raiz.hijoIzquierdo);
				raiz.hijoIzquierdo.eliminarElemento(x);
			}
			// Si encontro el valor en un nodo pero el arbol izquierda es nulo sustituimos por el menor del hijo derecho.
			if(raiz.info == x && (raiz.hijoIzquierdo.arbolVacio())){
				raiz.info = menor(raiz.hijoIzquierdo);
				raiz.hijoIzquierdo.eliminarElemento(x);
			}
			else if(raiz.info < x){
				raiz.hijoIzquierdo.eliminarElemento(x);
			}
			else{
				raiz.hijoDerecho.eliminarElemento(x);
			}
		}
	}

	private int mayor(ABBTDA a){		
		if(a.hijoDer().arbolVacio()){
			return a.raiz();
		}
		else{
			return mayor(a.hijoDer());
		}		
	}
	
	private int menor(ABBTDA a){
		if(a.hijoIzq().arbolVacio()){
			return a.raiz();
		}
		else{
			return menor(a.hijoIzq());
		}
	}
	
}
