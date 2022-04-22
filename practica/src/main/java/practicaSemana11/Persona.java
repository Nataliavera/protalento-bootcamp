package practicaSemana11;

import java.util.HashSet;
import java.util.Set;

public class Persona {

	private IIdioma idiomaNativo;
	private Set<IIdioma> otrosIdiomas;
	private String nombre;
	private String apellido;

	public Persona(IIdioma idiomaNativo, String nombre, String apellido) {
		super();
		this.idiomaNativo = idiomaNativo;
		this.nombre = nombre;
		this.apellido = apellido;
		
		this.otrosIdiomas = new HashSet<>();
	}

	public Persona(IIdioma idiomaNativo, Set<IIdioma> otrosIdiomas, String nombre, String apellido) {
		super();
		this.idiomaNativo = idiomaNativo;
		this.otrosIdiomas = otrosIdiomas;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public void Aprender(IIdioma nuevoIdioma) {
//		throw InvalidIdiomaException
		if (nuevoIdioma == null) {
			throw new RuntimeException("Idioma invalido o nulo");
		}

		if (otrosIdiomas.contains(nuevoIdioma)) {
			throw new RuntimeException("Idioma ya aprendido");
		}
		this.aprenderIdioma(nuevoIdioma);
	}
	
	private void aprenderIdioma(IIdioma nuevoIdioma) {
		this.otrosIdiomas.add(nuevoIdioma);
	}
}
