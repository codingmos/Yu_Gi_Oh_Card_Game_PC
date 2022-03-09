package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MonsterMultipleAttackException extends RuntimeException{
	public MonsterMultipleAttackException(){
		super();
	}
	public String getMessage(){
		return "You already attacked with this monster this turn! ";
	}
}
