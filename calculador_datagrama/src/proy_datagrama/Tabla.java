package proy_datagrama;

import java.util.ArrayList;

public class Tabla {
	private ArrayList<String> filas = new ArrayList<String>();
	private Datagrama datagrama = new Datagrama();
	
	public Tabla(int tam_datagrama,int mtu) {
		ArrayList<String> tam_fragmentos = datagrama.fragmentar(tam_datagrama, mtu);
		String[] flags = datagrama.calcularFlags(tam_fragmentos.size());
		int[] desplazamientos = datagrama.calcularDesplazamiento(mtu, tam_fragmentos.size());
		
		for (int i = 0; i < tam_fragmentos.size() ; i++) {
			//Desplazamiento en binario
			String desBin = Util.convertirDecimalAStringBinario(desplazamientos[i]);
			int numZeros = 13 - desBin.length();
			String repeated = new String(new char[numZeros]).replace("\0", "0");
			desBin = String.format("%s%s", repeated, desBin);
			String fila = "";
			fila += tam_fragmentos.get(i) + "\t |";
			fila += flags[i] + "\t |";
			fila += desBin + "\t |";
			fila += desplazamientos[i] + "\t |";
			fila += Util.convertirBinarioAHexa(String.format("%s%s", flags[i], desBin));
			filas.add(fila);
		}
	}
	
	public void imprimir() {
		for (String fila : filas) {
			System.out.println(fila);
		}
	}
}
