package practicaSemana4;

public class Ovni extends Voladores implements Aterrizable{

	private String forma;
	
	public Ovni(String nombre, String marca, String modelo, int velocidadMax, int velocidadMin) {
		super(nombre, marca, modelo, velocidadMax, velocidadMin);
	}

	@Override
	public void aterrizable() {
		System.out.println("No puede aterrizar");
	}

	public Ovni(String nombre, String marca, String modelo, int velocidadMax, int velocidadMin, String forma) {
		super(nombre, marca, modelo, velocidadMax, velocidadMin);
		this.forma = forma;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	@Override
	public String toString() {
		return "Ovni [forma=" + forma + ", getForma()=" + getForma() + ", getNombre()=" + getNombre() + ", getMarca()="
				+ getMarca() + ", getModelo()=" + getModelo() + ", getVelocidadMax()=" + getVelocidadMax()
				+ ", getVelocidadMin()=" + getVelocidadMin() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
