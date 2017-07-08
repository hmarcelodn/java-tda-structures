package impl;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class GrafoMA implements GrafoTDA{

	int[][] matrizAdyacencia;
	int[] mapa;
	int n = 100; // Indica el tamano de la matriz y arreglo de mapa
	int cantNodos = 0; 
	
	public void inicializarGrafo() {
		matrizAdyacencia = new int[n][n];
		mapa = new int[n];
		cantNodos = 0;
	}

	public void agregarVertice(int v) {
		mapa[cantNodos] = v;
		
		for(int i = 0; i <= cantNodos; i++){
			matrizAdyacencia[cantNodos][i] = 0;
			matrizAdyacencia[i][cantNodos] = 0;
		}
		
		cantNodos++;
	}

	public void eliminarVertice(int v) {
		int indice = this.vert2Indice(v);
		
		for(int k = 0; k < cantNodos; k++){
			matrizAdyacencia[k][indice] = matrizAdyacencia[k][cantNodos - 1];
		}
		
		for(int k = 0; k < cantNodos; k++){
			matrizAdyacencia[indice][k] = matrizAdyacencia[cantNodos - 1][k];
		}
		
		mapa[indice] = mapa[cantNodos - 1];
		cantNodos--;
	}

	public ConjuntoTDA vertices() {
		ConjuntoTDA conjuntoVertices = new ConjuntoLD();
		conjuntoVertices.inicializarConjunto();
		
		for(int k = 0; k < cantNodos; k++){
			conjuntoVertices.agregar(mapa[k]);
		}
		
		return conjuntoVertices;
	}

	public void agregarArista(int v1, int v2, int peso) {
		int indiceOrigen = this.vert2Indice(v1);
		int indiceDestino = this.vert2Indice(v2);
		
		matrizAdyacencia[indiceOrigen][indiceDestino] = peso;
	}

	public void eliminarArista(int v1, int v2) {
		int indiceOrigen = this.vert2Indice(v1);
		int indiceDestino = this.vert2Indice(v2);
		
		matrizAdyacencia[indiceOrigen][indiceDestino] = 0;
	}

	public boolean existeArista(int v1, int v2) {
		int indiceOrigen = this.vert2Indice(v1);
		int indiceDestino = this.vert2Indice(v2);
		
		return (matrizAdyacencia[indiceOrigen][indiceDestino] != 0);
	}

	public int pesoArista(int v1, int v2) {
		int indiceOrigen = this.vert2Indice(v1);
		int indiceDestino = this.vert2Indice(v2);
		
		return matrizAdyacencia[indiceOrigen][indiceDestino];
	}
	
	private int vert2Indice(int v){
		int i = cantNodos - 1;
		
		while(i >= 0 && mapa[i] != v){			
			i++;
		}
		
		return i;
	}

}
