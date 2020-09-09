package proy_datagrama;

import java.util.ArrayList;
import java.util.Scanner;

public class Datagrama {

	/**
	 * Devuelve la cantidad de fragmentos que tendran que pasar por la red.
	 * @param tam_datagrama
	 * @param mtu
	 * @return
	 */
	
public int calcularCantFragmentos(int tam_datagrama, int mtu) {
	double n = tam_datagrama/(double)(mtu-20);	
	return (int) Math.ceil(n);
}

public String[] calcular16bitsHexa(String[] flags, String[] arrayOffsetsBin) {
	
	String [] hexas16bits = new String [flags.length];
	
	for (int i = 0; i < flags.length ; i++) {
		String bin = String.format("%s%s", flags[i], arrayOffsetsBin[i]);
		hexas16bits[i] = Util.convertirBinarioAHexa(bin);
		
	}
	
	return hexas16bits;
}
	
/**
 * Fragmenta el datagrama original dado un tamaño original y un MTU
 * @param tam_datagrama, mtu. El tamanio original del datagrama y el maximum transfer unit.
 * @return Un ArrayList de los tamanios de cada fragmento 
 * 
 */
	public ArrayList<String> fragmentar(int tam_datagrama, int mtu) {
		ArrayList<String> tam_fragmentos = new ArrayList<>();
		
		while(tam_datagrama > mtu-20) {
			tam_datagrama -= (mtu-20); //Se quitan 20 reservados para el encabezado
			tam_fragmentos.add(""+(mtu));
		}
		if (tam_datagrama == mtu) {
			tam_fragmentos.add(""+(mtu));
		}
		else {
			tam_fragmentos.add(""+(tam_datagrama+20));
		}		

		return tam_fragmentos;
	}

	/**
	 * Llena un arreglo de String con cada uno de los Flags de cada fragmentos
	 * 
	 * @param cantFragmentos Cantidad de partes en que se divide el datagrama
	 * @return Un arreglo de String donde cada posicion indica los flags de cada
	 *         fragmento en orden, la primera posici�n corresponde al primer
	 *         fragmento, la segunda al segundo, etc ...
	 */
	public String[] calcularFlags(int cantFragmentos) {

		String[] flags = new String[cantFragmentos];
		if (cantFragmentos == 1) {
			flags[0] = "000";
			return flags;
		}

		for (int i = 0; i < flags.length; i++) {

			if (i == flags.length - 1) {
				flags[i] = "000";
				return flags;
			} else {
				flags[i] = "001";
			}
		}

		return flags;

	}

	/**
	 * Metodo para calcular el desplazamiento de los fragmentos
	 * 
	 * @param mtu            el mtu de la red
	 * @param cantFragmentos numero de fragmentos del datagrama
	 * @return un arreglo con el desplazamiento de cada fragmento en decimal
	 */
	public int[] calcularDesplazamiento(int mtu, int cantFragmentos) {
		int[] desplazamiento = new int[cantFragmentos];
		int acum = 0;
		// Se le descuenta 20 bytes al mtu para el encabezado del fragmento
		mtu -= 20;
		for (int i = 0; i < cantFragmentos; i++) {
			desplazamiento[i] = acum;
			acum += mtu;
		}
		return desplazamiento;
	}

}
