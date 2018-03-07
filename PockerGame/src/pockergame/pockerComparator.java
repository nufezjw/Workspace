package pockergame;

import java.util.Comparator;

public class pockerComparator implements Comparator<pocker> {

	@Override
	public int compare(pocker o1, pocker o2) {
		// TODO Auto-generated method stub
		if((o1.getPockerpoint().compareTo(o2.getPockerpoint())==0))
			return o1.getPockerflower().compareTo(o2.getPockerflower());
		else
		    return o1.getPockerpoint().compareTo(o2.getPockerpoint());
	}

}
