package pruebas;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import proy_datagrama.Datagrama;

public class Testing {
	
	Datagrama datagrama = new Datagrama();
	
	@Test
	public void testCalcularFlags() {
		String[] ret = datagrama.calcularFlags(5);
		String[] aux = {"001","001","001","001","000"};
		assertArrayEquals(aux, ret);
	}

}
