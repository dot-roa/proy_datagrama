package proy_datagrama;

import java.util.Scanner;

import org.junit.jupiter.api.condition.OS;

public class Main {

	public static void main(String[] args) {
		int tam_datagrama = 0;
		int mtu = 0;
		String input;
		boolean continuar = true;
		
		String msg = "Calculadora para Datagramas de paquetes enviados por la red\n"
				+ "Autores: - Juan Manuel Roa Mejia\n"
				+ "	 - Miguel Angel Rodriguez Novoa\n"
				+ "	 - Wilmar Stiven Valencia Cardona\n"
				+ "v1.0.0\n"
				+ "==================================================================\n";

		System.out.println(msg);
		Scanner scn = new Scanner(System.in);
		while(continuar) {
			System.out.println("Por favor ingrese el tamano del datagrama: ");
			input = scn.nextLine();
			if(Util.isNumber(input)) {
				tam_datagrama = Integer.parseInt(input);
				System.out.println("Por favor ingrese el mtu de la red: ");		
				input = scn.nextLine();
				if(Util.isNumber(input)) {
					mtu = Integer.parseInt(input);
					Tabla tabla = new Tabla(tam_datagrama, mtu);
					tabla.imprimir();
					
					System.out.println("======================"
							+ "===================="
							+ "===================="
							+ "===================="
							+ "===================="
							+ "===================="
							+ "===========================");
					boolean flag = true;
					while(flag) {
						System.out.println("");
						System.out.println("¿Desea ingresar otra red? (y/n):");
						input = scn.nextLine();
						
						if(input.equalsIgnoreCase("n")) {
							continuar = false;
							flag = false;
						}
						else if(input.equalsIgnoreCase("y")) {
							continuar = true;
							flag = false;
						}
						else {
							System.out.println("letra invalida");
						}
					}
				} else
					System.out.println("Por favor ingrese datos validos");
			} else
				System.out.println("Por favor ingrese datos validos");
		}
		scn.close();
		System.out.println("!Muchas gracias por usar nuestra aplicacion, lo esperamos pronto!");
		
		
	}
	
}
