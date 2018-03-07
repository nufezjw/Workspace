package imooctest;

import java.util.Comparator;

public class StudentComparator implements Comparator<student>{



@Override
public int compare(student o1, student o2) {
	// TODO Auto-generated method stub
	return o1.getName().compareTo(o2.getName());
}
}