package proy_datagrama;

import java.util.ArrayList;

public class Tabla {
	private ArrayList<String> filas = new ArrayList<String>();
	private Datagrama datagrama = new Datagrama();
	
	public Tabla(int tam_datagrama,int mtu) {
		ArrayList<String> tam_fragmentos = datagrama.fragmentar(tam_datagrama, mtu);
		String[] flags = datagrama.calcularFlags(tam_fragmentos.size());
		int[] desplazamientos = datagrama.calcularDesplazamiento(mtu, tam_fragmentos.size());
		filas.add(crearEncabezadoTabla());
		
		for (int i = 0; i < tam_fragmentos.size() ; i++) {
			//Desplazamiento en binario
			String desBin = Util.convertirDecimalAStringBinario(desplazamientos[i]);
			int numZeros = 13 - desBin.length();
			String repeated = new String(new char[numZeros]).replace("\0", "0");
			desBin = String.format("%s%s", repeated, desBin);
			String fila = "\t\t"+i+ "\t |";
			fila += "\t\t"+tam_fragmentos.get(i) + "\t |";
			fila += "\t\t"+flags[i] + "\t\t|";
			fila += "\t"+desBin + "\t |";
			fila += "\t\t"+desplazamientos[i] + "\t |";
			fila += "\t\t"+Util.convertirBinarioAHexa(String.format("%s%s", flags[i], desBin));
			filas.add(fila);
		}		
	}
	
	public void imprimir() {
		for (String fila : filas) {
			System.out.println(fila);
		}
	}
	
	public String crearEncabezadoTabla() {
		String fila = "";
		fila += "\tPaquete No.\t |";
		fila += "\tTam frag\t |";
		fila += "\t0 | df | mf\t\t|";
		fila += "\tOffset bin\t |";
		fila += "\tOffset dec\t |";
		fila += "\thexa";
		return fila;
	}
	
}
