package ar.com.educacionit.enums;

import java.util.Scanner;


public class MainLogger {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese logger(1 -> fs, 2 -> console ): ");
		
		LoggersEnum opcionesEnum = LoggersEnum.getEnumFromStr(teclado.next());
		
		ILogger logger = LoggerFactory.getLoggerFromEnum(opcionesEnum);
		logger.loguear();
	}

	
}
