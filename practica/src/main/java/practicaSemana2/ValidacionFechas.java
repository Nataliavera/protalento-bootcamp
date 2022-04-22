package practicaSemana2;

import java.util.Scanner;

public class ValidacionFechas {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int dia, mes, anio; 
		
		System.out.println("Ingrese el dia: ");
		dia = teclado.nextInt();
		
		System.out.println("Ingrese el mes: ");
		mes = teclado.nextInt();
		
		System.out.println("Ingrese el año: ");
		anio= teclado.nextInt(); 
		
		if(anio >= 1900 && anio <= 2099) {
			if(mes >=1 && mes <= 12 && mes != 2 && mes != 4 && mes != 6 && mes != 9 && mes != 11 ) {
				if(dia >=1 && dia <= 31) {
					System.out.println("La fecha que ingreso es válida");
				}else {
					System.out.println("Este mes no cuenta con más de 31 días");
				}
			}
		}else {
			System.out.println("La fecha ingresada no es válida, por favor vuelva a digitar");
		}
		
		if(anio >= 1900 && anio <= 2099) {
			if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				if(dia >=1 && dia <= 30) {
					System.out.println("La fecha que ingreso es válida");
				}else {
					System.out.println("Este mes no cuenta con más de 30 días");
				}
			}
		}else {
			System.out.println("La fecha ingresada no es válida, por favor vuelva a digitar");
		}
		
		
		if(anio >= 1900 && anio <= 2099) {
			if(mes == 2) {
				if(dia >=1 && dia <= 28) {
					System.out.println("La fecha que ingreso es válida");
				}else {
					System.out.println("Febrero no cuenta con más de 28 días");
				}
			}
		}else {
			System.out.println("La fecha ingresada no es válida, por favor vuelva a digitar");
		}
		
		
		
		teclado.close();
	}

}
