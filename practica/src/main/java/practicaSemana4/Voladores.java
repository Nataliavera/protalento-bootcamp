package practicaSemana4;

public class Voladores {

	private String nombre; 
	private String marca;
	private String modelo;
	private int velocidadMax;
	private int velocidadMin;
	
//	CONSTRUCTOR 
	public Voladores(String nombre, String marca, String modelo, int velocidadMax, int velocidadMin) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadMax = velocidadMax;
		this.velocidadMin = velocidadMin;
	}

	
//	GETTERS AND SETTERS 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVelocidadMax() {
		return velocidadMax;
	}

	public void setVelocidadMax(int velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	public int getVelocidadMin() {
		return velocidadMin;
	}

	public void setVelocidadMin(int velocidadMin) {
		this.velocidadMin = velocidadMin;
	}


	@Override
	public String toString() {
		return "Voladores [nombre=" + nombre + ", marca=" + marca + ", modelo=" + modelo + ", velocidadMax="
				+ velocidadMax + ", velocidadMin=" + velocidadMin + "]";
	}
}
