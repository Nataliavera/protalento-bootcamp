package practicaSemana4;

public class Superman extends Voladores implements Aterrizable{

	private int edad;
	
	public Superman(String nombre, String marca, String modelo, int velocidadMax, int velocidadMin) {
		super(nombre, marca, modelo, velocidadMax, velocidadMin);
	}

	@Override
	public void aterrizable() {
		System.out.println("No puede aterrizar");
	}
	
	public Superman(String nombre, String marca, String modelo, int velocidadMax, int velocidadMin, int edad) {
		super(nombre, marca, modelo, velocidadMax, velocidadMin);
		this.edad = edad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Superman [edad=" + edad + ", getEdad()=" + getEdad() + ", getNombre()=" + getNombre() + ", getMarca()="
				+ getMarca() + ", getModelo()=" + getModelo() + ", getVelocidadMax()=" + getVelocidadMax()
				+ ", getVelocidadMin()=" + getVelocidadMin() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
