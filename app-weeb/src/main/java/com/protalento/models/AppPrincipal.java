package com.protalento.models;

import java.util.ArrayList;

public class AppPrincipal {
	
//	ARRAYLIST DE OBJETOS SELECCIONFUTBOL. INPENEDIENTEMENTE DE LA CLASE HIJA A LA QUE PERTEZCA EL OBJETO
	public static ArrayList<SeleccionFutbol> integrantes = new ArrayList<>();
	
	public static void main(String[] args) {

		Entrenador entrenador = new Entrenador(1, "Vicente", "Del Bosque", 40, "asd");
		Futbolista f1 = new Futbolista(2, "Andres", "Hiniesta", 29, "9","Interior Izquierdo");
		Masajista masajista = new Masajista(3, "Miguel", "Fernandez", 36, "Fisioterapeuta" , 8);
		
		integrantes.add(entrenador);
		integrantes.add(masajista);
		integrantes.add(f1);
		
//		CONCENTRACION
		System.out.println("Todos los integrantes tienen una concentracion");
		for(SeleccionFutbol integrante : integrantes) {
			System.out.println(integrante.toString()+ "->");
			integrante.Concentrase();
		}
//		VIAJE
		System.out.println("Todos los integrantes tienen una concentracion");
		for(SeleccionFutbol integrante : integrantes) {
			System.out.println(integrante.toString() + "->");
			integrante.Viajar();
		}
	}

}
