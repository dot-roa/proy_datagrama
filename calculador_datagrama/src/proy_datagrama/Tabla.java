package proy_datagrama;

import java.util.ArrayList;

public class Tabla {
	ArrayList<String> filas = new ArrayList<String>();
	Datagrama datagrama = new Datagrama();
	
	public Tabla(int tam_datagrama,int mtu) {
		ArrayList<String> tam_fragmentos = datagrama.fragmentar(tam_datagrama, mtu);
		
		
		for (int i = 0; i < tam_fragmentos.size() ; i++) {
			String fila = "";
			fila+= tam_fragmentos.get(i)+"\t |";
			filas.add(fila);
		}		
	}
	
	public void imprimir() {
		for (String fila : filas) {
			System.out.println(fila);
		}
	}
	
}
