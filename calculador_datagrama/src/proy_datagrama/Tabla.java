package proy_datagrama;

import java.util.ArrayList;

public class Tabla {
	private ArrayList<String> filas = new ArrayList<String>();
	private Datagrama datagrama = new Datagrama();
	
	public Tabla(int tam_datagrama,int mtu) {
		ArrayList<String> tam_fragmentos = datagrama.fragmentar(tam_datagrama, mtu);
		int[] desplazamientos = datagrama.calcularDesplazamiento(mtu, tam_fragmentos.size());
		
		for (int i = 0; i < tam_fragmentos.size() ; i++) {
			String fila = "";
			fila+= tam_fragmentos.get(i)+"\t |";
			fila += desplazamientos[i] + "\t";
			fila += Util.convertirDecimalAStringBinario(desplazamientos[i]);
			filas.add(fila);
		}
	}
}
