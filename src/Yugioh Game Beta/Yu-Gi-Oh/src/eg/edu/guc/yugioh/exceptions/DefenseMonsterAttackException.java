package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class DefenseMonsterAttackException extends RuntimeException{
	public DefenseMonsterAttackException(){
		super();
	} 
	public String getMessage(){
		return "You cannot attack with the monster in defense mode!";
	}

}
