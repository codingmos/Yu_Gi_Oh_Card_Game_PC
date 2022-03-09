package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class PotOfGreed extends SpellCard {
	public PotOfGreed(String name, String description){
		super(name, description);
	}
	public SpellCard clone(){
		return new PotOfGreed(getName(),getDescription());
		}
	
	public void action(MonsterCard monster){
		//System.out.println(getBoard().getActivePlayer().getField().getHand().size());
		//System.out.println(getBoard().getActivePlayer().getField().getDeck().getDeck().size());
		getBoard().getActivePlayer().getField().addNCardsToHand(2);
		//System.out.println(getBoard().getActivePlayer().getField().getHand().size());
		//System.out.println(getBoard().getActivePlayer().getField().getDeck().getDeck().size());
		
		
		
		
	}
}
