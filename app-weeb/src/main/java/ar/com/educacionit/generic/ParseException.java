package ar.com.educacionit.generic;

public class ParseException extends Exception {

//	ASI OBTENGO MI EXCEPCION PROPIA 
	public ParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParseException(String message) {
		super(message);
	}

	
}
