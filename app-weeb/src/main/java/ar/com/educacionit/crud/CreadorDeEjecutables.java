package ar.com.educacionit.crud;

import java.util.HashMap;
import java.util.Map;

public class CreadorDeEjecutables {

//	ATRIBUTOS
	private static Map<Integer, Ejecutable> opcionesMap = crearOpciones();
	
//	CONSTRUCTORES
	private static Map<Integer, Ejecutable> crearOpciones(){
//		CREO EL MAPA QUE ASOCIA OPCIONE > ACCION
		Map<Integer, Ejecutable> opciones = new HashMap<>();
		
//		CARGO EL MAPA CON LAS OPCIONES
		opciones.put(1, new Alta());
		opciones.put(2, new Baja());
		opciones.put(3, new Modificar());
		opciones.put(4, new Eliminar());
		
		return opciones; 
	}
	
//	METODOS
	public static Ejecutable obtenerEjecutable(Integer opcionBuscada) {
//		EL METODO FUNCIONA SIEMPRE Y CUANDO LA OPCION BUSCADA EXISTA 
		
		if(opcionesMap.containsKey(opcionBuscada)) {
			return opcionesMap.get(opcionBuscada);
		}
		throw new RuntimeException("No existe Ejecutable asociado a la clave: "+opcionBuscada);
	}
}
