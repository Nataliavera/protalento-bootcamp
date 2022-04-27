package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MainCollection {

	public static void main(String[] args) {

//		CREAR
		Collection<String> nombres = new ArrayList<String>();
		
//		AGREGAR VALORES 
		nombres.add("Juan");
		nombres.add("Camilo");
		nombres.add("Carlos");
		
//		OBTENER 
		Iterator<String> itnombres= nombres.iterator();
		while(itnombres.hasNext()) {
			String dato = itnombres.next();
			System.out.println("Dato: "+dato);
		}
		
//		ELIMINAR
		/*for(String nombre : nombres) {
			nombres.remove(nombre);
			DA ERROR
		}*/
		
//		BUSCAR SIN ALTERAR EL TAMAÑO DE LA COLLECTION
		for(String nombre : nombres) {
			if(nombre.equalsIgnoreCase("Juan")) {
				nombre = new String("Jose");
			}
		}
		System.out.println(nombres);
		
		
//		ELIMINAR CON ITERATOR 
		itnombres= nombres.iterator();
		while(itnombres.hasNext()) {
			itnombres.next();
			itnombres.remove();
		}
		
		
		
		
	}

}
