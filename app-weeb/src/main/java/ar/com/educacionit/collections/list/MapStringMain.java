package ar.com.educacionit.collections.list;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStringMain {

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
		
//		OBTENGO UN ELEMENTO 
//		SI NO EXISTE EL ELEMENTO DEVUELVE NULL
		String diaStr = dias.get(1);
		
		System.out.println(1 + "-"+ diaStr);
		
//		KEYSERT DEL MAPA 
		Set<Integer> keySet = dias.keySet();
		
//		RECORRO EL SET 
		for(Integer key: keySet) {
//			AHORA PUEDO TOMAR DEL MAPA 
			String value =dias.get(key);
			System.out.println(key+ "-"+value);
		}
		
//		RECORRER SOLO LOS VALORES 
		Collection <String> values = dias.values();
		
//		RECORRO LA COLECCION
		for(String valuee : values) {
			System.out.println(valuee+ "-"+dias.containsValue(valuee));
		}
		
		System.out.println("--------------------------------------------------------");
//		ENTRYSET DA EL KEY Y EL VALUE -> MANERA DE AHORRAR CODIGO 
//		MAP ES LA INTERFAZ, DENTRO DE MAP TENGO LA INTERFAZ LLAMADA ENTRY 
		Set<Map.Entry<Integer, String>>entrySet = dias.entrySet();//DEVUELVE UN SET 
		
		for(Map.Entry<Integer, String> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		
		
	}

}
