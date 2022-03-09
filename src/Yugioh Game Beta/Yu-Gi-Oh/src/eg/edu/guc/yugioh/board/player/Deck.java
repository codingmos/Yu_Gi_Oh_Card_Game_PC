package eg.edu.guc.yugioh.board.player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

/*__________________________________________________________________________________________*/

public class Deck{

	private static ArrayList<Card> monsters;
	private static ArrayList<Card> spells;
	private   ArrayList<Card> deck;
	
	private static String monstersPath = "Database-Monsters.csv"; 
	private static String spellsPath = "Database-Spells.csv"; 
	private Scanner input;
	//private boolean passed;
	
	
    
public Deck() throws IOException, FileNotFoundException, UnexpectedFormatException{
    Deck.monsters = new ArrayList<Card>();
    Deck.spells = new ArrayList<Card>();
    this.deck = new ArrayList<Card>();
    
    
    //passed=false;
    
    input = new Scanner(System.in); //default file has problems
    
    
     ExceptionDetector(Deck.getMonstersPath(), 0, false);//tries and catches
     ExceptionDetector2(Deck.getSpellsPath(), 0, false);
	 buildDeck(monsters,spells);
	 shuffleDeck();
	 
}




//#1st checks for exceptions and handles them
public void ExceptionDetector(String Path, int count, boolean thrown) throws IOException, 
FileNotFoundException, UnexpectedFormatException{
	
	
	if(thrown == true){
		return;
		}else{
		try{
			System.out.println("Please enter a correct path : " + Path );
			
			monsters = loadCardsFromFile(Path);
			
			 return;
			 
			 
			}
		catch(FileNotFoundException F){
			System.out.println(F.getMessage());
			count++;
			if(count >3){
				thrown = true;
				F.printStackTrace();
				throw F;
			}
			else{
				
					ExceptionDetector(input.nextLine(), count, thrown);
					
				}
			
		}
		
		catch(MissingFieldException M){
			System.out.println(M.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//M.printStackTrace();
				throw M;
			}
			else{
				
					ExceptionDetector(input.nextLine(), count, thrown);
				}
			}
		catch(EmptyFieldException E){
			System.out.println(E.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//E.printStackTrace();
				throw E;
			}
			else{
				
					ExceptionDetector( input.nextLine(), count, thrown);
				}
			}
		catch(UnknownCardTypeException UC){
			System.out.println(UC.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//UC.printStackTrace();
				throw UC;
			}
			else{
				
					ExceptionDetector(input.nextLine(), count, thrown);
				}
			}
		catch(UnknownSpellCardException US){
			System.out.println(US.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//US.printStackTrace();
				throw US;
			}
			else{
				
					ExceptionDetector(input.nextLine(), count, thrown);
				}
			}
		catch(UnexpectedFormatException UFE){
			System.out.println(UFE.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//UFE.printStackTrace();
				throw UFE;
			}
			else{
				
					ExceptionDetector(input.nextLine(), count, thrown);
				}
			}
		}
	
		thrown = true;
		return;
		//finally{count++;}
		} 
	
public void ExceptionDetector2(String Path,int count, boolean thrown) throws IOException, 
FileNotFoundException, UnexpectedFormatException{
	
	
	if(thrown == true){
		return;
		}else{
		try{
			System.out.println("Please enter a correct path : " + Path );
			
		
			spells = loadCardsFromFile(Path);
		    return;
			 
			 
			}
		catch(FileNotFoundException F){
			System.out.println(F.getMessage());
			count++;
			if(count >3){
				thrown = true;
				F.printStackTrace();
				throw F;
			}
			else{
				
					ExceptionDetector2(input.nextLine(), count, thrown);
					
				}
			
		}
		
		catch(MissingFieldException M){
			System.out.println(M.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//M.printStackTrace();
				throw M;
			}
			else{
				
					ExceptionDetector2(input.nextLine(), count, thrown);
				}
			}
		catch(EmptyFieldException E){
			System.out.println(E.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//E.printStackTrace();
				throw E;
			}
			else{
				
					ExceptionDetector2(input.nextLine(), count, thrown);
				}
			}
		catch(UnknownCardTypeException UC){
			System.out.println(UC.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//UC.printStackTrace();
				throw UC;
			}
			else{
					ExceptionDetector2(input.nextLine(), count, thrown);
				}
			}
		catch(UnknownSpellCardException US){
			System.out.println(US.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//US.printStackTrace();
				throw US;
			}
			else{
			
					ExceptionDetector2(input.nextLine(), count, thrown);
				}
			}
		catch(UnexpectedFormatException UFE){
			System.out.println(UFE.getMessage());
			count++;
			if(count > 3){
				thrown = true;
				//UFE.printStackTrace();
				throw UFE;
			}
			else{
				ExceptionDetector2(input.nextLine(), count, thrown);
				}
			}
		}
	
	    thrown=true;
		return;
		//finally{count++;}
		} 
	





	 
/*___________________________________________________________________________________________*/


public static ArrayList<Card> getMonsters() {
	return monsters;
}

public  static ArrayList<Card> getSpells() {
	return spells;
}

public ArrayList<Card> getDeck() {
	return deck;
}
public static String getMonstersPath() {
	return monstersPath;
}

public static void setMonstersPath(String MonstersPath) {
	monstersPath = MonstersPath;
}

public static String getSpellsPath() {
	return spellsPath;
}

public static void setSpellsPath(String SpellsPath) {
	spellsPath = SpellsPath;
}


/*____________________________________________________________________________________________*/

//#2nd malformed data
@SuppressWarnings("resource")
public ArrayList<Card> loadCardsFromFile (String Path) throws IOException,FileNotFoundException, 
UnexpectedFormatException {
	
	ArrayList<Card> card = new ArrayList<Card>();
	int LineNumber =1;
	
	String currentline ="";
    FileReader filereader = new FileReader(Path); 
	BufferedReader bufferreader = new BufferedReader(filereader);
	
	
	while((currentline = bufferreader.readLine()) != null){
		String[]cardInfo;
		cardInfo = currentline.split(",");
		if((cardInfo[0] !=null) && !(cardInfo[0].equals("Monster")) && !(cardInfo[0].equals("Spell"))){
		throw new UnknownCardTypeException(Path, LineNumber, cardInfo[0]);}
		if(cardInfo.length != 3 && cardInfo.length != 6){
				throw new MissingFieldException(Path, LineNumber);
				}
		//starts
		if(cardInfo[0] == null ){
			throw new EmptyFieldException(Path, LineNumber, 1);
		}
		if(cardInfo[1] == null){
			throw new EmptyFieldException(Path, LineNumber, 2);
		}
		if(cardInfo[2] == null){
			throw new EmptyFieldException(Path, LineNumber, 3);
		}//ends here
		if( cardInfo[0].equals(" ") || cardInfo[0].equals("")){
			throw new EmptyFieldException(Path, LineNumber, 1);
		}
		if(cardInfo[1].equals(" ")|| cardInfo[1].equals("")){
			throw new EmptyFieldException(Path, LineNumber, 2);
		}
		if( cardInfo[2].equals(" ")|| cardInfo[2].equals("")){
			throw new EmptyFieldException(Path, LineNumber, 3);
		}
		
		String Name = cardInfo[1];
		String Description = cardInfo[2];
		
	
		
			if(cardInfo[0].equals("Spell")){
				if(cardInfo.length!=3)
					throw new MissingFieldException(Path, LineNumber);	
			
			SpellCard spellcard = null;
			
			switch ((String) cardInfo[1]){
			
			case "Card Destruction" : spellcard = new CardDestruction(Name, Description); break;
			case "Change Of Heart" : spellcard = new ChangeOfHeart(Name, Description); break;
			case "Dark Hole" : spellcard = new DarkHole(Name, Description);break;
			case "Graceful Dice" : spellcard = new GracefulDice(Name, Description); break;
			case "Harpie's Feather Duster" : spellcard = new HarpieFeatherDuster(Name, Description); break;
			case "Heavy Storm" : spellcard = new HeavyStorm(Name, Description); break;
			case "Mage Power" : spellcard = new MagePower(Name, Description); break;
			case "Monster Reborn" : spellcard = new MonsterReborn(Name, Description); break;
			case "Pot of Greed" : spellcard= new PotOfGreed(Name, Description); break;
			case "Raigeki" : spellcard= new  Raigeki(Name, Description); break;
			default : throw new UnknownSpellCardException(Path,LineNumber, cardInfo[1]);
			
			}
			card.add(spellcard);
			
			}
	 
		if(cardInfo[0].equals("Monster")){
             //starts
			if(cardInfo.length!=6)
				throw new MissingFieldException(Path, LineNumber);
			
			if(cardInfo[3] == null){
				throw new EmptyFieldException(Path, LineNumber, 4);
			}
			if(cardInfo[4] == null){
				throw new EmptyFieldException(Path, LineNumber, 5);
			}
			if(cardInfo[5] == null){
				throw new EmptyFieldException(Path, LineNumber, 6);
			}//ends
			if((cardInfo[3].equals(" "))|| cardInfo[3].equals("")){
				throw new EmptyFieldException(Path, LineNumber, 4);
			}
			if(( cardInfo[4].equals(" "))|| cardInfo[4].equals("")){
				throw new EmptyFieldException(Path, LineNumber, 5);
			}
			if((cardInfo[5].equals(" "))|| cardInfo[5].equals("")){
				throw new EmptyFieldException(Path, LineNumber, 6);
			}
			
			int attack = Integer.parseInt(cardInfo[3]);
			int defense = Integer.parseInt(cardInfo[4]);
			int level= Integer.parseInt(cardInfo[5]);
			
			MonsterCard mc = new MonsterCard(Name, Description, level, attack, defense);
		    card.add(mc);
		    
		}

		LineNumber++;
	}
	

	return card;
	}
	
/*____________________________________________________________________________________________*/

public void buildDeck( ArrayList<Card> monster, ArrayList<Card> spell ){
	
	for(int i = 0; i < 15; i++){
		
		int random1 = (int)(Math.floor(Math.random() * monster.size())) ;
		
		deck.add(((MonsterCard) (monster.get(random1))).clone());
	
	}
//15 monster cards.
    for(int j = 0; j < 5; j++){
    	
    	int random2 = (int)(Math.floor(Math.random() * spell.size()))  ;
    	
    	
    	
    	String s = spell.get(random2).getName();
    	switch(s){
    	case "Card Destruction" : deck.add(((CardDestruction)(spell.get(random2))).clone());break;
    	case "Change Of Heart" : deck.add(((ChangeOfHeart)(spell.get(random2))).clone());break;
    	case "Dark Hole" : deck.add(((DarkHole)(spell.get(random2))).clone());break;
    	case "Graceful Dice" : deck.add(((GracefulDice)(spell.get(random2))).clone());break;
    	case "Harpie's Feather Duster" : deck.add(((HarpieFeatherDuster)(spell.get(random2))).clone());break;
    	case "Heavy Storm" : deck.add(((HeavyStorm)(spell.get(random2))).clone());break;
    	case "Mage Power" : deck.add(((MagePower)(spell.get(random2))).clone());break;
    	case "Monster Reborn" : deck.add(((MonsterReborn)(spell.get(random2))).clone());break;
    	case "Pot of Greed" : deck.add(((PotOfGreed)(spell.get(random2))).clone());break;
    	case "Raigeki" : deck.add(((Raigeki)(spell.get(random2))).clone());break;
    	
    	
    	}
    		

      }
}
/*____________________________________________________________________________________________*/

public void shuffleDeck(){
	Collections.shuffle(deck);
	}


/*____________________________________________________________________________________________*/

public ArrayList<Card> drawNCards(int n){
	
	ArrayList<Card> drawCards = new ArrayList<Card>();
	for(int i = 0; i<n; i++){
		if(deck.isEmpty()){
			
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
		    break;}
		
		Card topOfDeck = drawOneCard();
		drawCards.add(topOfDeck);
	}
	
	return drawCards;
}

/*___________________________________________________________________________________________*/

public Card drawOneCard(){
    Card top = new MonsterCard();
		
	if(deck.isEmpty()){
		Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
		return top ;}
	
	top = (Card)deck.remove(0);
    return top;
}

/*___________________________________________________________________________________________*/

/*public static void main(String[] args) throws FileNotFoundException, IOException, UnexpectedFormatException {
	new Deck();
	
}*/

	
}

