package proy_datagrama;

import java.util.ArrayList;

public class Util {
	
	/**
	 * Metodo para convetir un numero de base decimal a base binaria
	 * @param numero en base decimal
	 * @return un cadena con el numero binario
	 */
	public static String convertirDecimalAStringBinario(int decimal) 
	{
		String binario = Integer.toString(decimal, 2); //DECIMAL A BINARIO
		return binario;
	}
	
	/**
	 * Metodo para convetir un numero de base decimal a base binaria
	 * @param numero en base decimal
	 * @return un arreglo de bits
	 */
	public static int[] convertirDecimalABinario(int decimal) 
	{
		String binario = Integer.toString(decimal, 2); //DECIMAL A BINARIO
		int bits = binario.length();
		int[] arrBits = new int[bits];
		for(int i = 0; i < bits; i++) 
		{
			int bit = binario.charAt(i) - 48;
			arrBits[i] = bit;
		}
		
		return arrBits;
	}
	
	/**
	 * Metodo para convertir un numero de base binario a decimal
	 * @param cadena del numero binario
	 * @return el numero en decimal
	 */
	public static int convertirBinarioADecimal(String binario) 
	{
		int decimal = Integer.parseInt(binario, 2); //BINARIO A DECIMAL
		return decimal;
	}
	
	/**
	 * Metodo para convertir un numero de base binario a decimal
	 * @param arreglo del bits del numero
	 * @return el numero en decimal
	 */
	public static int convertirBinarioADecimal(int[] binario) 
	{
		String cadenaBinario = convertirArregloAString(binario);
		int decimal = Integer.parseInt(cadenaBinario, 2); //BINARIO A DECIMAL
		return decimal;
	}
	
	/**
	 * Metodo para convertir un numero en base decimal a hexadecimal
	 * @param el numero en base decimal
	 * @return el numero en base hexadecimal
	 */
	public static String convertirDecimalAHexa(int decimal) 
	{
		String hexa = Integer.toHexString(decimal); //DECIMAL A HEXA
		hexa = hexa.toUpperCase();
		return hexa;
	}
	
	/**
	 * Metodo para convertir un numero en base hexadecimal a decimal
	 * @param el numero en base hexadecimal
	 * @return el numero en base decimal
	 */
	public static int convertirHexaADecimal(String hexa) 
	{
		int decimal = Integer.parseInt(hexa, 16); //HEXA A DECIMAL
		return decimal;
	}
	
	
	/**
	 * Metodo para convetir un numero en base binaria a hexadecimal
	 * @param arreglo de bits
	 * @return el numero en hexadecimal
	 */
	public static String convertirBinarioAHexa(int[] binario) 
	{
		int decimal = convertirBinarioADecimal(binario);
		String hexa = convertirDecimalAHexa(decimal);
		hexa = hexa.toUpperCase();
		return hexa;
	}
	
	/**
	 * Metodo para convetir un numero en base binaria a hexadecimal
	 * @param cadena del numero binario
	 * @return el numero en hexadecimal
	 */
	public static String convertirBinarioAHexa(String binario) 
	{
		int decimal = convertirBinarioADecimal(binario);
		String hexa = convertirDecimalAHexa(decimal);
		hexa = hexa.toUpperCase();
		return hexa;
	}
	
	/**
	 * Metodo para convetir un numero en base hexadecimal a binaria
	 * @param el numero en base hexa
	 * @return arreglo de bits
	 */
	public static int[] convertirHexaABinario(String hexa) 
	{
		int decimal = convertirHexaADecimal(hexa);
		int[] binario = convertirDecimalABinario(decimal);
		return binario;
	}
	
	/**
	 * Metodo para convetir un numero en base hexadecimal a binaria
	 * @param el numero en base hexa
	 * @return cadena del numero binario
	 */
	public static String convertirHexaAStringBinario(String hexa) 
	{
		int decimal = convertirHexaADecimal(hexa);
		String binario = convertirDecimalAStringBinario(decimal);
		return binario;
	}
	
	public static String convertirArregloAString(int[] arreglo) {
		
		String salida = "";
		for (int i = 0; i < arreglo.length; i++) {
			salida += arreglo[i];					
		}
		return salida;
		
	}
	
	/**
	 * Convierte un arreglo de Decimales a un arreglo de binarios
	 * @param array
	 * @return arregloBin
	 */
	public static String[] convertirArrDecABin(int[] arrDec){
		String [] arrBin = new String[arrDec.length];
		
		for(int i = 0; i < arrDec.length ; i++) {
			String bin = convertirDecimalAStringBinario(arrDec[i]);
			int numZeros = 13 - bin.length(); //Binario de 13 bits
			String repeated = new String(new char[numZeros]).replace("\0", "0");
			bin = String.format("%s%s", repeated, bin);
			arrBin[i] = bin;
		}
		
		return arrBin;
	}
	
	/**
	 * Convierte un arreglo de Binarios a un arreglo de Hexadecimales
	 * @param array
	 * @return arregloHexa
	 */
	public static String[] convertirArrBinAHexa(String[] arrBin){
		String [] arrHexa = new String[arrBin.length];
		
		for(int i = 0; i < arrBin.length ; i++) {
			arrHexa[i] = convertirBinarioAHexa(arrBin[i]);
		}
		
		return arrBin;
	}

}
