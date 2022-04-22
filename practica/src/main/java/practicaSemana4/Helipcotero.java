package practicaSemana4;

public class Helipcotero extends Voladores implements Aterrizable{

	private String color;
	
	public Helipcotero(String nombre, String marca, String modelo, int velocidadMax, int velocidadMin) {
		super(nombre, marca, modelo, velocidadMax, velocidadMin);
	}

	@Override
	public void aterrizable() {
		System.out.println("Puede aterrizar");
	}

	public Helipcotero(String nombre, String marca, String modelo, int velocidadMax, int velocidadMin, String color) {
		super(nombre, marca, modelo, velocidadMax, velocidadMin);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Helipcotero [color=" + color + ", getColor()=" + getColor() + ", getNombre()=" + getNombre()
				+ ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getVelocidadMax()="
				+ getVelocidadMax() + ", getVelocidadMin()=" + getVelocidadMin() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
