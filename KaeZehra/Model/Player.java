package KaeZehra.Model;

import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 * 
 * @author Zehra Punjwani and Kae Dupuy
 *
 */
public class Player implements ImageObserver {

	protected String name;
	protected String ID;
	protected String path;
	
	/**
	 * 
	 * @param name
	 * @param ID
	 * @param path
	 */
	public Player(String name, String ID, String path) { //constructor for Player
		this.name = name;
		this.ID = ID;
		this.path = path;
		path = "None";
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getName(){ 
		return name; //get name
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getID(){
		return ID;//get ID
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getPath(){
		return path; // get image path
	}
	
	/**
	 * 
	 * @param name
	 * @return void
	 */
	public void setName(String name){
		this.name = name; //set name
	}
	
	/**
	 * 
	 * @param ID
	 * @return void
	 */
	public void setID(String ID){
		this.ID = ID; //set ID
	}
	
	/**
	 * 
	 * @param path
	 * @return void
	 */
	public void setPath(String path){
		this.path = path; // set path
	}
	
	/**
	 * 
	 * @return String
	 */
	public String toString(){
		return "Player: " + name + ", " + ID;
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return false;
	}	
}
