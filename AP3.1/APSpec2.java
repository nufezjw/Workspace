/**
 * Advanced Programming AE1
 * * @author Jianwen ZHOU 2301457Z
 *
 */
public class APSpec2 {
	public static void main(String[] args) {
		Intersection intersection=new Intersection(10,20);
		//four car generators from different directions
		HorizontalGenerator we=new HorizontalGenerator(intersection,200,"WE",2);
		HorizontalGenerator ew=new HorizontalGenerator(intersection,300,"EW",2);
		VerticalGenerator ns=new VerticalGenerator(intersection,200,"NS",2);
		VerticalGenerator sn=new VerticalGenerator(intersection,250,"SN",2);
		Draw draw=new Draw(intersection);
	
		draw.start();
		we.start();
		ew.start();
		ns.start();
		sn.start();
		
		try {
			draw.join();
			we.join();
			ew.join();
			ns.join();
			sn.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		//use to statistics class to print the report to the console
		System.out.println("Report Part: ");
		Statistics statisticsWE=new Statistics(we.getDirection(),we.getCarList(),we.getOverallTime());
		statisticsWE.report();
		
		Statistics statisticsEW=new Statistics(ew.getDirection(),ew.getCarList(),ew.getOverallTime());
		statisticsEW.report();
		
		Statistics statisticsNS=new Statistics(ns.getDirection(),ns.getCarList(),ns.getOverallTime());
		statisticsNS.report();
		
		Statistics statisticsSN=new Statistics(sn.getDirection(),sn.getCarList(),sn.getOverallTime());
		statisticsSN.report();
		
	}
}
