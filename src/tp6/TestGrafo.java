package tp6;

import impl.GrafoMA;
import api.GrafoTDA;

public class TestGrafo {

	public static void main(String[] args) {
		
		GrafoTDA grafo = new GrafoMA();
		grafo.inicializarGrafo();
		grafo.agregarVertice(3);
	}

}
