package ar.com.educacionit.crud;

import java.util.Scanner;

public class LectorPorConsola implements ILectora{

	private Scanner teclado; 
	private Integer opcion;
	public LectorPorConsola(Scanner teclado, Integer opcion) {
		this.teclado = teclado;
		this.opcion= opcion;
	}
	
	public LectorPorConsola(Scanner teclado) {
		this.teclado = teclado;
	}
	
	@Override
	public Data leerDatos() {
		return null;
	}
	
	
}
