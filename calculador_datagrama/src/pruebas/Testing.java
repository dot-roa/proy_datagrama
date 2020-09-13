package pruebas;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import proy_datagrama.Datagrama;
import proy_datagrama.Util;

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
	
	@Test
	public void testCalcularDesplazamientos() {
		int[] res = datagrama.calcularDesplazamiento(620, 3);
		int[] aux = {0, 600, 1200};
		assertArrayEquals(aux, res);
		
	}
	@Test
	public void testFragmentar() {
		Datagrama d = new Datagrama();
		ArrayList<String> tam_fragmentos = d.fragmentar(1420, 620);
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("620","620","240")) ;
		assertArrayEquals(expected.toArray(), tam_fragmentos.toArray());
	}
	
	@Test 
	public void prueba_1() {
		Datagrama d = new Datagrama();
		int tam_datagrama = 3578;
		int mtu = 560;
		int n_fragmentos = d.calcularCantFragmentos(tam_datagrama, mtu);
		System.out.println(n_fragmentos);
		
		ArrayList<String> tam_fragmentos = d.fragmentar(tam_datagrama, mtu);
		String[] flags = d.calcularFlags(n_fragmentos);
		int[] arrOffsets = d.calcularDesplazamiento(mtu, n_fragmentos);
		String[] arrOffsetsBin = Util.convertirArrDecABin(arrOffsets);
		String[] hexas16bits = d.calcular16bitsHexa(flags, arrOffsetsBin);

		String [] exp_tam_fragmentos = {"560","560","560","560","560","560","358"};
		String [] exp_flags = {"001","001","001","001","001","001","000"};
		int [] exp_offsets = {0,  540, 1080, 1620, 2160, 2700, 3240}; 
		String [] exp_hexas = {"2000", "221C", "2438", "2654", "2870", "2A8C", "CA8"};
		
		assertArrayEquals(exp_tam_fragmentos, tam_fragmentos.toArray()); 
		assertArrayEquals(exp_flags, flags);
		assertArrayEquals(exp_offsets, arrOffsets);
		assertArrayEquals(exp_hexas, hexas16bits);
		
	}

}
