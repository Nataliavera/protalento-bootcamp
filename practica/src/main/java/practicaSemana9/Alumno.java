package practicaSemana9;

public class Alumno {

	private Long matricula;
	private String nombre;
	private String apellido;

	public Alumno() {
	}

	public Alumno(Long matricula, String nombre, String apellido) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Alumno(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Alumno(Long matricula) {
		super();
		this.matricula = matricula;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", getMatricula()="
				+ getMatricula() + ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido() + "]";
	}

}
