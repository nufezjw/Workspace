package imooctest;

import java.util.HashSet;
import java.util.Set;

public class student implements Comparable<student>{
private String ID;
private String Name;
public Set <courses>courses;
public student(String ID,String Name) {
	this.ID=ID;
	this.Name=Name;
	this.courses=new HashSet<courses>();
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Set getCourses() {
	return courses;
}
public void setCourses(Set courses) {
	this.courses = courses;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Name == null) ? 0 : Name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof student))
		return false;
	student other = (student) obj;
	if (Name == null) {
		if (other.Name != null)
			return false;
	} else if (!Name.equals(other.Name))
		return false;
	return true;
}
@Override
public int compareTo(student o) {
	// TODO Auto-generated method stub
	return this.getID().compareTo(o.getID());//比较参数的id和当前对象的id;
}

}
