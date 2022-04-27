package ar.com.educacionit.collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class MainCollection3 {

	public static void main(String[] args) {

//		CREAR
		LinkedList<String> nombres = new LinkedList<String>();
		
//		AGREGAR
		nombres.add(new String("Juan"));
		nombres.add(new String("Camilo"));
		nombres.add(new String("Carlos"));
		
		ListIterator<String> li = nombres.listIterator();
		
		/*if(li.hasNext()) {
			li.next();
			while(li.hasNext()) {
				String elemento = li.next();
				System.out.println(elemento);
				if(li.hasPrevious()) {
					String previo = li.previous();
					System.out.println(previo);
					System.out.println("Tiene un elemento previo");
				}
			}
		}*/
		
		while(li.hasNext()) {
			String current = li.next();
			System.out.println(current);
		}
		
		while(li.hasPrevious()){
			String current = li.previous();
			System.out.println(current);
		}
	}

}
