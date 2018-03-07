package imooctest;

public class courses {
private String ID;
private String Name;
public courses() {
	
}
public courses(String ID,String Name) {
	this.setID(ID);
	this.setName(Name);
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
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
	if (!(obj instanceof courses))
		return false;
	courses other = (courses) obj;
	if (Name == null) {
		if (other.Name != null)
			return false;
	} else if (!Name.equals(other.Name))
		return false;
	return true;
}
}
