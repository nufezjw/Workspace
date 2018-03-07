
public class RunnableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nThread=2;
		Thread[] threads=new Thread[nThread];
		for(int i=0;i<nThread;i++) {
		PointlessPrint p=new PointlessPrint("I am thread"+i,10);
		threads[i]=new Thread(p);
		threads[i].start();
		}
	}

}
