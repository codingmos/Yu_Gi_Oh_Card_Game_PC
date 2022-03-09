package eg.edu.guc.yugioh.exceptions;


@SuppressWarnings("serial")
public class UnknownCardTypeException extends UnexpectedFormatException {
	private String unknownType;
	// type found in csv entry
	
	public UnknownCardTypeException(String sourceFile, int sourceLine, String unknownType){
		super(sourceFile,sourceLine);
		setUnknownType(unknownType);
	}

	public String getUnknownType() {
		return unknownType;
	}

	public void setUnknownType(String unknownType) {
		this.unknownType = unknownType;
	}
	public  String getMessage(){
		return " Unknown card type! ";
	}

}
