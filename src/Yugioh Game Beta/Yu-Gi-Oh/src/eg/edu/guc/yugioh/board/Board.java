package eg.edu.guc.yugioh.board;





import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Board {
	private Player activePlayer;
	private Player opponentPlayer;
	private Player winner;
	
	public Board() {
		
		winner = null;
		Card.setBoard(this);
	}

/*____________________________________________________________________________________*/
    
   
	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public Player getOpponentPlayer() {
		return opponentPlayer;
	}

	public void setOpponentPlayer(Player opponentPlayer) {
		this.opponentPlayer = opponentPlayer;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

/*_________________________________________________________________________________________*/
	
	public void whoStarts(Player p1, Player p2){
		
		Player [] players = {p1,p2};
		int random = (int)(Math.random() * players.length);
		activePlayer = players[random];
		
		if(p1.equals(activePlayer))
			opponentPlayer = p2;
		else
			opponentPlayer = p1;
		
		}
	

/*__________________________________________________________________________________________*/

	public void startGame(Player p1, Player p2){
		p1.getField().addNCardsToHand(5);
		p2.getField().addNCardsToHand(5);
	//draws five cards for both players	
		this.whoStarts(p1,p2);
		activePlayer.getField().addCardToHand();

	//draws one card for the activePlayer
	}

/*____________________________________________________________________________________________*/	
	
	public void nextPlayer (){
		
		Player tmp = activePlayer;
		activePlayer = opponentPlayer;
		opponentPlayer = tmp;
		activePlayer.getField().addCardToHand();
		
		//makes the current active player draw one card;
	}}



