package KaeZehra.Model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 * 
 * @author Zehra Punjwani and Kae Dupuy
 *
 */
public class Squad extends Observable { // class which is observed by the view ( fantasy)
	
	private GoalKeeper goalKeeper1;
	private GoalKeeper goalKeeper2;
	private Defender defender1;
	private Defender defender2;
	private Defender defender3;
	private Defender defender4;
	private Defender defender5;
	private Midfielder midfielder1;
	private Midfielder midfielder2;
	private Midfielder midfielder3;
	private Midfielder midfielder4;
	private Midfielder midfielder5;
	private Striker striker1;
	private Striker striker2;
	private Striker striker3;
	private Set<GoalKeeper> goalkeepers;
	private Set<Defender> defenders;
	private Set<Striker> strikers;
	private Set<Midfielder> midfielders;
	private Player player;
	private Squad squad;
	
	public Squad(){ //constructor calling generated method and telling observer squad has changed
		generated();
		setChanged();
		notifyObservers(squad);
		
	}
	
	/**
	 * 
	 * @return void
	 */
	public void generated(){ //method adding each player to their respective HashSet
		goalkeepers = new HashSet<GoalKeeper>();
		defenders = new HashSet<Defender>();
		midfielders = new HashSet<Midfielder>();
		strikers = new HashSet<Striker>();
		goalkeepers.add(goalKeeper1);
		goalkeepers.add(goalKeeper2);
		defenders.add(defender1);
		defenders.add(defender2);
		defenders.add(defender3);
		defenders.add(defender4);
		defenders.add(defender5);
		midfielders.add(midfielder1);
		midfielders.add(midfielder2);
		midfielders.add(midfielder3);
		midfielders.add(midfielder4);
		midfielders.add(midfielder5);
		strikers.add(striker1);
		strikers.add(striker2);
		strikers.add(striker3);
	}
	
	/**
	 * 
	 * @return Set<GoalKeeper>
	 */
	public Set<GoalKeeper> getGoalKeeperSet(){ //return set of goalkeepers
		return goalkeepers;
	}
	
	/**
	 * 
	 * @return Set<Midfielder>
	 */
	public Set<Midfielder> getMidefielderSet(){
		return midfielders;
	}
	
	/**
	 * 
	 * @return Set<Striker>
	 */
	public Set<Striker> getStrikerSet(){
		return strikers;
	}
	
	/**
	 * 
	 * @return Set<Defender>
	 */
	public Set<Defender> getDefenderSet(){
		return defenders;
	}
	
	/**
	 * 
	 * @param ID
	 * @return Player
	 */
	public Player searchPlayer(String ID){ //search player by ID
		if(ID == player.getID()){
			return player;
		}
		return null;
	}
}