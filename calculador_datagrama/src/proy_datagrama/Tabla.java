package proy_datagrama;

import java.util.ArrayList;

public class Tabla {
	private ArrayList<String> filas = new ArrayList<String>();
	private Datagrama datagrama = new Datagrama();
	
	public Tabla() {
		 
		int[] desplazamientos = datagrama.calcularDesplazamiento(mtu, cantFragmentos);
		
		String fila = "";
		construirFila(desplazamientos[i]);
		
		filas.add(fila);
	}
	
	public String construirFila(int desplazamiento) {
		String fila = "";
		fila += desplazamiento + "\t";
		fila += Util.convertirDecimalAStringBinario(desplazamiento);
		return fila;
	}
	
}
