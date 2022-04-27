package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainCollection2 {

	public static void main(String[] args) {

//		CREAR
//		Collection<String> nombres = new ArrayList<String>();
		List<String> nombres = new ArrayList<String>();
		
//		AGREGAR VALORES 
		nombres.add(new String("Juan"));
		nombres.add(new String("Juan"));
		nombres.add(new String("Camilo"));
		nombres.add(new String("Carlos"));
		
		/*System.out.println(nombres);
		
		nombres = new HashSet<String>(nombres);
		System.out.println(nombres);*/
		
//		nombres = new LinkedList<String>();
		
		List<String> apellidos = new ArrayList<String>();
		apellidos.add("Perez");
		apellidos.add("Lopez");
		apellidos.add("Juarez");
		
		
//		LISTA DE LISTAS
		List<List<String>> nombresList = new ArrayList<List<String>>();
		nombresList.add(nombres);
		nombresList.add(apellidos);
		
//		RECORRER
		System.out.println(nombresList);
		for(List<String> nl : nombresList) {
			for(String aux : nl) {
				System.out.println(aux);
			}
		}
		
		
	}

}
