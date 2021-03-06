/**
 * Advanced Programming AE1
 * * @author Jianwen ZHOU 2301457Z
 *
 */
public class APSpec1 {
	public static void main(String[] args) {
		Intersection intersection=new Intersection(10,20);	
		Hgenerator we=new Hgenerator(intersection,"-",200,"WE",1);
		Vgenerator ns=new Vgenerator(intersection,"o",300,"NS",1);
		Draw draw=new Draw(intersection);
		draw.start();
		we.start();
		ns.start();
		try {
			draw.join();
			we.join();
			ns.join();
		}catch(InterruptedException e) {}
		}
}
