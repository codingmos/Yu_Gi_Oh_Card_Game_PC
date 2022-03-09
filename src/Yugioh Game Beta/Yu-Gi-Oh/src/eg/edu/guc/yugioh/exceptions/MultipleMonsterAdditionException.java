package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MultipleMonsterAdditionException extends RuntimeException {
	public MultipleMonsterAdditionException(){
		super();
	}
	
	public String getMessage(){
		return "You cannot summon more than once per turn";
	}

}
