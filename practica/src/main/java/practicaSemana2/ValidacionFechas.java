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
		
		System.out.println("Ingrese el a�o: ");
		anio= teclado.nextInt(); 
		
		if(anio >= 1900 && anio <= 2099) {
			if(mes >=1 && mes <= 12 && mes != 2 && mes != 4 && mes != 6 && mes != 9 && mes != 11 ) {
				if(dia >=1 && dia <= 31) {
					System.out.println("La fecha que ingreso es v�lida");
				}else {
					System.out.println("Este mes no cuenta con m�s de 31 d�as");
				}
			}
		}else {
			System.out.println("La fecha ingresada no es v�lida, por favor vuelva a digitar");
		}
		
		if(anio >= 1900 && anio <= 2099) {
			if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				if(dia >=1 && dia <= 30) {
					System.out.println("La fecha que ingreso es v�lida");
				}else {
					System.out.println("Este mes no cuenta con m�s de 30 d�as");
				}
			}
		}else {
			System.out.println("La fecha ingresada no es v�lida, por favor vuelva a digitar");
		}
		
		
		if(anio >= 1900 && anio <= 2099) {
			if(mes == 2) {
				if(dia >=1 && dia <= 28) {
					System.out.println("La fecha que ingreso es v�lida");
				}else {
					System.out.println("Febrero no cuenta con m�s de 28 d�as");
				}
			}
		}else {
			System.out.println("La fecha ingresada no es v�lida, por favor vuelva a digitar");
		}
		
		
		
		teclado.close();
	}

}
