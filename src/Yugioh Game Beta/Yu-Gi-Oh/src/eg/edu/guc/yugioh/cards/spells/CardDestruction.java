package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;


public class CardDestruction extends SpellCard{
	 
	public CardDestruction( String name, String description){
		super(name, description);
		
	}
	
	public SpellCard clone(){
		return new CardDestruction(getName(),getDescription());
		}
	
	public void action(MonsterCard monster){
	
		int countop = 0;
		int countap = 0;
		//ArrayList<Card> ophand = getBoard().getOpponentPlayer().getField().getHand();
		//ArrayList<Card> opgrave = getBoard().getOpponentPlayer().getField().getGraveyard();
		while(!(getBoard().getOpponentPlayer().getField().getHand().isEmpty())){
			getBoard().getOpponentPlayer().getField().getHand().get(0).setLocation(Location.GRAVEYARD);
			getBoard().getOpponentPlayer().getField().getGraveyard().add(getBoard().getOpponentPlayer().getField().getHand().remove(0));
			countop++;}
		
		/*ArrayList<Card> aphand = getBoard().getActivePlayer().getField().getHand();
		ArrayList<Card> apgrave = getBoard().getActivePlayer().getField().getGraveyard();
		while(!(aphand.isEmpty())){
			aphand.get(0).setLocation(Location.GRAVEYARD);
			apgrave.add(aphand.remove(0));
			countap++;}*/
		
		while(!(getBoard().getActivePlayer().getField().getHand().isEmpty())){
			getBoard().getActivePlayer().getField().getHand().get(0).setLocation(Location.GRAVEYARD);
			getBoard().getActivePlayer().getField().getGraveyard().add(getBoard().getActivePlayer().getField().getHand().remove(0));
			countap++;}
		
		
			getBoard().getOpponentPlayer().getField().addNCardsToHand(countop);
			getBoard().getActivePlayer().getField().addNCardsToHand(countap);

	}

}
