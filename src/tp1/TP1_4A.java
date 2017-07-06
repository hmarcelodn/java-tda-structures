package tp1;

import impl.Cola;
import api.ColaTDA;

/**
 * Pasar una Cola a otra
 * @author hdelnegro
 *
 */
public class TP1_4A {

	public static void main(String[] args) {
		ColaTDA cola1 = new Cola();
		ColaTDA cola2 = new Cola();
		
		cola1.inicializarCola();
		cola2.inicializarCola();
		
		cola1.acolar(1);
		cola1.acolar(2);
		cola1.acolar(3);
		
		pasarColaACola(cola1, cola2);
	}
	
	public static void pasarColaACola(ColaTDA origen, ColaTDA destino){
		while(!origen.colaVacia()){
			destino.acolar(origen.primero());
			origen.desacolar();
		}
	}
}
