package ar.com.educacionit.generic;

public abstract class BaseFile {

	protected String filepath;//alt + shif+ r cambiar el nombre 

	public BaseFile(String path) {
		if(path == null) {
			throw new IllegalArgumentException("Debe indicar un path de archivo");
		}
		this.filepath = path;
	}

	public String getFilepath() {
//		HAY LOGICA QUE DESPUES SE UTILIZA
		return filepath;
	}

	
}
