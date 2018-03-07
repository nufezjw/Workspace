package javaball.model;

import javaball.enums.Location;
import javaball.enums.MatchLevel;

public class Match {
    /** The week when a match is held also serves as an ID */
    private int week;

    /** The area where the match is held. */
    private Location area;
    
    /** The level of the match */
    private MatchLevel level;
    
    /** Suitable referees for the match */
    private Referee[] suitableReferees;
    
	/**
	 * Instantiates a new Match given a calendar week, area the match is held
	 * in, and a level of the match
	 * @param week the number of the calendar match is held in (1-52)
	 * @param level of the match (Junior or Senior)
	 * @param area that the match is held in
	 */
	public Match(int week, MatchLevel level, Location area) {
		this.week = week;
		this.level = level;
		this.area = area;
		
		// Array to store suitable referees
		this.suitableReferees = new Referee[2];
	}

	/**
	 * Returns the week number which is also match ID
	 * @return the week number
	 */
	public int getWeek() {
		return week;
	}

	/**
	 * Returns the area where the match is held
	 * @return the area
	 */
	public Location getArea() {
		return area;
	}

	/**
	 * Returns match level (i.e. Senior or Junior)
	 * @return the match level
	 */
	public MatchLevel getLevel() {
		return level;
	}

	/**
	 * Set the area where match is held
	 * @param area where match is to be held
	 */
	public void setArea(Location area) {
		this.area = area;
	}
    
	/**
	 * Set match level (i.e. Senior or Junior
	 * @param level the level of the match
	 */
	public void getLevel(MatchLevel level) {
		this.level = level;
	}
    
    /**
     * Populates the match's suitable referees array
     * @param referees, an array containing the two suitable referees
     */
	public void setReferees(Referee[] referees) {
		suitableReferees = referees;
	}
    
    /**
     * Returns a string representation of the contents of the specified match.
     * The format is as follows "2 Junior North Dave Gray Tim Toms", where 2 is
     * the week number, Junior is the level of the match, Dave Gray is the name 
     * of the first suitable referee and Tim Toms is the name of the second 
     * suitable referee.
     * @return a string representation of a match
     */
	@Override
	public String toString() {
		// Combine first and last names
		String nameRef1 = suitableReferees[0].getFirstName() + " "
				+ suitableReferees[0].getLastName();
		String nameRef2 = suitableReferees[1].getFirstName() + " "
				+ suitableReferees[1].getLastName();
		
		// Combine all match details into a string
		String match = String.format("%-5d %-7s %-8s %-17s %-17s%n",
				week, level, area, nameRef1, nameRef2);
		
		// Return one line match report
		return match;
	}
}