package ar.com.educacionit.collections.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class MapEntryMain {

	public static void main(String[] args) {

		Map<Integer, String> dias = new HashMap<Integer, String>();

//		AGREGAR ELEMENTOS PUT(INTEGER, STRING)

		dias.put(1, "Lunes");
		dias.put(2, "Martes");
		dias.put(3, "Miercoles");
		dias.put(4, "Jueves");
		dias.put(5, "Viernes");
		dias.put(6, "Sabado");
		dias.put(7, "Domingo");
		
		dias.keySet();//LAS CLAVES 
		dias.values();//VALUES
		
		Set<Entry<Integer, String>>entries = dias.entrySet();
//		RECORRER 
		for(Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	
		System.out.println("-----------------------------------");
		Iterator<Entry<Integer, String>> itENtries = entries.iterator();
//		RECORRO EL ITERADOR 
		while(itENtries.hasNext()) {
			Entry<Integer, String> entry = itENtries.next();//ME DEVUELVE LO HAY DENTRO DEL ITERADOR
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		
	}

}
