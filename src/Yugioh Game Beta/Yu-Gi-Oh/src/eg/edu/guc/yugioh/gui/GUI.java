package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

public class GUI extends JFrame implements MouseListener {
private static final int ArrayList = 0;
public static int boardWidth = 1000;
public static int boardHeight = 700;

JPanel welcomePanel;
JTextField p1NameText;
JLabel p1NameLabel;
JTextField p2NameText;
JLabel p2NameLabel;
JButton startGame;

JPanel gameover ;
JPanel playPanel;
JPanel field1;
JPanel field2;
JButton quit;
JButton playagain;
JButton deck1;
JButton deck2;
JButton endTurn;
JButton endPhase;
JCheckBox summonMonster;
JCheckBox activateSpell;


JButton[] monstersButtons1;
JButton[] monstersButtons2;
JButton[] spellsButtons1;
JButton[] spellsButtons2;
JButton[] handButtons1;
JButton[] handButtons2;

JLabel card1;
JLabel card2;
JLabel copyrights ;
JLabel graveyard1;
JLabel graveyard2;
JLabel player1Info;
JLabel player2Info;
JLabel currentPlayer;
JLabel currentPhase;
JPanel monstersPanel1;
JPanel monstersPanel2;
JPanel spellsPanel1;
JPanel spellsPanel2;
JPanel hand1;
JPanel hand2;
JLabel cardInfo1;
JLabel cardInfo2;

Board board;
Player player1;
Player player2;
MonsterCard attackMonster;

JPanel gameoverPanel;

public GUI(){
	welcomePanel = new JPanel();
	welcomePanel.setLayout(null);
	welcomePanel.setSize(500,750);
	welcomePanel.setBackground(Color.BLACK);
	this.getContentPane().add(welcomePanel);
	
	//p1NameText.setBounds(x, y, width, height);
	p1NameText = new JTextField(" Player 1 ");
	p1NameText.setBounds(10, 215, 150, 25);
	p1NameText.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 20));
	p1NameText.setForeground(Color.RED);
	welcomePanel.add(p1NameText);
	
	JLabel good = new JLabel();
	good.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\CSEN 401 - GAME\\YuGiOh Cards and Logos\\yugioh.jpg"));
	good.setBounds(5, 150, 230, 110);
	welcomePanel.add(good);
	
	JLabel symbol = new JLabel();
	symbol.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\CSEN 401 - GAME\\YuGiOh Cards and Logos\\yugioh_logo.png"));
	symbol.setBounds(84, 0, 340, 155);
	welcomePanel.add(symbol);

	
    p2NameText = new JTextField(" Player 2 ");
	p2NameText.setBounds(335,220, 150, 25);
	p2NameText.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 20));
	p2NameText.setForeground(Color.BLUE);
	welcomePanel.add(p2NameText);
	
	JLabel vs = new JLabel("VS");
	vs.setForeground(Color.YELLOW);
	vs.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 35));
	vs.setBounds(195,163, 150, 75);
	welcomePanel.add(vs);
	
	JLabel evil = new JLabel();
	evil.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\CSEN 401 - GAME\\YuGiOh Cards and Logos\\Evil.jpg"));
	evil.setBounds(330, 150, 230, 110);
	welcomePanel.add(evil);
	
	JLabel Advice = new JLabel("<html>" +"<br>Yami has solved the puzzle! It Contains the soul of Pharaoh Atem. The power to summon and control Duel Monsters, including the Egyptian Gods, and the magic of the Shadow Games. It's like no other game! Once you play, there is no going back!  " + "</html>");
	Advice.setBounds(0, 250, 490, 100);
	Advice.setFont(new Font("Matura MT Script Capitals",Font.PLAIN, 15));
	Advice.setForeground(Color.RED);
	welcomePanel.add(Advice);
	
	startGame = new JButton(" Start Game ");
	startGame.setBounds(0,380, 502, 339);
	startGame.setFont(new Font("Matura MT Script Capitals", Font.ITALIC|Font.BOLD, 16));
	startGame.addMouseListener(this);	
	startGame.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\CSEN 401 - GAME\\YuGiOh Cards and Logos\\tumblr_mra2fgbxRe1sevsk0o1_500.gif"));
	startGame.setForeground(Color.WHITE);
	startGame.setBackground(Color.YELLOW);
	welcomePanel.add(startGame);
	
	 this.setTitle("Yu-Gi-Oh  Beta");
	 this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mostafa\\Desktop\\CSEN 401 - GAME\\YuGiOh Cards and Logos\\th.jpg"));
     this.setSize(500,750);
	 this.setLayout(null);
	 this.setVisible(true);
	 this.setResizable(false);
	 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==startGame || e.getSource() == playagain){
			try{
				initGameBoard();
				return;
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}else if(e.getSource() == endTurn){
			board.getActivePlayer().endTurn();
			refreshEngine();
			return;
		}else if(e.getSource()== endPhase){
			board.getActivePlayer().endPhase();
			refreshEngine();
			return;
		} else if(e.getSource() == quit){
			this.dispose();
			return;
		}
		
		//add card from hand to fields
		if(handButtons1!=null){
			for(int i =0; i<handButtons1.length; i++){
				if(e.getSource() == handButtons1[i]){
					Card c = board.getActivePlayer().getField().getHand().get(i);
					addCardToField(c, player1);
				}
			}
		}
		if(handButtons2!=null){
			for(int i =0; i<handButtons2.length; i++){
				if(e.getSource() == handButtons2[i]){
					Card c = board.getActivePlayer().getField().getHand().get(i);
					addCardToField(c, player2);
				}
			}
		}
		//switch monsters from attack to defense depending on game phase
		for(int i = 0; i<player1.getField().getMonstersArea().size(); i++){
			if(e.getSource() == monstersButtons1[i]){
				MonsterCard m = player1.getField().getMonstersArea().get(i);
				handleMonstersAreaClick(player1,player2, m);
			}
		}
		for(int i = 0; i<player2.getField().getMonstersArea().size(); i++){
			if(e.getSource() == monstersButtons2[i]){
				MonsterCard m = player2.getField().getMonstersArea().get(i);
				handleMonstersAreaClick(player2,player1, m);
			}
		}
		refreshEngine();
	}
		public void handleMonstersAreaClick(Player a, Player b, MonsterCard m){
			try{
				if(a==board.getActivePlayer()){
					if(a.getField().getPhase()!=Phase.BATTLE){
						//Main1 or Main2
						switchMonsterMode(a,m);
					}else{
						//battle phase
						if(b.getField().getMonstersArea().size()==0){
							a.declareAttack(m);
						}else{
							//just save the monster you want to attack with
							attackMonster = m;
						}
					}
				}else{
					//b in attack
					if(attackMonster!=null){
						board.getActivePlayer().declareAttack(attackMonster,m);
						attackMonster =null;
					}else{
						JOptionPane.showMessageDialog(this, "Choose an attaching monster first from your monsters area");
						
					}
						
				}
				refreshEngine();
				
			}
			catch(MonsterMultipleAttackException e){
				JOptionPane.showMessageDialog(this, "Can't attack with a monster twice");
				attackMonster = null;
			}
			catch(DefenseMonsterAttackException e){
				JOptionPane.showMessageDialog(this, "Can't attack with a monster in a defense mode");
				attackMonster = null;
			}
		}
		
		public void switchMonsterMode(Player currentP, MonsterCard m){
			boolean b = currentP.switchMonsterMode(m);
			if(b==true){
				refreshEngine();
			}else{
				JOptionPane.showMessageDialog(this, "You can switch monster only once");
			}
			
		}
		
		public String[] getMonstersInMonstersArea(ArrayList<MonsterCard> monsters){
			String[]r = new String[monsters.size()];
			
			for(int i = 0; i<monsters.size();i++){
				r[i]= monsters.get(i).getName();
			}
			return r;
		}
		
		public ArrayList<MonsterCard> getUserInput(String[] monstersNames, int sacrificeCount, ArrayList<MonsterCard> monstersArray){
			ArrayList<MonsterCard> sacrifices = new ArrayList<MonsterCard>();
			
			for(int i = 0; i<sacrificeCount; i++){
				String s = (String)JOptionPane.showInputDialog(this, 
						"Choose a monster to sactifice with", "Monster Choice", 
						JOptionPane.PLAIN_MESSAGE, null, monstersNames, monstersNames[0]);
				
				for(int j =0; j<monstersArray.size(); j++){
					if(monstersArray.get(j).getName().equals(s)){
						sacrifices.add((MonsterCard)monstersArray.get(j));
					}
				}
			}
			return sacrifices;
		}
		
		public void addCardToField(Card c, Player currentP){
			if(c instanceof MonsterCard){
				MonsterCard m = (MonsterCard)c;
				try{
					if(summonMonster.isSelected()){
						if(m.getLevel() <=4){
							board.getActivePlayer().summonMonster(m);
							
						}else{
							String[] monsters = getMonstersInMonstersArea(currentP.getField().getMonstersArea());
						    if(m.getLevel() >= 5 && m.getLevel()<=6){
						    	ArrayList<MonsterCard> sacrifices = getUserInput(monsters, 1, currentP.getField().getMonstersArea());
						    	board.getActivePlayer().summonMonster(m, sacrifices);
						     }else if(m.getLevel()>=7 && m.getLevel()<=8){
						    	 ArrayList<MonsterCard> sacrifices = getUserInput(monsters, 2, currentP.getField().getMonstersArea());
							    	board.getActivePlayer().summonMonster(m, sacrifices);
						     }
						}
					}else{
						board.getActivePlayer().setMonster(m);
					}
					refreshEngine();
				}
				catch(MultipleMonsterAdditionException ex){
					JOptionPane.showMessageDialog(this, "Can't add monster! You have only one monster to add per turn");
					}
				catch(WrongPhaseException ex){
					JOptionPane.showMessageDialog(this, "Wrong phase addition");
					}
				}else {
					try{
						if(activateSpell.isSelected()){
							if(c instanceof ChangeOfHeart || c instanceof MagePower){
								String[] monsters = getMonstersInMonstersArea(board.getOpponentPlayer().getField().getMonstersArea());
								ArrayList<MonsterCard> m = getUserInput(monsters, 1, board.getOpponentPlayer().getField().getMonstersArea());
								board.getActivePlayer().activateSpell((SpellCard)(c), m.get(0));
							}
							else{
								board.getActivePlayer().activateSpell((SpellCard) c, null);
							}
						} 
						else{
							board.getActivePlayer().setSpell((SpellCard)c);
						}
						refreshEngine();
					}
					catch(WrongPhaseException ex){
						JOptionPane.showMessageDialog(this, "Wrong phase addition");
					}
				}
		}
		public void initGameBoard()throws IOException, UnexpectedFormatException{
			//remove old components
			boardWidth = 1925;
			boardHeight = 1025;
			this.getContentPane().removeAll();
			//this.getContentPane().remove(welcomePanel);
			this.getContentPane().repaint();
		
			
			this.setSize(boardWidth, boardHeight);
			
			//initialize engine
			board = new Board();
			player1 = new Player(p1NameText.getText());
			player2 = new Player(p2NameText.getText());
			board.startGame(player1, player2);
			player1 = board.getActivePlayer();
			player2 = board.getOpponentPlayer();
			
			//add new components
			 playPanel = new JPanel();
			 playPanel.setLayout(null);
			 playPanel.setBounds(0, 0, boardWidth, boardHeight);
			 getContentPane().add(playPanel);
			 playPanel.setBackground(Color.BLACK);
			
			 /*field1 = new JPanel(); 
			 field1.setLayout(null);
			 field1.setBounds(0,0, 1075, boardHeight/ 2 );
			 field1.setBackground(Color.BLACK);
			 playPanel.add(field1);
			 
			 field2 = new JPanel();
			 field2.setLayout(null);
			 field2.setBounds(0, boardHeight / 2 , 1075, boardHeight / 2 ); 
			 field2.setBackground(Color.BLACK);
			 playPanel.add(field2);*/
			
			/* JLabel theme = new JLabel();
			 theme.setBounds(0, 0,boardWidth, boardHeight);
			 theme.setVisible(true);
			 theme.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\LC3-Game-Board-reverse"));
			 playPanel.add(theme);*/
			 
			 deck1 = new JButton(player1.getField().getDeck().getDeck().size()+"");
			 deck1.setBounds(20, 10, 190,270);
			 deck1.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\index.jpg")); 
			 deck1.setHorizontalTextPosition(JButton.CENTER);
			 deck1.setVerticalTextPosition(JButton.CENTER);
			 deck1.setForeground(Color.YELLOW); 
			 deck1.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 40));
			 deck1.addMouseListener(this);
			 playPanel.add(deck1);
			 
             deck2 = new JButton(player2.getField().getDeck().getDeck().size() + "");
             deck2.setBounds(1725,720,190,270);
             deck2.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\index.jpg"));
             deck2.setHorizontalTextPosition(JButton.CENTER);
             deck2.setVerticalTextPosition(JButton.CENTER);
             deck2.setForeground(Color.YELLOW);
             deck2.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 40));
			 deck2.addMouseListener(this);
			 playPanel.add(deck2);
			 
			 graveyard1 = new JLabel();
			 graveyard1.setBounds(875,10,200,270);
			 graveyard1.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\index.jpg"));
			 graveyard1.setHorizontalTextPosition(JButton.CENTER);
             graveyard1.setVerticalTextPosition(JButton.CENTER);
             graveyard1.setForeground(Color.YELLOW);
             graveyard1.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 14));
             playPanel.add(graveyard1);
             
			 graveyard2 = new JLabel();
			 graveyard2.setBounds(875,720,200,270);
			 graveyard2.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\index.jpg"));
			 graveyard2.setHorizontalTextPosition(JButton.CENTER);
             graveyard2.setVerticalTextPosition(JButton.CENTER);
             graveyard2.setForeground(Color.YELLOW);
             graveyard2.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 14));
             playPanel.add(graveyard2);
             
             JLabel centereye = new JLabel();
             centereye.setBounds(890,355,200,270);
             centereye.setIcon((new ImageIcon("C:\\Users\\Mostafa\\Desktop\\CSEN 401 - GAME\\YuGiOh Cards and Logos\\144.gif")));
             playPanel.add(centereye);
             
             endTurn = new JButton("End Turn");
             endTurn.addMouseListener(this);
             endTurn.setForeground(Color.RED);
             endTurn.setBackground(Color.BLACK);
             endTurn.setBounds(875,615,185,30);
             endTurn.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 16));
             playPanel.add(endTurn);
             
            /* ImageIcon a  = new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\index.jpg");
             JLabel MagCard = new JLabel(a);
             MagCard.setBounds(1200, 500, 200, 300);
             playPanel.add(MagCard);*/
             
             
             currentPlayer = new JLabel("Player Turn:" + board.getActivePlayer().getName());
             currentPlayer.setBounds(1100,30,350,30);
             currentPlayer.setForeground(Color.LIGHT_GRAY);
             currentPlayer.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 22));
             playPanel.add(currentPlayer);
             
             summonMonster = new JCheckBox("Summon Monster");
             summonMonster.setBounds(875,300,185,30);
             summonMonster.setForeground(Color.RED);
             summonMonster.setBackground(Color.BLACK);
             summonMonster.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 16));
             summonMonster.setSelected(true);
             playPanel.add(summonMonster);
             
             activateSpell = new JCheckBox("Activate Spell");
             activateSpell.setBounds(875,665,185,30);
             activateSpell.setForeground(Color.RED);
             activateSpell.setBackground(Color.BLACK);
             activateSpell.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 16));
             activateSpell.setSelected(true);
             playPanel.add(activateSpell);
             
             endPhase = new JButton("End Phase");
             endPhase.addMouseListener(this);
             endPhase.setForeground(Color.RED);
             endPhase.setBackground(Color.BLACK);
             endPhase.setBounds(875,350,185,30);
             endPhase.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 16));
             playPanel.add(endPhase);
             
             currentPhase = new JLabel("Phase:" + board.getActivePlayer().getField().getPhase());
             currentPhase.setBounds(1390,30,300,30);
             currentPhase.setForeground(Color.LIGHT_GRAY);
             currentPhase.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 22));
             playPanel.add(currentPhase);
             
             JLabel symbol = new JLabel();
			 symbol.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\CSEN 401 - GAME\\YuGiOh Cards and Logos\\yugioh_logo.png"));
			 symbol.setBounds(1600, 0, 340, 135);
			 playPanel.add(symbol);
             
             
             card1 = new JLabel();
             card1.setBounds(235, 500, 300, 450);
             //card1.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\Alexandrite Dragon.png"));
             playPanel.add(card1);
             
             hand1 = new JPanel();
             hand1.setLayout(new GridLayout(1,6));
             hand1.setBounds(235, 10, 600, 160);
             hand1.setBackground(Color.GRAY);
             playPanel.add(hand1);
             
             spellsPanel1 = new JPanel();
             spellsPanel1.setLayout(new GridLayout(1,5));
             spellsPanel1.setBounds(235, 180, 600, 160);
             spellsPanel1.setBackground(Color.GRAY);
             playPanel.add(spellsPanel1);
             
             monstersPanel1 = new JPanel();
             monstersPanel1.setLayout(new GridLayout(1,5));
             monstersPanel1.setBounds(235, 340, 600, 160);
             monstersPanel1.setBackground(Color.GRAY);
             playPanel.add(monstersPanel1);
             
             card2 = new JLabel();
             card2.setBounds(1100, 75, 300, 450);
            // card2.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\Alexandrite Dragon.png"));
             playPanel.add(card2);
             
             hand2 = new JPanel();
             hand2.setLayout(new GridLayout(1,6));
             hand2.setBounds(1100, 855, 600, 130);
             hand2.setBackground(Color.GRAY);
             playPanel.add(hand2);
             
             spellsPanel2 = new JPanel();
             spellsPanel2.setLayout(new GridLayout(1,5));
             spellsPanel2.setBounds(1100, 685, 600, 160);
             spellsPanel2.setBackground(Color.GRAY);
             playPanel.add(spellsPanel2);
             
             monstersPanel2 = new JPanel();
             monstersPanel2.setLayout(new GridLayout(1,5));
             monstersPanel2.setBounds(1100, 525, 600, 160);
             monstersPanel2.setBackground(Color.GRAY);
             playPanel.add(monstersPanel2);
             
             monstersButtons1 = new JButton[5];
             for(int i = 0; i<monstersButtons1.length; i++){
            	 monstersButtons1[i] = new JButton();
            	 monstersButtons1[i].setSize(80, 120);
            	 monstersButtons1[i].addMouseListener(this);
            	 monstersButtons1[i].setBackground(Color.BLACK);
            	 monstersButtons1[i].setHorizontalTextPosition(JButton.CENTER);
            	 monstersButtons1[i].setVerticalTextPosition(JButton.CENTER);
            	 monstersButtons1[i].setForeground(Color.YELLOW);
            	 monstersPanel1.add(monstersButtons1[i]);
             }
             
             monstersButtons2 = new JButton[5];
             for(int i = 0; i<monstersButtons2.length; i++){
            	 monstersButtons2[i] = new JButton();
            	 monstersButtons2[i].setSize(80, 120);
            	 monstersButtons2[i].addMouseListener(this);
            	 monstersButtons2[i].setBackground(Color.BLACK);
            	 monstersButtons2[i].setHorizontalTextPosition(JButton.CENTER);
            	 monstersButtons2[i].setVerticalTextPosition(JButton.CENTER);
            	 monstersButtons2[i].setForeground(Color.YELLOW);
            	 monstersPanel2.add(monstersButtons2[i]);
             }
             
             spellsButtons1 = new JButton[5];
             for(int i = 0; i<spellsButtons1.length; i++){
            	 spellsButtons1[i] = new JButton();
            	 spellsButtons1[i].setSize(80, 120);
            	 spellsButtons1[i].setBackground(Color.BLACK);
            	 spellsButtons1[i].addMouseListener(this);
            	 spellsButtons1[i].setHorizontalTextPosition(JButton.CENTER);
            	 spellsButtons1[i].setVerticalTextPosition(JButton.CENTER);
            	 spellsButtons1[i].setForeground(Color.YELLOW);
            	 spellsPanel1.add(spellsButtons1[i]);
             }
             
             spellsButtons2 = new JButton[5];
             for(int i = 0; i<spellsButtons2.length; i++){
            	 spellsButtons2[i] = new JButton();
            	 spellsButtons2[i].setSize(80, 120);   
            	 spellsButtons2[i].setBackground(Color.BLACK);
            	 spellsButtons2[i].addMouseListener(this);
            	 spellsButtons2[i].setHorizontalTextPosition(JButton.CENTER);
            	 spellsButtons2[i].setVerticalTextPosition(JButton.CENTER);
            	 spellsButtons2[i].setForeground(Color.YELLOW);
            	 spellsPanel2.add(spellsButtons2[i]);
             }
		
		
		     player1Info = new JLabel(board.getActivePlayer().getName() + " : " + board.getActivePlayer().getLifePoints());
		     player1Info.setBounds(30,420,200,30);
		     player1Info.setForeground(Color.GREEN);
		     player1Info.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 16));
		     playPanel.add(player1Info);
		     
		     copyrights = new JLabel("Copyright © 2015. HASHASH. All Rights Reserved.");
		     copyrights.setBounds(235, 950, 350, 50);
		     playPanel.add(copyrights);
		     
		     player2Info = new JLabel(board.getOpponentPlayer().getName() + " : " + board.getOpponentPlayer().getLifePoints());
		     player2Info.setBounds(1735, 550,200,30);
		     player2Info.setForeground(Color.GREEN);
		     player2Info.setFont(new Font("Matura MT Script Capitals", Font.ITALIC | Font.BOLD, 16));
		     playPanel.add(player2Info);
		     
		     cardInfo1 = new JLabel("Card Info");
		     cardInfo1.setBounds(550, 600, 150, 350);
		     cardInfo1.setForeground(Color.LIGHT_GRAY);
		     cardInfo1.setFont(new Font("Matura MT Script Capitals", Font.ITALIC,14));
		     playPanel.add(cardInfo1);
		
		     cardInfo2 = new JLabel("Card Info");
		     cardInfo2.setBounds(1425, 100, 150, 350);
		     cardInfo2.setForeground(Color.LIGHT_GRAY);
		     cardInfo2.setFont(new Font("Matura MT Script Capitals", Font.ITALIC,14));
		     playPanel.add(cardInfo2);
		     
		     refreshEngine();
	}
		
		public void refreshEngine(){
			updatePlayerScoreAndGameStatus();
			
			//update graveyard with the latest card
			updateGraveyard(player1,graveyard1);
			updateGraveyard(player2,graveyard2);
			
			//update hands
			updateHand1();
			updateHand2();
			
			//update monsters and spells area 1
			updateMonstersArea(player1, monstersButtons1);
			updateMonstersArea(player2, monstersButtons2);
			updateSpellsArea(player1, spellsButtons1);
			updateSpellsArea(player2, spellsButtons2);
			
			//update deck button size
			updateDeckSize();
			
			if(board.getWinner()!=null){
				this.getContentPane().remove(playPanel);
				this.setSize(800,400 );
				gameover = new JPanel();
				gameover.setSize(800,400);
				gameover.setBackground(Color.BLACK);
				gameover.setLayout(null);
				this.getContentPane().add(gameover);
				
				playagain = new JButton("Play Again");
				quit = new JButton("Quit");
				playagain.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 20));
				quit.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 20));
				playagain.setBounds(300,125,200,50);
				quit.setBounds(300,175,200,50);
				playagain.setForeground(Color.LIGHT_GRAY);
				playagain.setBackground(Color.DARK_GRAY);
				quit.setForeground(Color.LIGHT_GRAY);
				quit.setBackground(Color.DARK_GRAY);
				gameover.add(playagain);
				gameover.add(quit);
				playagain.addMouseListener(this);
				quit.addMouseListener(this);
				
				copyrights = new JLabel("Copyright © 2015. HASHASH. All Rights Reserved.");
			    copyrights.setBounds(258, 235, 300, 10);
			    copyrights.setForeground(Color.GRAY);
			    gameover.add(copyrights);
			    
			    JLabel symbol = new JLabel();
				symbol.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\CSEN 401 - GAME\\YuGiOh Cards and Logos\\yugioh_logo.png"));
				symbol.setBounds(235, 238, 340, 155);
				gameover.add(symbol);
			    
				JLabel winner  = new JLabel(""+ board.getWinner().getName() +" Winner!");
				winner.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 40));
				winner.setBounds(200,50,400,50);
				winner.setForeground(Color.RED);
				gameover.add(winner);
				
				
			}
		}
		
		public void updateSpellsArea( Player p, JButton[]spellsButtons){
			for(int i = 0; i< spellsButtons.length; i++){
				spellsButtons[i].setIcon(null);
				spellsButtons[i].setText("");
			}
			for(int i =0; i<p.getField().getSpellArea().size(); i++){
				SpellCard m = p.getField().getSpellArea().get(i);
				if(m.isHidden()){
					spellsButtons[i].setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\index.jpg"));		
				}
				else{
					spellsButtons[i].setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+m.getName() +".png"));
					spellsButtons[i].setText(m.getName());}
				
			}
		}
		
		public void updateMonstersArea( Player p, JButton[]monstersButtons){
			for(int i = 0; i< monstersButtons.length; i++){
				monstersButtons[i].setIcon(null);
				monstersButtons[i].setText("");
			}
			for(int i =0; i<p.getField().getMonstersArea().size(); i++){
				MonsterCard m = p.getField().getMonstersArea().get(i);
				if(m.isHidden()){
					monstersButtons[i].setIcon(new ImageIcon ("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\" +m.getName() +".png"));		
				}
				else{
					monstersButtons[i].setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\" +m.getName() +".png"));
					monstersButtons[i].setText(m.getName());
				}
			}
		}
		
		public void updateHand1(){
			hand1.removeAll();
			hand1.repaint();
			if(player1 == board.getActivePlayer()){
				handButtons1 = new JButton[player1.getField().getHand().size()];
				hand1.setLayout(new GridLayout(1, player1.getField().getHand().size()));
				
				for(int i = 0; i < handButtons1.length; i++){
					handButtons1[i] = new JButton();
					handButtons1[i].addMouseListener(this);
					handButtons1[i].setHorizontalTextPosition(JButton.CENTER);
					handButtons1[i].setVerticalTextPosition(JButton.CENTER);
					handButtons1[i].setForeground(Color.YELLOW);
					handButtons1[i].setFont(new Font("Matura MT Script Capitals", Font.ITALIC|Font.BOLD , 14));
					handButtons1[i].setText(player1.getField().getHand().get(i).getName());
					hand1.add(handButtons1[i]);
					if(player1.getField().getHand().get(i) instanceof MonsterCard){
						handButtons1[i].setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+ handButtons1[i].getText()+ ".png"));
					}
					else{
						String spellname = player1.getField().getHand().get(i).getName();
						handButtons1[i].setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+spellname + ".png"));}
				    }
				}
			}
		
		public void updateHand2(){
			hand2.removeAll();
			hand2.repaint();
			if(player2 == board.getActivePlayer()){
				handButtons2 = new JButton[player2.getField().getHand().size()];
				hand2.setLayout(new GridLayout(1, player2.getField().getHand().size()));
				
				for(int i = 0; i < handButtons2.length; i++){
					handButtons2[i] = new JButton();
					handButtons2[i].addMouseListener(this);
					handButtons2[i].setHorizontalTextPosition(JButton.CENTER);
					handButtons2[i].setVerticalTextPosition(JButton.CENTER);
					handButtons2[i].setForeground(Color.YELLOW);
					handButtons2[i].setFont(new Font("Matura MT Script Capitals", Font.ITALIC|Font.BOLD , 14));
					handButtons2[i].setText(player2.getField().getHand().get(i).getName());
					hand1.add(handButtons2[i]);
					if(player2.getField().getHand().get(i) instanceof MonsterCard){
						handButtons2[i].setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+ handButtons2[i].getText()+ ".png"));
					}
					else{
						String spellname = player2.getField().getHand().get(i).getName();
						handButtons2[i].setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\" +spellname + ".png"));}
				    }
				}
			}
		
		public void updateGraveyard(Player p, JLabel g){
			int gSize = p.getField().getGraveyard().size();
			if(gSize>0){
				if( p.getField().getGraveyard().get(gSize-1) instanceof MonsterCard ){
					g.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+ p.getField().getGraveyard().get(gSize-1).getName()+ ".png"));
				}
				else{
					String spellname = p.getField().getGraveyard().get(gSize-1).getName();
					g.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+spellname+".jpg"));
				}
				g.setText(p.getField().getGraveyard().get(gSize-1).getName());
			}
			
		}
		
		public void updateDeckSize(){
			if(player1.getField().getDeck().getDeck().isEmpty()){
				deck1.setIcon(null);
			}
			else{
				deck1.setText(player1.getField().getDeck().getDeck().size() + "");
			}
			if(player2.getField().getDeck().getDeck().isEmpty()){
				deck2.setIcon(null);
			}
			else{
				deck2.setText(player2.getField().getDeck().getDeck().size() + "");
			}
		}
		
		public void updatePlayerScoreAndGameStatus(){
			currentPlayer.setText("Player Turn: " + board.getActivePlayer().getName());
			currentPhase.setText("Phase: " + board.getActivePlayer().getField().getPhase());
			player1Info.setText(player1.getName() + ":" + player1.getLifePoints());
			player2Info.setText(player2.getName() + ":" + player2.getLifePoints());
		}
		
		/*public void setImage(JLabel in,JButton button){
			switch(button.getName()){
			case "Card Destruction" : in.set
			case "Change Of Heart" : ; break;
			case "Dark Hole" : ;break;
			case "Graceful Dice" : ; break;
			case "Harpie's Feather Duster" : ; break;
			case "Heavy Storm" : ; break;
			case "Mage Power" : ; break;
			case "Monster Reborn" : ; break;
			case "Pot of Greed" : ; break;
			case "Raigeki" : 
			}
		}*/

	


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == startGame){
			return;
		}
		
		if(handButtons1 != null){
			for(int i = 0 ; i<handButtons1.length; i++){
				if(e.getSource() == handButtons1[i]){
					Card c = player1.getField().getHand().get(i);
					cardInfo1.setText(getCardInfo(c));
					card1.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+c.getName()+".png"));
					
					
				}
			}
		}
		
		if(handButtons2 != null){
			for(int i = 0 ; i<handButtons2.length; i++){
				if(e.getSource() == handButtons2[i]){
					Card c = player2.getField().getHand().get(i);
					cardInfo2.setText(getCardInfo(c));
					card2.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+c.getName()+".png"));
				}
			}
		}
		
		for(int i = 0; i<player1.getField().getMonstersArea().size(); i++){
			if(e.getSource() == monstersButtons1[i]){
				Card c = player1.getField().getMonstersArea().get(i);
				cardInfo1.setText(getCardInfo(c));
				card1.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+c.getName()+".png"));
			}
		}
		
		for(int i = 0; i<player2.getField().getMonstersArea().size(); i++){
			if(e.getSource() == monstersButtons2[i]){
				Card c = player2.getField().getMonstersArea().get(i);
				cardInfo2.setText(getCardInfo(c));
				card2.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+c.getName()+".png"));
			}
		}
		for(int i = 0; i<player1.getField().getSpellArea().size(); i++){
			if(e.getSource() == monstersButtons1[i]){
				Card c = player1.getField().getSpellArea().get(i);
				cardInfo1.setText(getCardInfo(c));
				card1.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+c.getName()+".png"));
			}
		}
		for(int i = 0; i<player2.getField().getSpellArea().size(); i++){
			if(e.getSource() == monstersButtons1[i]){
				Card c = player1.getField().getSpellArea().get(i);
				cardInfo1.setText(getCardInfo(c));
				card1.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Working Game\\Yu-Gi-Oh\\Cards Images Database\\"+c.getName()+".png"));
			}
		}
	}
	
	public String getCardInfo(Card c){
		if(c instanceof MonsterCard){
			MonsterCard m = (MonsterCard) c;
			return ("<html>Card Info:" + "<br>Name: " + m.getName() + 
					"<br>Attack Points:" + m.getAttackPoints() +
					"<br>Defense Points:" + m.getDefensePoints() +
					"<br>Level:" + m.getLevel() + 
					"<br>Mode:"+ m.getMode() + "</html>");
		}
		else{
			return("<html>Card Info:" + "<br>Name: " + c.getName()
					+ "<br>Description: " + c.getDescription() +
					"</html>");
			}
	}
	
	

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
public static void main(String[] args) {
	GUI g = new GUI();
}
}
