package practicaSemana4;

public class Main {

	public static void main(String[] args) {
		
		Superman sp = new Superman(null, null, null, 0, 0);
		Avion av = new Avion(null, null, null, 0, 0);
		Ovni ov = new Ovni(null, null, null, 0, 0);
		Helipcotero he = new Helipcotero(null, null, null, 0, 0);
		
		sp.aterrizable();
		av.aterrizable();
		ov.aterrizable();
		he.aterrizable();
	}

}
