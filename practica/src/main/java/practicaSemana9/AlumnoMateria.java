package practicaSemana9;

public class AlumnoMateria {

	private Long IdAlumnoMateria;
	private Long Matricula;
	private Long IdMateria;

	public AlumnoMateria() {
	}

	public AlumnoMateria(Long idAlumnoMateria, Long matricula, Long idMateria) {
		super();
		IdAlumnoMateria = idAlumnoMateria;
		Matricula = matricula;
		IdMateria = idMateria;
	}

	public AlumnoMateria(Long matricula, Long idMateria) {
		super();
		Matricula = matricula;
		IdMateria = idMateria;
	}

	public Long getIdAlumnoMateria() {
		return IdAlumnoMateria;
	}

	public void setIdAlumnoMateria(Long idAlumnoMateria) {
		IdAlumnoMateria = idAlumnoMateria;
	}

	public Long getMatricula() {
		return Matricula;
	}

	public void setMatricula(Long matricula) {
		Matricula = matricula;
	}

	public Long getIdMateria() {
		return IdMateria;
	}

	public void setIdMateria(Long idMateria) {
		IdMateria = idMateria;
	}
}
