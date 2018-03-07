import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random r=new Random();
		
		System.out.println(r.nextInt(2));
		Random random=new Random();
		int num=random.nextInt(20);
		Count c = new Count(false, 0);
		GenerateCar vehicle=new GenerateCar(0,num,c);
	
		int nrows=10;
		int ncols=21;
		
		Road road=new Road(nrows,ncols,vehicle,c);
		vehicle.start();
		road.start();

	}


	
	
}
