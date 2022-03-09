package eg.edu.guc.yugioh.exceptions;

@SuppressWarnings("serial")
public class UnknownSpellCardException extends UnexpectedFormatException {
	private String unknownSpell;
	// type found in csv entry
	
	public UnknownSpellCardException(String sourceFile, int sourceLine, String unknownSpell){
		super(sourceFile,sourceLine);
		setUnknownSpell(unknownSpell);
	}

	public String getUnknownSpell() {
		return unknownSpell;
	}

	public void setUnknownSpell(String unknownSpell) {
		this.unknownSpell = unknownSpell;
	}
	public String getMessage(){
		return " Unknown spell card! ";
	}

}
