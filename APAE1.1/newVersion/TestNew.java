package newVersion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestNew {
	public static class Car{
		private int x;
		private int y;
		private ReentrantLock gridlock=new ReentrantLock();
		private Condition occupied=gridlock.newCondition();
		
		public void horizontal(int x,int y) {
			
			
		}
	}
}
