package KaeZehra.Controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import KaeZehra.Model.Player;
import KaeZehra.Model.Squad;
import KaeZehra.View.Fantasy;

/**
 * 
 * @author Zehra Punjwani and Kae Dupuy
 *
 */
public class Controller implements ActionListener{
	
	private Fantasy fantasyView;
	private Squad squadModel;
	private Player player;
	
	/**
	 * 
	 * @param fantasyView
	 * @param squadModel
	 */
	public Controller(Fantasy fantasyView, Squad squadModel){ //constructor with two arguments
		this.fantasyView = fantasyView;
		this.squadModel = squadModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //action listener for both the combobox and the buttons
		if(e.getSource() instanceof JComboBox){ //if the action comes from the combobox
			if(!(fantasyView.getPitch() == null) && !(fantasyView.getBench() == null)){
				((Container) fantasyView.getPitch()).removeAll(); // remove all players from the frame
				((Container) fantasyView.getBench()).removeAll();	
			}
			fantasyView.getFrame().revalidate();
			fantasyView.getFrame().repaint();
			fantasyView.createPitch(); //create new pitch
			ArrayList<Integer> list = new ArrayList<Integer>();
			fantasyView.createFormation(list); // create formation required
			fantasyView.benchSubstitutions(list);
		} 
		
		if(e.getSource() instanceof JComboBox && ((JComboBox) e.getSource()).getSelectedItem() == "Select Formation" ){
			if(!(fantasyView.getPitch() == null) && !(fantasyView.getBench() == null)){
				((Container) fantasyView.getPitch()).removeAll(); // remove all players from the frame
				((Container) fantasyView.getBench()).removeAll();
			}
		}
		
		else if(e.getSource() instanceof JButton  ){ // if source is a button
			Object o = e.getSource();
			player = new Player("","","");
    		JFileChooser fileChooser = new JFileChooser();
    		FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, GIF & PNG Images Only", "jpg", "gif", "png");
    	    fileChooser.setFileFilter(fileNameExtensionFilter);
    	    int returnVal = fileChooser.showOpenDialog(fantasyView.getButton());// opens window when button is pressed
    	    if(returnVal == JFileChooser.APPROVE_OPTION) {
    	    	File file = fileChooser.getSelectedFile();
				try {
					ImageIcon image = new ImageIcon(ImageIO.read(file));
					
	    	   		((AbstractButton) e.getSource()).setText("");
	    			((AbstractButton) e.getSource()).setIcon(image); //setting the image to the button 
	    			((AbstractButton) e.getSource()).setDisabledIcon(image);
	    			((AbstractButton) e.getSource()).setEnabled(false);
	    			((AbstractButton) e.getSource()).setBorderPainted(false);
	    			((AbstractButton) e.getSource()).setFocusPainted(false);
	    			String fileName = file.getName().substring(0,1).toUpperCase() + file.getName().substring(1);
	   				String updatedFileName = fileName.substring(0,fileName.lastIndexOf('.')); //getting the name from the file with substrings
	   				player.setName(updatedFileName);
	   				player.setPath(file.getPath());
	   				
				} catch (IOException e2) {
					System.out.println("Incorrect File Type");
				}
    	    }
		}   
	}
	
	/**
	 * 
	 * @return Player
	 */
	public Player getPlayer(){
		return player;
	}
	
	/**
	 * 
	 * @param fantasyView
	 * @return void
	 */
	public void addFantasy(Fantasy fantasyView){ // add view to controller
		this.fantasyView = fantasyView; 
	}
	
	/**
	 * 
	 * @param squadModel
	 * @return void
	 */
	public void addSquad(Squad squadModel){ // add model to controller
		this.squadModel = squadModel;
	}
 }