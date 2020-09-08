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
		String[] ret1 = datagrama.calcularFlags(1);
		String[] aux1 = {"000"};
		assertArrayEquals(aux1, ret1);
		String[] ret2 = datagrama.calcularFlags(0);
		String[] aux2 = {};
		assertArrayEquals(aux2, ret2);
	}

}
