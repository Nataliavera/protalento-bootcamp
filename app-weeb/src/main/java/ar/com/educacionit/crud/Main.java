package ar.com.educacionit.crud;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int continuar;

		do {
			int opcion;
			do {
//		MUESTRO MENU 
//		COMO ES UN METODO STATIC NO NECESITA LA INSTACIA -> Menu menu = new Menu()
				Menu.mostrar();
				opcion = teclado.nextInt();
			} while (opcion < 0 || opcion > 4);

			try {
				Ejecutable ej = CreadorDeEjecutables.obtenerEjecutable(opcion);
//		 EJECUTO LA ACCION SIN SABER CUAL ES, PERO COMO SE QUE
//		IMPLEMENTA LA INTERFACE EJECUTABLE ENTONCES TENGO DISPONIBLE EL METODO EJECUTAR
				
//				1 > id, titulo 
//				2 > id 
//				3 > titulo 
//				4 > id
				ILectora lector = new LectorPorConsola(teclado, opcion);
				Data data1 = lector.leerDatos();
				
				
				Long id; 
				String titulo;
//				Data data1 = new Data();
				if(opcion == 1) {
					id = teclado.nextLong();
					titulo = teclado.next();
					data1.setId(id);
					data1.setTitulo(titulo);
				}else if(opcion == 2) {
					id = teclado.nextLong();
					data1.setId(id);
				}else if(opcion == 3) {
					titulo = teclado.next();
					data1.setTitulo(titulo);
				}else {
					 id = teclado.nextLong();
					 data1.setId(id);
				}
				ej.ejecutar(data1);
				if (ej instanceof Alta) {
//					SOLO SI ES ALTA CREAR() DOWN CASTING
					Alta alta = (Alta) ej;
					alta.crear();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
//			finally {
//			CERRAR EL TECLADO CUANDO SE EJECUTE UNA OPCION DIFERENTE SIN QUE EL PROGRAMA EXPLOTE
//				teclado.close();
//			}
			Menu.mostrarContinuar();
			continuar = teclado.nextInt();
		} while (continuar == 1);

		teclado.close();
		System.out.println("FIN");

	}

}
