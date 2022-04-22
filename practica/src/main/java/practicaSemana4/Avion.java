package practicaSemana4;

public class Avion extends Voladores implements Aterrizable {

	private int capacidad;
	private int cantidadMotores;

	public Avion(String nombre, String marca, String modelo, int velocidadMax, int velocidadMin) {
		super(nombre, marca, modelo, velocidadMax, velocidadMin);
	}

	@Override
	public void aterrizable() {
		System.out.println("Puede aterrizar");
	}

	public Avion(String nombre, String marca, String modelo, int velocidadMax, int velocidadMin, int capacidad,
			int cantidadMotores) {
		super(nombre, marca, modelo, velocidadMax, velocidadMin);
		this.capacidad = capacidad;
		this.cantidadMotores = cantidadMotores;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCantidadMotores() {
		return cantidadMotores;
	}

	public void setCantidadMotores(int cantidadMotores) {
		this.cantidadMotores = cantidadMotores;
	}

	@Override
	public String toString() {
		return "Avion [capacidad=" + capacidad + ", cantidadMotores=" + cantidadMotores + ", getCapacidad()="
				+ getCapacidad() + ", getCantidadMotores()=" + getCantidadMotores() + ", getNombre()=" + getNombre()
				+ ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getVelocidadMax()="
				+ getVelocidadMax() + ", getVelocidadMin()=" + getVelocidadMin() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
