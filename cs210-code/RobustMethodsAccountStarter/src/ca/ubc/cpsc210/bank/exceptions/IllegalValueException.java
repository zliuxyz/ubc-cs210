package ca.ubc.cpsc210.bank.exceptions;

/*
 * Represents when an illegal value is passed to an operation.
 * 
 * @author tsiknis
 */
@SuppressWarnings("serial")
public class IllegalValueException extends AccountException {
	
	public IllegalValueException() {}
	
	public IllegalValueException( String msg ) {
		super(msg);
	}
}
