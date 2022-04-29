package com.protalento.models;

public class Masajista extends SeleccionFutbol {

	private String titulacion;
	private int aniosExperiencia;

	public Masajista() {

	}

	public Masajista(int id, String nombre, String apellido, int edad, String titulacion, int aniosExperiencia) {
		super(id, nombre, apellido, edad);
		this.titulacion = titulacion;
		this.aniosExperiencia = aniosExperiencia;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}


	public void DarMasaje() {
		System.out.println("Clase masajista darMasaje()");
	}

	@Override
	public String toString() {
		return "Masajista [titulacion=" + titulacion + ", aniosExperiencia=" + aniosExperiencia + ", id=" + id
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
	}

}
