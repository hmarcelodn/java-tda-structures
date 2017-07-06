package tp3;

import api.ColaTDA;
import api.ConjuntoTDA;
import impl.ColaLD;
import impl.ConjuntoLD;

public class TP_3_2C {

	public static void main(String[] args) {
		ColaTDA cola = new ColaLD();
		cola.inicializarCola();
		
		cola.acolar(1);
		cola.acolar(1);
		cola.acolar(2);
		cola.acolar(3);
		cola.acolar(3);
		cola.acolar(4);
		
		ConjuntoTDA conjuntoRepetidos = obtenerRepetidos(cola);
		
		while(!conjuntoRepetidos.conjuntoVacio()){
			int x = conjuntoRepetidos.elegir();
			conjuntoRepetidos.sacar(x);
			System.out.print(x + "\n");
		}
	}

	private static ConjuntoTDA obtenerRepetidos(ColaTDA cola){
		ConjuntoTDA conjuntoAux = new ConjuntoLD();
		ConjuntoTDA conjuntoRep = new ConjuntoLD();
		
		conjuntoAux.inicializarConjunto();
		conjuntoRep.inicializarConjunto();
		
		while(!cola.colaVacia()){
			if(!conjuntoAux.pertenece(cola.primero())){
				conjuntoAux.agregar(cola.primero());
			}
			else{
				conjuntoRep.agregar(cola.primero());
			}
			
			cola.desacolar();
		}
		
		return conjuntoRep;
	}	
	
}
