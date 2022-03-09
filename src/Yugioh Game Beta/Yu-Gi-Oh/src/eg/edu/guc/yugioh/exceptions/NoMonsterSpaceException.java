package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoMonsterSpaceException extends NoSpaceException{
	public NoMonsterSpaceException(){
		super();
	}
	public String getMessage(){
		return "Monsters area is full!";
	}

}
