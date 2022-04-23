package practicaSemana9;

import java.sql.Statement;
import java.util.Scanner;

import javax.sound.midi.MidiChannel;

public class Aplicacion {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Menu menu = new Menu();
		int opcion;
		boolean programaActivado = true;
		String nombre, apellido, curso, turno;
		Long matricula, idMateria;
		

		do {
			System.out.println("\nDigite la acción que desea realizar");
			System.out.println("1. Inscripción");
			System.out.println("2. Eliminar");
			System.out.println("3. Modificar/Actualizar");
			System.out.println("4. Buscar");
			System.out.println("5. Salir");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Ingrese el nombre del alumno: ");
				nombre = teclado.next();
				System.out.println("Ingrese el apellido del alumno: ");
				apellido = teclado.next();
				
				Alumno a1 = new Alumno(nombre, apellido);
				menu.inscripcion(a1);
				
				System.out.println("Ingrese el Id del alumno: ");
				matricula = teclado.nextLong();
				System.out.println("Ingrese el Id de la materia para matricularse: ");
				System.out.println("1. Programacion Mañana");
				System.out.println("2. Programacion Tarde");
				System.out.println("3. Programacion Noche");
				System.out.println("4. Habilidades blandas Mañana");
				System.out.println("5. Habilidades blandas Tarde");
				System.out.println("6. Habilidades blandas Noche");
				System.out.println("7. Ingles Mañana");
				System.out.println("8. Ingles Tarde");
				System.out.println("9. Ingles Noche");
				idMateria = teclado.nextLong();
				
				AlumnoMateria am = new AlumnoMateria(matricula, idMateria);
				menu.insertarAlumnoMateria(am);
				break;
			case 2:
				System.out.println("Ingrese la matricula del alumno que desea borrar: ");
				int m = teclado.nextInt();
				
				menu.eliminar(m);
				break;
			case 3:
				System.out.print("Ingrese el Id del alumno: ");
				matricula = teclado.nextLong();
				System.out.print("Ingrese el nuevo nombre del alumno: ");
				nombre = teclado.next();
				System.out.print("Ingrese el nuevo apellido del alumno: ");
				apellido = teclado.next();
				
				menu.actualizar(nombre, apellido, matricula);
				break;
			case 4:
				System.out.print("Ingrese la Matricula del alumno que desea consultar: ");
				int matricul = teclado.nextInt();
				
				menu.buscarIncripcion(matricul);
				break;
			case 5:
				System.out.println("El programa ha finalizado.");
				programaActivado = false;
				break;
			default:
				System.out.println("Opción invalida. Por favor ingrese una de las opciones que se le muestran en el menú");
				break;
			}
		} while (programaActivado);
		
		
		
		
		
	}
}
