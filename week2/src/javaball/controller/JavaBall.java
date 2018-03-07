package javaball.controller;

import javaball.model.RefereeList;
import javaball.model.Season;
import javaball.view.JavaBallGUI;

public class JavaBall {
	/**
	 * The main method
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// initialise model (Season for Matches, RefereeList for Referees)
		Season week = new Season();
		RefereeList refList = new RefereeList();
		
		// initialise controller
		JavaBallController controller = new JavaBallController(week,
				refList);
                
        // initialise view
		JavaBallGUI view = new JavaBallGUI(controller);
		view.setVisible(true);
		
		// pass GUI reference to controller
		controller.setView(view);
	}
}