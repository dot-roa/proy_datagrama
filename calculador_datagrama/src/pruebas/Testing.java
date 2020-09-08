package pruebas;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import proy_datagrama.Datagrama;

public class Testing {
	@Test
	public void fragmentarTest() {
		Datagrama d = new Datagrama();
		ArrayList<String> tam_fragmentos = d.fragmentar(1420, 620);
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("620","620","240")) ;
		assertArrayEquals(expected.toArray(), tam_fragmentos.toArray());
	}
	
}
