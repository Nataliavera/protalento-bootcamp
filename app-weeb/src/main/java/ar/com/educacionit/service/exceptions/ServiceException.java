package ar.com.educacionit.service.exceptions;

public class ServiceException extends Exception {
	/*
	 * GENERICEXCEPTION 
	 * DUPLICATEDEXCEPTION
	 * */

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	} 

//	OTRO CONSTRUCTOR QUE RECIBA LA GENERIC EXCEPTION
}
