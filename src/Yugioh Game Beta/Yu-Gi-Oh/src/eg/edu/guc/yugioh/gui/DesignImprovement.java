package eg.edu.guc.yugioh.gui;

import java.awt.EventQueue;

import javax.naming.ldap.Rdn;
import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public  class DesignImprovement {

	private JFrame frmYugioh;
	private static Player p1;
	private static Player p2;
	private static Board b;
	private static boolean created;
	

	
	public static boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		DesignImprovement.created = created;
	}

	private JPanel PanelP1;
	private JTextField txtPlayer_1;
	private JPanel TopPanel;
	private final JTextPane Intro = new JTextPane();
	private JPanel PanelP2;
	private JTextField txtPlayer_2;
	private JLabel LeftPic;
	private JLabel RightPic;
	
  
	public static Player getP1() {
		return p1;
	}

	public static void setP1(Player p1) {
		DesignImprovement.p1 = p1;
	}

	public static Player getP2() {
		return p2;
	}

	public static void setP2(Player p2) {
		DesignImprovement.p2 = p2;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignImprovement window = new DesignImprovement();
					window.frmYugioh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DesignImprovement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmYugioh = new JFrame();
		frmYugioh.setResizable(false);
		frmYugioh.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		frmYugioh.setTitle("Yu-Gi-Oh!");
		frmYugioh.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\images.jpg"));
		frmYugioh.setSize(1485,500);
		frmYugioh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYugioh.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setForeground(Color.RED);
		btnStartGame.setBackground(Color.BLACK);
		btnStartGame.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 26));
		//btnStartGame.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\YuGiOh Cards and Logos\\YuGi.jpg"));
		frmYugioh.getContentPane().add(btnStartGame, BorderLayout.SOUTH);
		
		JLabel CenterImage = new JLabel("");
		CenterImage.setBackground(Color.BLACK);
		CenterImage.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\th.jpg"));
	    
		frmYugioh.getContentPane().add(CenterImage, BorderLayout.CENTER);
		
		PanelP1 = new JPanel();
		PanelP1.setBackground(Color.BLACK);
		frmYugioh.getContentPane().add(PanelP1, BorderLayout.WEST);
		PanelP1.setLayout(new BorderLayout(0, 0));
		
		txtPlayer_1 = new JTextField();
		txtPlayer_1.setForeground(Color.RED);
		txtPlayer_1.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 18));
		txtPlayer_1.setText("Player1");
		PanelP1.add(txtPlayer_1, BorderLayout.NORTH);
		txtPlayer_1.setColumns(10);
		
		LeftPic = new JLabel("");
		LeftPic.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\tumblr_mra2fgbxRe1sevsk0o1_500.gif"));
		PanelP1.add(LeftPic, BorderLayout.CENTER);
		
		TopPanel = new JPanel();
		TopPanel.setBackground(Color.RED);
		frmYugioh.getContentPane().add(TopPanel, BorderLayout.NORTH);
		Intro.setToolTipText("");
		Intro.setBackground(Color.BLACK);
		Intro.setForeground(Color.LIGHT_GRAY);
		Intro.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		Intro.setEditable(false);
		Intro.setText("Meet Yugi, an eager young freshman at Domino High School. Yugi and his best friends, Joey, Tristan, and Tea share a love of a cool new game that's sweeping the nation...Duel Monsters! In this card-battling game, \r\nplayers pit different mystical creatures against one another in action-packed, high intensity duels.\r\n");
		TopPanel.add(Intro);
		
		PanelP2 = new JPanel();
		PanelP2.setBackground(Color.BLACK);
		frmYugioh.getContentPane().add(PanelP2, BorderLayout.EAST);
		PanelP2.setLayout(new BorderLayout(0, 0));
		
		txtPlayer_2 = new JTextField();
		txtPlayer_2.setForeground(Color.BLUE);
		txtPlayer_2.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 18));
		txtPlayer_2.setText("Player2\r\n");
		PanelP2.add(txtPlayer_2, BorderLayout.NORTH);
		txtPlayer_2.setColumns(10);
		
		RightPic = new JLabel("");
		RightPic.setIcon(new ImageIcon("C:\\Users\\Mostafa\\Desktop\\GAME-Milestone4\\Yu-Gi-Oh\\YuGiOh Cards and Logos\\tumblr_mra2fgbxRe1sevsk0o1_500.gif"));
		
		PanelP2.add(RightPic, BorderLayout.CENTER);
		
		
			
		
		
		
	}

	public static Board getB() {
		return b;
	}

	public static void setB(Board b) {
		DesignImprovement.b = b;
	}


}

