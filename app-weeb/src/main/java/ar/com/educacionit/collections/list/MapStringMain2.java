package ar.com.educacionit.collections.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapStringMain2 {

	public static void main(String[] args) {

		Map<String, Integer> mapa = new HashMap<String, Integer>();
		
		Scanner teclado = new Scanner(System.in);
		System.out.println(mapa);
		
		String nombre = "";
		do {
			System.out.println("Ingrese nombre: ");
			nombre = teclado.next();
			
			if(mapa.containsKey(nombre)) {
				Integer value = mapa.get(nombre);
				value++;
				mapa.put(nombre, value);
			}else {
//				LO CARGARMOS
				mapa.put(nombre, 1);
			}
		}while(!nombre.equalsIgnoreCase(""));
		
		System.out.println(mapa);
		
		System.out.println("Nombre a eliminar: ");
		nombre = teclado.next();
		
		if(mapa.containsKey(nombre)) {
			mapa.remove(nombre);
		}else {
			System.out.println("no existe "+nombre+ " en el mapa");
		}
		
		System.out.println(mapa);
		teclado.close();
	}

}
