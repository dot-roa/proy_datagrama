package proy_datagrama;

public class Datagrama {

	/**
	 * Llena un arreglo de String con cada uno de los Flags de cada fragmentos
	 * @param cantFragmentos Cantidad de partes en que se divide el datagrama
	 * @return Un arreglo de String donde cada posicion indica los flags de cada fragmento
	 *         en orden, la primera posición corresponde al primer fragmento, la segunda al segundo, etc ... 
	 */
	public String[] calcularFlags(int cantFragmentos) {

		String[] flags = new String[cantFragmentos];
		if (cantFragmentos == 1) {
			flags[0] = "010";
			return flags;
		}

		for (int i = 0; i < flags.length; i++) {

			if (i == flags.length - 1) {
				flags[i] = "010";
				return flags;
			} else {
				flags[i] = "011";
			}
		}

		return flags;

	}

}
