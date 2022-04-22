package practicaSemana3;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class NotasEscuela {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String[] apyn; 
		int notas[][];
		int tEstudiantes, tNotas;
		double suma[];
		double promedio[];
		
//		INGRESO TOTAL DE ESTUDIANTES Y CANTIDAD DE NOTAS
		tEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de estudiantes: "));
		tNotas = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de notas por estudiante: "));
		
//		INICIALIZAXION DE VARIABLES 
		apyn = new String[tEstudiantes];
		notas = new int[tEstudiantes][tNotas];
		promedio = new double [tEstudiantes];
		suma = new double[tNotas];
		
//		RELLENO DE MATRICES Y VECTORES 
		for(int i = 0; i< tEstudiantes; i++) {
			System.out.println("Digite el nombre y apellido del estudiante: ");
			apyn[i] = teclado.next();
			
			for(int j = 0; j < tNotas; j++) {
				System.out.println("Digite las notas: ");
				notas[i][j] = teclado.nextInt();
			}
		}
		
		
//		RECORRIDO DE MATRICES Y VECTORES 
		for(int i = 0; i< tEstudiantes; i++) {
			System.out.println(apyn[i]+ " ");
			for(int j = 0; j <tNotas; j++) {
				System.out.println(notas[i][j]+ " ");
			}
		}
		
//		PROMEDIO DE NOTAS POR ESTUDIANTE
		for(int i = 0; i < tEstudiantes; i++) {
			promedio[i] = 0; 
			suma[i]= 0; 
			for(int j = 0; j< tNotas; j++) {
				suma[i] += notas[i][j];
				promedio[i] = suma[i] /tNotas; 
			}
		}
	
//		IMPRIMIR NOMBRE DE ESTUDIANTE, SU PROMEDIO SI APRUEBA O NO LA MATERIA 
		for(int i = 0; i < tEstudiantes; i++) {
			if(promedio[i]>= 7) {
				System.out.println("El estudiante "+apyn[i]+" tiene un promedio de  "+promedio[i]+ " aprueba la materia.");
			}else {
				System.out.println("El estudiante "+apyn[i]+" tiene un promedio de  "+promedio[i]+ " reprueba la materia.");
			}
		}
	}

}
