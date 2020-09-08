package proy_datagrama;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int tam_datagrama = 0;
		int mtu = 0;

		Scanner scn = new Scanner(System.in);
		System.out.println("Por favor ingrese el tamanio del datagrama: ");
		tam_datagrama = Integer.parseInt(scn.nextLine());
		System.out.println("Por favor ingrese el mtu de la red: ");		
		mtu = Integer.parseInt(scn.nextLine());
		
		Tabla tabla = new Tabla(tam_datagrama, mtu);
		tabla.imprimir();
		scn.close();
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
