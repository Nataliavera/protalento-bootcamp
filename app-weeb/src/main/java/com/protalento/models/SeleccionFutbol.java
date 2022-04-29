package com.protalento.models;

public class SeleccionFutbol {
	/*
	 * SI VOY A INSTANCIAR OBJETOS -> CLASE ABSTRACTA UNA CLASE ABSTRACTA NO TIENE
	 * LA NECESIDAD DE IMPLEMENTAR LOS METODOS HEREDADOS DE OTRA CLASE O INTERFAZ
	 * 
	 * alt +shift + a alt + shift + r ctrl + f
	 */

	protected int id;
	protected String nombre;
	protected String apellido;
	protected int edad;

	public SeleccionFutbol() {
		super();
	}

	public SeleccionFutbol(int id, String nombre, String apellido, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void Concentrase() {
		System.out.println("Clase seleccionFutbol concentrarse()");
	}

	public void Viajar() {
		System.out.println("Clase seleccionFutbol viajar()");
	}
}
