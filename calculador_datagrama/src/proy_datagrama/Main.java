package proy_datagrama;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int tam_datagrama = 0;
		int mtu = 0;

		Scanner scn = new Scanner(System.in);
		System.out.println("Por favor ingrese el");
		tam_datagrama = Integer.parseInt(scn.nextLine());
		mtu = Integer.parseInt(scn.nextLine());
		
		Tabla tabla = new Tabla(tam_datagrama,mtu);
	}

	public static void mensajear_roa() {
		System.out.println("Hola mundo vamos a probar la magia de git :D");
	}

	public static void printMessage() {
		System.out.println("Ultima prueba prro");
	}
	
	public static void printATodos() 
	{
		System.out.println("Esto es un print hecho por wilmar");
	}
	
}
