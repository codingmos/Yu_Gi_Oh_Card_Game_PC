package eg.edu.guc.yugioh.board.player;

import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;


public class Player implements Duelist {
	private String name;
	private int lifePoints;
	private Field field;
	
    private  boolean onePlayed;
    private  ArrayList<MonsterCard> oneSwitched;
    private  ArrayList<MonsterCard> monstersUsed;
    //private ArrayList<MonsterCard> oppMonstersAttacked;
 
public Player(String name) throws IOException, NoMonsterSpaceException,NoSpellSpaceException,FileNotFoundException,
UnexpectedFormatException{
	  this.name=name;
	  this.lifePoints=8000;
	  this.field = new Field();
	  
	  this.onePlayed = false;
	  this.oneSwitched = new ArrayList<MonsterCard>();
	  this.monstersUsed = new ArrayList<MonsterCard>();
	  //this.oppMonstersAttacked = new ArrayList<MonsterCard>();
  } 



    public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	public String getName() {
		return name;
	}

	public Field getField() {
		return field;
	}



	@Override
	public boolean summonMonster(MonsterCard monster) throws MultipleMonsterAdditionException,NoMonsterSpaceException,
	WrongPhaseException{
		if((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(!( Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))){
					
					//if(monster.getLocation().equals(Location.HAND)){ 
					if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){		
						if (onePlayed == false ){
						onePlayed = Card.getBoard().getActivePlayer().getField().addMonsterToField(monster, Mode.ATTACK, false);
					    return onePlayed;
					} else{
						throw new MultipleMonsterAdditionException();
						}
					}
					else{throw new NoMonsterSpaceException();}
					}
			
				else{
				throw new WrongPhaseException();
				
				}}
		}
		
		return false;
		// TODO Auto-generated method stub
		}



	@Override
	public boolean summonMonster(MonsterCard monster,ArrayList<MonsterCard> sacrifices)throws MultipleMonsterAdditionException,
	NoMonsterSpaceException, WrongPhaseException {
		if((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(!( Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))){
					//if(monster.getLocation().equals(Location.HAND)){
					if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){
						if( onePlayed == false){
							onePlayed = Card.getBoard().getActivePlayer().getField().addMonsterToField(monster, Mode.ATTACK, sacrifices);
							return onePlayed; 
							}
						else{
							throw new MultipleMonsterAdditionException();
							}
						}	
				else{
					throw new NoMonsterSpaceException();}
				}
				else{
					throw new WrongPhaseException();
					}
				}
			}
		
		return false;
		// TODO Auto-generated method stub
		}



	@Override
	public boolean setMonster(MonsterCard monster)throws MultipleMonsterAdditionException,NoMonsterSpaceException,
	WrongPhaseException{
		if((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(!( Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))){
					//if(monster.getLocation().equals(Location.HAND)){
					if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){		
					if (onePlayed == false){
							onePlayed =  Card.getBoard().getActivePlayer().getField().addMonsterToField(monster, Mode.DEFENSE, true);
							return onePlayed; 
							} 
					else{
						throw new MultipleMonsterAdditionException();
						}
					}
				else{
					throw new NoMonsterSpaceException();}
				}
				else{
					throw new WrongPhaseException();
						
						}
				}
			}
		return false;
		// TODO Auto-generated method stub
		}



	@Override
	public boolean setMonster(MonsterCard monster,ArrayList<MonsterCard> sacrifices)throws MultipleMonsterAdditionException, 
	NoMonsterSpaceException, WrongPhaseException {
		if((Card.getBoard().getWinner()== null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(!( Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))){
					//if(monster.getLocation().equals(Location.HAND)){
					if(Card.getBoard().getActivePlayer().getField().getMonstersArea().size()<5){	
					if(onePlayed == false){
							onePlayed = Card.getBoard().getActivePlayer().getField().addMonsterToField(monster, Mode.DEFENSE, sacrifices);
							return onePlayed; 
							}
					
						else{
							throw new MultipleMonsterAdditionException();
							
							}}
					else{
						throw new NoMonsterSpaceException();}
					}
					else{
						throw new WrongPhaseException();
						}
				}
			}
		// TODO Auto-generated method stub
		return false;
		}



	@Override
	public boolean setSpell(SpellCard spell) throws WrongPhaseException, NoSpellSpaceException  {
		if((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(!( Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))){
					if(spell.getLocation().equals(Location.HAND)){
						return Card.getBoard().getActivePlayer().getField().addSpellToField(spell, null, true);
						}
					}else{
						throw new WrongPhaseException();
				       
					}
			}
		
		// TODO Auto-generated method stub
		}
		return false;
		}



	@Override
	public boolean activateSpell(SpellCard spell, MonsterCard monster) throws WrongPhaseException {
		
		if((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(!(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))){
					setSpell(spell);
					return Card.getBoard().getActivePlayer().getField().activateSetSpell(spell, monster);
					} else{
					throw new WrongPhaseException();
					    
					}
				}
			}
		return false;
		}



	@Override
	public boolean declareAttack(MonsterCard activeMonster,MonsterCard opponentMonster)throws WrongPhaseException,
	MonsterMultipleAttackException, DefenseMonsterAttackException {
		if((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE)){
					if(activeMonster.getLocation().equals(Location.FIELD)
							&& (opponentMonster.getLocation().equals(Location.FIELD))){
						if(monstersUsed.contains(activeMonster)==false){
							if((activeMonster.getMode()).equals(Mode.ATTACK)){
								activeMonster.action(opponentMonster);
					            return monstersUsed.add(activeMonster);
					            }else{
					            	throw new DefenseMonsterAttackException();
					            	
					            }
							} else{
								throw new MonsterMultipleAttackException();
								
							}
						}
					} else{
				throw new WrongPhaseException();
				
				}
				}
			}
		return false;
		// TODO Auto-generated method stub
		}



	@Override
	public boolean declareAttack(MonsterCard activeMonster)throws WrongPhaseException, MonsterMultipleAttackException, 
	DefenseMonsterAttackException {
		if((Card.getBoard().getWinner() == null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE)){
					if(activeMonster.getLocation().equals(Location.FIELD)){
						if(monstersUsed.contains(activeMonster)==false){
							if((activeMonster.getMode()).equals(Mode.ATTACK)){
								activeMonster.action();
				                return monstersUsed.add(activeMonster);
				                }else{
					            	throw new DefenseMonsterAttackException();
					            	
				                }
							} else{
								throw new MonsterMultipleAttackException();
								
							}
						}
					}else{
				throw new WrongPhaseException();
			    
			    }
			    }
			}
		// TODO Auto-generated method stub
		return false;
		}



	@Override
	public void addCardToHand() throws WrongPhaseException {
		if((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if (!(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))){
					int prev = Card.getBoard().getActivePlayer().getField().getHand().size();
					Card.getBoard().getActivePlayer().getField().addCardToHand();
			        int next = Card.getBoard().getActivePlayer().getField().getHand().size();
			        int diff = next - prev;
			        if(diff !=  1 ){
			        	Player winner = Card.getBoard().getOpponentPlayer();
			            Card.getBoard().setWinner(winner);
			            }
			        }else{
			        	throw new WrongPhaseException();
			            
			        }
				}
			}
		// TODO Auto-generated method stub
	    }



	@Override
	public void addNCardsToHand(int n) throws WrongPhaseException {
		if((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if (!(Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))){
					int prev = Card.getBoard().getActivePlayer().getField().getHand().size();
					Card.getBoard().getActivePlayer().getField().addNCardsToHand(n);
		            int next = Card.getBoard().getActivePlayer().getField().getHand().size();
		            int diff = next - prev;
		            if(diff != n ){
		            	Player winner = Card.getBoard().getOpponentPlayer();
		            	Card.getBoard().setWinner(winner);
		            	}
		            }else{
		            	throw new WrongPhaseException();
	            		
	            		}
				}
			}
		
		// TODO Auto-generated method stub
		}



	@Override
	public void endPhase() {
		if((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if( (Card.getBoard().getActivePlayer().getField().getPhase()) .equals(Phase.MAIN1)){
					Card.getBoard().getActivePlayer().getField().setPhase(Phase.BATTLE);
					}else if( (Card.getBoard().getActivePlayer().getField().getPhase()) .equals(Phase.BATTLE)){
						Card.getBoard().getActivePlayer().getField().setPhase(Phase.MAIN2);
						} else  if( (Card.getBoard().getActivePlayer().getField().getPhase()) .equals(Phase.MAIN2)){
							endTurn();
							}
				}
			}
	 // TODO Auto-generated method stub
		}



	@Override
	public boolean endTurn() {
		if(((Card.getBoard().getWinner())==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
		        onePlayed = false;
				monstersUsed.clear();
				oneSwitched.clear();
				Card.getBoard().nextPlayer();
				Card.getBoard().getActivePlayer().getField().setPhase(Phase.MAIN1);
				return true;
			}}
		//}
		return false;
		
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean switchMonsterMode(MonsterCard monster) throws WrongPhaseException{
		if ((Card.getBoard().getWinner()==null)){
			if(this.equals(Card.getBoard().getActivePlayer())){
			  if(!((Card.getBoard().getActivePlayer().getField().getPhase()).equals(Phase.BATTLE))){
					if((oneSwitched.contains(monster) != true)){
						if(monster.getLocation().equals(Location.FIELD)){
						if(monster.getMode().equals(Mode.ATTACK))
				           monster.setMode(Mode.DEFENSE);
			            else
				           monster.setMode(Mode.ATTACK);
			           return oneSwitched.add(monster);
			           
			           }
					}
				}else{
			  throw new WrongPhaseException();
			 
			  }
			  }
			}
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	//this is a trial getter-to be removed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//public boolean getOnePlayed(){
		//return onePlayed;
	//}
///	public ArrayList<MonsterCard> getmonstersUsed(){
	////	return monstersUsed;
	//}
//WrongPhaseException has been thrown in Player Class
//MultipleMonsterAdditionException has been thrown in Player Class
//MonsterMultipleAttackException has been thrown in Player Class
//DefenseMonsterAttackException has been thrown in Player Class

}
