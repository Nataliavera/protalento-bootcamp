package ar.com.educacionit.crud;

public class Alta implements Ejecutable{

	@Override
	public void ejecutar() {
		System.out.println("Ejecutando alta");
	}
	
	public void crear() {
		System.out.println("Creando el metodo ");
	}

	@Override
	public void ejecutar(Data data) {
		
	}

}
