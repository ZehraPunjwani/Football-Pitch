package KaeZehra.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import KaeZehra.Controller.Controller;
import KaeZehra.Model.Defender;
import KaeZehra.Model.GoalKeeper;
import KaeZehra.Model.Midfielder;
import KaeZehra.Model.Player;
import KaeZehra.Model.Squad;
import KaeZehra.Model.Striker;

/**
 * 
 * @author Zehra Punjwani and Kae Dupuy
 *
 */
public class Fantasy implements Observer{
	
	private int TOTAL_DEFENDER  = 5;
	private int TOTAL_MID = 5;
	private int TOTAL_STRIKER = 3;
	private Defender defender;
	
	private JFrame fantasyFrame;
	private JComboBox comboBox;
	private JTextField jtName;
	private JPanel playerPanel;
	private String value;
	private JPanel formationPanel;
	private JPanel pitch;
	private JPanel bench;
	private JPanel goalkeeperPanel;
	private JPanel defenderPanel;
	private JPanel midfielderPanel;
	private JPanel strikerPanel;
	private JButton addPlayer;
	private Squad squad;
	private Controller controller;
	private Midfielder midfielder;
	private Striker striker;
	private GoalKeeper goalkeeper;
	private ArrayList<JPanel> jpanels;
	
	
	public  Fantasy(){
		fantasyFrame = new JFrame("Fantasy Football");
		
		fantasyFrame.setDefaultCloseOperation(fantasyFrame.EXIT_ON_CLOSE);
		goalkeeper = new GoalKeeper("Goalkeeper","ID","None"); // initialising players
		striker = new Striker("Striker","ID","None");
		midfielder = new Midfielder("Midfielder", "ID","None");
		defender = new Defender("Defender","ID","None");
		squad = new Squad();
		fantasyFrame.setLayout(new BorderLayout());
		fantasyFrame.setMinimumSize(new Dimension(800,700));
		jpanels = new ArrayList<JPanel>();
		
		String[] combinations = {"Select Formation", "4-4-2", "4-3-3", "3-5-2", "5-3-2", "3-4-3", "4-5-1"}; // setting combo box options
		fantasyFrame.setLayout(new BorderLayout());
		comboBox = new JComboBox(combinations);
		comboBox.setSelectedIndex(0);
		comboBox.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)) ;
		
		formationPanel = new JPanel(new BorderLayout());
		fantasyFrame.add(comboBox, BorderLayout.NORTH);
		fantasyFrame.add(formationPanel);
		fantasyFrame.setResizable(false);
		fantasyFrame.setVisible(true);
		fantasyFrame.pack();
	}
	
	/**
	 * 
	 * @param list
	 * @return void
	 */
	public void createFormation(ArrayList<Integer> list){ //method to create the formation selected
		value = (String) comboBox.getSelectedItem();
		for(int i = 0; i < value.length();i++){
			if(i%2 == 0){
				int b = Character.getNumericValue((value.charAt(i))); //gets the integers from the list
				list.add(b);
			}	
		}
		createPlayerComponent(goalkeeper.getName(), goalkeeper.getID() , goalkeeper.getPath()); //creates goalkeeper 
		goalkeeperPanel.add(playerPanel); 
		jtName.setText(goalkeeper.getName());
		for(int i = 1 ; i <= list.get(0); ++i){
			createPlayerComponent(defender.getName(), defender.getID(), defender.getPath()); // creates defender
			defenderPanel.add(playerPanel);
			jtName.setText(defender.getName());
		}
		for(int i = 1 ; i <= list.get(1); ++i){
			createPlayerComponent(midfielder.getName(), midfielder.getID(), midfielder.getPath()); //creates midfielder
			midfielderPanel.add(playerPanel);
			jtName.setText(midfielder.getName());
		}
		for(int i = 1 ; i <= list.get(2); ++i){
			createPlayerComponent(striker.getName(), striker.getID(), striker.getPath()); // creates striker
			strikerPanel.add(playerPanel);
			jtName.setText(striker.getName());
		}
	}

	/**
	 * 
	 * @param name
	 * @param ID
	 * @param path
	 * @return void
	 */
	 public void createPlayerComponent(String name, String ID , String path){ //method to create each player on frame
		 playerPanel = new JPanel(new BorderLayout(2,1));
		 playerPanel.setName(ID);
		 jpanels.add(playerPanel);
		 addPlayer = new JButton("+");
		 jtName = new JTextField();
		 jtName.setHorizontalAlignment(JTextField.CENTER);
		 playerPanel.add(addPlayer, BorderLayout.CENTER);
		 addPlayer.addActionListener(controller);
		 playerPanel.add(jtName, BorderLayout.SOUTH);
		 jtName.setFont(new Font("Arial", Font.BOLD, 10));
		 playerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	 }

	 /**
	  * 
	  * @return void
	  */
	public void createPitch(){ // method creating panels on frame
		pitch = new JPanel(new GridLayout(4,1));
		bench = new JPanel(new GridLayout(1,4));
		formationPanel.add(pitch, BorderLayout.CENTER);
		formationPanel.add(bench, BorderLayout.SOUTH);
		goalkeeperPanel = new JPanel(new FlowLayout());
		defenderPanel = new JPanel(new FlowLayout());
		midfielderPanel = new JPanel(new FlowLayout());
		strikerPanel = new JPanel(new FlowLayout());
		pitch.add(goalkeeperPanel);
		pitch.add(defenderPanel);
		pitch.add(midfielderPanel);
		pitch.add(strikerPanel);
	}
	
	/**
	 * 
	 * @param list
	 * @return void
	 */
	public void benchSubstitutions(ArrayList<Integer> list){ //method for the bench
		for(int i = 0 ; i < TOTAL_DEFENDER - list.get(0) ; ++i){
			createPlayerComponent(defender.getName(), defender.getID(), defender.getPath());
			bench.add(playerPanel);
			jtName.setText(defender.getName());
		}
		for(int i = 0; i < TOTAL_MID - list.get(1) ; ++i){
			createPlayerComponent(midfielder.getName(), midfielder.getID(), midfielder.getPath());
			bench.add(playerPanel);
			jtName.setText(midfielder.getName());
		}
		for(int i = 0; i < TOTAL_STRIKER - list.get(2); ++i){
			createPlayerComponent(striker.getName(), striker.getID(), striker.getPath());
			bench.add(playerPanel);
			jtName.setText(striker.getName());
		}
		createPlayerComponent(goalkeeper.getName(), goalkeeper.getID() , goalkeeper.getPath());
		bench.add(playerPanel);
		bench.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		jtName.setText(goalkeeper.getName());
	}
	
	/**
	 * 
	 * @return Component
	 */
	public Component getBench(){
		return bench;
	}
	
	/**
	 * 
	 * @return Component
	 */
	public Component getPitch(){
		return pitch;
	}
	
	/**
	 * 
	 * @return JButton
	 */
	public JButton getButton(){
		
		return addPlayer;
	}
	
	/**
	 * 
	 * @return JTextComponent
	 */
	public JTextField getJTName(){
		return jtName;
	}
	
	/**
	 * 
	 * @return Component
	 */
	public Component getComboBox(){
		return comboBox;
	}
	
	/**
	 * 
	 * @param p
	 * @return JPanel
	 */
	public JPanel playerList(Player p){
		for(JPanel j : jpanels){
			if(j.getName() == p.getName()){
				return j;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param squad
	 * @return void
	 */
	public void addSquad(Squad squad){
		this.squad = squad;
	}
	
	/**
	 * 
	 * @return JFrame
	 */
	public JFrame getFrame(){
		return fantasyFrame;
	}

	/**
	 * 
	 * @return JPanel
	 */
	public JPanel getPlayerPanel(){
		return playerPanel;
	}

	/**
	 * 
	 * @param controller
	 * @return void
	 */
	public void addController(Controller controller){ // adding listener to combobox
		this.controller = controller;
		
		comboBox.addActionListener(controller);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		
	}
}