package lcdPrinter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    static Scanner lector = new Scanner(System.in);
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        String comando;
       //define el espacio entre los disgitos que se van a imprimir
        Integer espacioDig;
        
		try {
			System.out.print("Espacio entre Digitos (0 a 5): ");
			// si no es entero dispara excepción
			comando = lector.next();
			if (Character.isDigit(comando.toCharArray()[0])) {

				espacioDig = Integer.parseInt(comando);

				// se valida que el espaciado este entre 0 y 5
				if (espacioDig < 0 || espacioDig > 5)
					throw new IllegalArgumentException("El espacio entre " + "digitos debe estar entre 0 y 5");
				do {
					System.out.print("Entrada: ");
					comando = lector.next();
					if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
						listaComando.add(comando);
					}
				} while (!comando.equalsIgnoreCase(CADENA_FINAL));

				ImpresorLCD impresorLCD = new ImpresorLCD();

				Iterator<String> iterator = listaComando.iterator();
				while (iterator.hasNext()) {
					impresorLCD.procesar(iterator.next(), espacioDig);
				}
			}else{
				throw new IllegalArgumentException("La cadena" +comando+ "no es un entero");
			}
		} catch (Exception ex) 
        {
        	System.out.println("Error: "+ex.getMessage());
        }

    }

}