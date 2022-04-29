package com.protalento.models;

public class Entrenador extends SeleccionFutbol {

	private String idFederacion;

	public Entrenador() {

	}

	public Entrenador(String idFederacion) {
		super();
		this.idFederacion = idFederacion;
	}

	public Entrenador(int id, String nombre, String apellido, int edad, String idFederacion) {
		super(id, nombre, apellido, edad);
		this.idFederacion = idFederacion;
	}
	

	public String getIdFederacion() {
		return idFederacion;
	}

	public void setIdFederacion(String idFederacion) {
		this.idFederacion = idFederacion;
	}

	public void DirigirPartido() {
		System.out.println("Clase futbolista dirigirPartido()");
	}

	public void DirigirEntrenamiento() {
		System.out.println("Clase futbolista dirigirEntrenamiento()");
	}

	@Override
	public String toString() {
		return "Entrenador [idFederacion=" + idFederacion + ", id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", edad=" + edad + "]";
	}

}
