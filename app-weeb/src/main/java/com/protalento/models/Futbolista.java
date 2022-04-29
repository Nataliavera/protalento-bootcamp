package com.protalento.models;

public class Futbolista extends SeleccionFutbol {

	private String dorsal;
	private String demarcacion;

	public Futbolista() {

	}

	public Futbolista(int id, String nombre, String apellido, int edad, String dorsal, String demarcacion) {
		super(id, nombre, apellido, edad);
		this.dorsal = dorsal;
		this.demarcacion = demarcacion;
	}

	public String getDorsal() {
		return dorsal;
	}

	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	public String getDemarcacion() {
		return demarcacion;
	}

	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}

	public void JugarPartido() {
		System.out.println("Clase futbolista jugarPartido()");
	}

	public void Entrenar() {
		System.out.println("Clase futbolista Entrenar()");
	}

	@Override
	public String toString() {
		return "Futbolista [dorsal=" + dorsal + ", demarcacion=" + demarcacion + ", id=" + id + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", edad=" + edad + "]";
	}
	
	
}
