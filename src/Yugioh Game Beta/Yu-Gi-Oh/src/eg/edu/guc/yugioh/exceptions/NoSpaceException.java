package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoSpaceException extends RuntimeException {
	public NoSpaceException(){
		super();
	}
	
	public String getMessage(){
		return "Field is full!";
	}

}
