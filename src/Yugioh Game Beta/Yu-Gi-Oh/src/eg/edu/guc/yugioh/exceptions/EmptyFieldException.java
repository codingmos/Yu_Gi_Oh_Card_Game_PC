package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class EmptyFieldException extends UnexpectedFormatException{
	private int sourceField;
	//index of the first field is 1 not 0
	
	public EmptyFieldException(String sourceFile, int sourceLine, int sourceField){
		super(sourceFile,sourceLine);
		setSourceField(sourceField);
	}

	public int getSourceField() {
		return sourceField;
	}

	public void setSourceField(int sourceField) {
		this.sourceField = sourceField;
	}

	public String getMessage(){
		return "Some fields are empty in your csv file!";
	}
}
