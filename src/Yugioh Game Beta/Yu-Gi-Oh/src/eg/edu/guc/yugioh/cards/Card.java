package eg.edu.guc.yugioh.cards;



import eg.edu.guc.yugioh.board.Board;


public abstract class Card {
private String name;
private String description;
private boolean isHidden;
private Location location;
private static Board board;


public Card(String name, String description) {
	this.name = name;
	this.description = description;
	this.location = Location.DECK;
	this.isHidden = true;
	
}
public Card(){
	
}
public abstract void action(MonsterCard monster);



public boolean isHidden() {
	return isHidden;
}
public void setHidden(boolean isHidden) {
	this.isHidden = isHidden;
}
public Location getLocation() {
	return location;
}
public void setLocation(Location location) {
	this.location = location;
}
public static Board getBoard() {
	return board;
}
public static void setBoard(Board board1) {
	board = board1;
}
public String getName() {
	return name;
}
public String getDescription() {
	return description;
}


}

