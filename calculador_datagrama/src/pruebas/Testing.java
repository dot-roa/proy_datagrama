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
	public void fragmentarTest() {
		Datagrama d = new Datagrama();
		ArrayList<String> tam_fragmentos = d.fragmentar(1420, 620);
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("620","620","240")) ;
		assertArrayEquals(expected.toArray(), tam_fragmentos.toArray());
	}
	
	@Test 
	public void casoDePrueba01() {
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
	
	@Test 
	public void casoDePrueba02() {
		Datagrama d = new Datagrama();
		int tam_datagrama = 4500;
		int mtu = 820;
		int n_fragmentos = d.calcularCantFragmentos(tam_datagrama, mtu);
		System.out.println(n_fragmentos);
		
		ArrayList<String> tam_fragmentos = d.fragmentar(tam_datagrama, mtu);
		String[] flags = d.calcularFlags(n_fragmentos);
		int[] arrOffsets = d.calcularDesplazamiento(mtu, n_fragmentos);
		String[] arrOffsetsBin = Util.convertirArrDecABin(arrOffsets);
		String[] hexas16bits = d.calcular16bitsHexa(flags, arrOffsetsBin);

		String [] exp_tam_fragmentos = {"820","820","820","820","820","520"};
		String [] exp_flags = {"001","001","001","001","001","000"};
		int [] exp_offsets = {0,  800, 1600, 2400, 3200, 4000}; 
		String [] exp_hexas = {"2000", "2320", "2640", "2960", "2C80", "FA0"};
		
		assertArrayEquals(exp_tam_fragmentos, tam_fragmentos.toArray()); 
		assertArrayEquals(exp_flags, flags);
		assertArrayEquals(exp_offsets, arrOffsets);
		assertArrayEquals(exp_hexas, hexas16bits);
		
	}
	
	@Test 
	public void casoDePrueba03() {
		Datagrama d = new Datagrama();
		int tam_datagrama = 2720;
		int mtu = 800;
		int n_fragmentos = d.calcularCantFragmentos(tam_datagrama, mtu);
		System.out.println(n_fragmentos);
		
		ArrayList<String> tam_fragmentos = d.fragmentar(tam_datagrama, mtu);
		String[] flags = d.calcularFlags(n_fragmentos);
		int[] arrOffsets = d.calcularDesplazamiento(mtu, n_fragmentos);
		String[] arrOffsetsBin = Util.convertirArrDecABin(arrOffsets);
		String[] hexas16bits = d.calcular16bitsHexa(flags, arrOffsetsBin);

		String [] exp_tam_fragmentos = {"800","800","800","400"};
		String [] exp_flags = {"001","001","001","000"};
		int [] exp_offsets = {0,  780, 1560, 2340}; 
		String [] exp_hexas = {"2000", "230C", "2618", "924"};
		
		assertArrayEquals(exp_tam_fragmentos, tam_fragmentos.toArray()); 
		assertArrayEquals(exp_flags, flags);
		assertArrayEquals(exp_offsets, arrOffsets);
		assertArrayEquals(exp_hexas, hexas16bits);
		
	}

}
