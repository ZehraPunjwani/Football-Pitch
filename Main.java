import KaeZehra.Controller.Controller;
import KaeZehra.Model.Squad;
import KaeZehra.View.Fantasy;

/**
 * 
 * @author Zehra Punjwani and Kae Dupuy
 *
 */
public class Main {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Fantasy fantasyView = new Fantasy();
		Squad squadModel = new Squad();
		squadModel.addObserver(fantasyView);
		Controller controller = new Controller(fantasyView, squadModel);
		controller.addSquad(squadModel);
		controller.addFantasy(fantasyView);
		
		fantasyView.addController(controller);
		
		
				
	}
		
}
	

