package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class NoSpellSpaceException extends NoSpaceException {
	public NoSpellSpaceException(){
		super();
	}
	public String getMessage(){
		return "Spells area is full!";
	}
	

}
