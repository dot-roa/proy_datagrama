package proy_datagrama;

import java.util.Scanner;

public class Datagrama {

	public void fragmentar() {
		int tam_datagrama = 0;
		int mtu = 0;
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Por favor ingrese el");
		tam_datagrama = Integer.parseInt(scn.nextLine());
		mtu = Integer.parseInt(scn.nextLine());
		
		//TO-DO: Verificar que la fragmentación se haga de esta manera en las diapos.
		int datagrama_headerless = tam_datagrama - 8;
		int fragmentos = (int) Math.ceil(datagrama_headerless / mtu);
	}
}
