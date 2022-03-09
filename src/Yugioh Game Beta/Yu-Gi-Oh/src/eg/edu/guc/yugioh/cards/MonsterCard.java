package eg.edu.guc.yugioh.cards;




public class MonsterCard extends Card{
	private int level;
	private int defensePoints;
	private int attackPoints;
	private Mode mode;

	public MonsterCard(String name, String description, int level, int attack, int defence){
		super(name, description);
		this.level = level;
		this.attackPoints = attack;
		this.defensePoints = defence;
		this.mode = Mode.DEFENSE;
	}
	public MonsterCard(){
	}

	public int getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public int getLevel() {
		return level;
	}
	
	public MonsterCard clone(){
		return new MonsterCard(getName(),getDescription(),getLevel(),getAttackPoints(),getDefensePoints());
	}
	@Override
	public void action(MonsterCard monster) {
		
		
		if((monster.getMode()) .equals(Mode.ATTACK)){
    	if(this.getAttackPoints() > monster.getAttackPoints()){
    		int diff = this.getAttackPoints() - monster.getAttackPoints();
    	    getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
    		int c = getBoard().getOpponentPlayer().getLifePoints();
    		getBoard().getOpponentPlayer().setLifePoints(c-diff);
    		//result = true;
    		}
    	if(this.getAttackPoints() == monster.getAttackPoints()){
    		getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
    	    getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
    		//result = true;  	    
    	    }
    	if(this.getAttackPoints() < monster.getAttackPoints()){
    		int diff =  monster.getAttackPoints() - this.getAttackPoints() ;
    	    getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
    		int c = getBoard().getActivePlayer().getLifePoints();
    		getBoard().getActivePlayer().setLifePoints(c-diff);
    		//result = true;
    		}
     }
    if(monster.getMode().equals(Mode.DEFENSE)){
    	if(this.getAttackPoints() > monster.getDefensePoints()){
    	    getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
    		//result = true;
    		}
    	//if(this.getAttackPoints() == monster.getDefensePoints())
    	//Nothing Happens	
    		
    	if(this.getAttackPoints() < monster.getDefensePoints()){
    		int diff =  (monster.getDefensePoints()) - (this.getAttackPoints()) ;
    	    //getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
    		int c = (getBoard().getActivePlayer().getLifePoints());
    		getBoard().getActivePlayer().setLifePoints(c- diff);
    		//if((getBoard().getActivePlayer().getLifePoints())<=0)
    		//	getBoard().setWinner(getBoard().getOpponentPlayer());
    		//result = true;
    		}
    }
    
    int ap = getBoard().getActivePlayer().getLifePoints();
    int op = getBoard().getOpponentPlayer().getLifePoints();
    
    if (ap <= 0)
    	getBoard().setWinner(getBoard().getOpponentPlayer());
    if (op <= 0)
    	getBoard().setWinner(getBoard().getActivePlayer());
		// TODO Auto-generated method stub
		//return result;
	}
	
	
	public void action(){
		
		if(getBoard().getOpponentPlayer().getField().getMonstersArea().isEmpty()== true){
		int lp = getBoard().getOpponentPlayer().getLifePoints(); 
		int ap= this.getAttackPoints();
		getBoard().getOpponentPlayer().setLifePoints(lp-ap); 
		
		 if ((getBoard().getOpponentPlayer().getLifePoints())<=0)
		    	getBoard().setWinner(getBoard().getActivePlayer());
		}
	}
	}
	

