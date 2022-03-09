package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class MissingFieldException extends UnexpectedFormatException {

	public MissingFieldException(String sourceFile, int sourceLine){
		super(sourceFile, sourceLine);
	}
	
	public String getMessage(){
		return "Some fields are missing in your csv file";
	}

}
