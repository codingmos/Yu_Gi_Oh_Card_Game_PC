package eg.edu.guc.yugioh.board.player;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

public class Field {

	private Phase phase;
	private ArrayList<MonsterCard> monstersArea;
	private ArrayList<SpellCard> spellArea;
	private ArrayList<Card> hand;
	private ArrayList<Card> graveyard;
	private Deck deck;
	
	
	public Field() throws IOException, FileNotFoundException, NoMonsterSpaceException,
	NoSpellSpaceException, UnexpectedFormatException{
		this.phase = Phase.MAIN1;
		this.monstersArea = new ArrayList<MonsterCard>();
		this.spellArea = new ArrayList<SpellCard>();
		this.hand = new ArrayList<Card>();
		this.graveyard = new ArrayList<Card>();
		this.deck = new Deck();
	}
	
/*_________________________________________________________________________________________*/	

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public ArrayList<MonsterCard> getMonstersArea() {
		return monstersArea;
	}

	public ArrayList<SpellCard> getSpellArea() {
		return spellArea;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}

	public Deck getDeck() {
		return deck;
	}

/*____________________________________________________________________________________________*/
	
	public boolean addMonsterToField(MonsterCard monster, Mode m, boolean isHidden)throws NoMonsterSpaceException{
		if (monstersArea.size() < 5){
		    Location prev = monster.getLocation();
		    if(prev.equals(Location.HAND)){
		    	hand.remove(monster);}
		    else{
		    	if(prev.equals(Location.GRAVEYARD)){
		    		graveyard.remove(monster);}
		    	else{ 
		    		if(prev.equals(Location.DECK)){
		    			deck.getDeck().remove(monster);}
		    		else{
		    			monstersArea.remove(monster);}
		    		}
		    	}
			monster.setMode(m);
			monster.setHidden(isHidden);
		    monstersArea.add(monster);
		    monster.setLocation(Location.FIELD);
		    return true;
		    }
		else{
			throw new NoMonsterSpaceException();
		    }
	//return false;
		}
	
/*________________________________________________________________________________________________*/
	
	public boolean addMonsterToField(MonsterCard monster, Mode mode, ArrayList<MonsterCard> sacrifices)throws 
	NoMonsterSpaceException{
		
		if(sacrifices==null){
			if(monster.getLevel()<5){
				return addMonsterToField(monster, mode, monster.isHidden());
			}else		
		{throw new NoMonsterSpaceException();}
		}
		else{
		if(sacrifices.size()== 1){
			int y = 0;
			if(monster.getLevel()<7 && monster.getLevel()>4 ){
				MonsterCard temp = sacrifices.get(0);
				for(int i = 0; i< monstersArea.size(); i++){
					if(monstersArea.get(i).equals(temp)){
						removeMonsterToGraveyard(monstersArea.get(i));
					   y++;}
					
				}
			}
			if(y==1){
				return addMonsterToField(monster, mode, monster.isHidden());
				}
			else{
		throw new NoMonsterSpaceException();}	
		}
		else{
		if(sacrifices.size()==2){
			int x = 0;
		
			if(monster.getLevel()<=8 && monster.getLevel()>=7){
				for(int i = 0;i<sacrifices.size();i++){
					MonsterCard temp = sacrifices.get(i);
					for(int j = 0; j< monstersArea.size(); j++){
						if(monstersArea.get(j).equals(temp)){
							removeMonsterToGraveyard(monstersArea.get(j));
							x++;}
							
						
					}
				}
			} 
			if (x==2){
				 return addMonsterToField(monster, mode, monster.isHidden());
				 }else{
			throw new NoMonsterSpaceException();}	
	     }
		}
		}
	throw new NoMonsterSpaceException();
		//return false;
	}
		
	public void removeMonsterToGraveyard(MonsterCard monster){

		if(monstersArea.contains(monster)){
		if(monster.getLocation().equals(Location.FIELD)){
		monstersArea.remove(monster);
		graveyard.add(monster);
		monster.setLocation(Location.GRAVEYARD);
	}}}
	
	public void removeMonsterToGraveyard(ArrayList<MonsterCard> monsters){
		for(int i = 0; i<monsters.size(); i++){
			removeMonsterToGraveyard(monsters.get(i));
		}
	}
	public boolean addSpellToField(SpellCard action, MonsterCard monster, boolean isHidden) throws NoSpellSpaceException{
		if(spellArea.size()<5){
			action.setLocation(Location.FIELD);
			if(isHidden == true){
				spellArea.add(action);
				hand.remove(action);
				return true;
				
			}else{
				
				spellArea.add(action);
				return activateSetSpell(action, monster);
				
			}
		}else{
			throw new NoSpellSpaceException();
			
		}
		//return false;
	}
	
	public boolean activateSetSpell(SpellCard action, MonsterCard monster){
		for(int i =0; i<spellArea.size(); i++){
			if (action.equals(spellArea.get(i))){
			SpellCard c = spellArea.get(i);
			c.setHidden(false);
			c.action(monster);
			
			removeSpellToGraveyard(c);
			return true;
			}
			
			
		}
		return false;
	}
	

	public void removeSpellToGraveyard(SpellCard spell){
		if(spellArea.contains(spell)){
		if(spell.getLocation().equals(Location.FIELD)){
		spellArea.remove(spell);
		graveyard.add(spell);
		spell.setLocation(Location.GRAVEYARD);
		
	}}}
	
	public void removeSpellToGraveyard(ArrayList<SpellCard> spells){
		while(!(spells.isEmpty())){
			SpellCard x = spells.remove(0);
			removeSpellToGraveyard(x);
		}
	}
	
/*____________________________________________________________________________________________________*/
	
	public void addCardToHand(){
		Card c = deck.drawOneCard();
		hand.add(c);
		c.setLocation(Location.HAND);
	}
	
/*____________________________________________________________________________________________________*/
	
	public void addNCardsToHand(int n){
		
		hand.addAll(deck.drawNCards(n));
		}

	
/*______________________________________________________________________________________________________*/
//NoMonsterSpaceException thrown
//NoSpellSpaceException thrown

}






