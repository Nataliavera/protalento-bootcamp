package practicaSemana11;

public class Main {

	public static void main(String[] args) {

		IIdioma idiomaNativo = new Espanol();
		
		Persona p1 = new Persona(idiomaNativo, "Natalia", "Vera");
		
		IIdioma aleman = new Aleman();
		
		p1.Aprender(aleman);
		aleman.hablar();
	}

}
