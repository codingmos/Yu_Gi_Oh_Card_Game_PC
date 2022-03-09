package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class WrongPhaseException extends RuntimeException{
	public WrongPhaseException(){
		super();
	}
	
	public String getMessage(){
		return " Wrong phase to do this action! ";
	}

}
