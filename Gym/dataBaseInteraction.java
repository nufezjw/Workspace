import java.sql.*;
public class dataBaseInteraction {
private Connection connection;
public dataBaseInteraction() {
	
}

// Method getConnection is used to connect the database
public void getConnection() {
final String DataBaseName="postgres";
final String USER="postgres";
final String PASS="2301457";
try {
	connection=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres",USER,PASS);
}catch(SQLException e) {
	System.err.println("Connection Failed!");
	e.printStackTrace();
	return;
}
if(connection !=null) {
	System.out.println("Connection successful");
}else {
	System.err.println("Failed to make connection!");
}
}

//Method closeConnecton is used to close the connections
public void closeConnection() {
try {
	connection.close();
	System.out.println("Connection closed");
	}
	catch (SQLException e) {
	e.printStackTrace();
	System.out.println("Connection could not be closed ¨C SQL exception");
	}
}

//the method executeMethod is used to execureQuery commands
public ResultSet executeMethod(String sql) {
Statement stmt=null;
ResultSet rs = null;
//String query="SELECT*FROM gym.course";
try {
	stmt=connection.createStatement();
	rs=stmt.executeQuery(sql);
	}
catch(SQLException e) {
	e.printStackTrace();
//	System.err.println("err executing query"+query);
	}
	return rs;

}

//executeUpdate to  execute UPDATE, INSERT or DELETE commands.   
public int executeMethod1(String sql) {
Statement stmt=null;
int lines=0;
//String query="SELECT*FROM gym.course";
try {
	stmt=connection.createStatement();
	lines=stmt.executeUpdate(sql);
	}
catch(SQLException e) {
	e.printStackTrace();
//	System.err.println("err executing query"+query);
	}
	return lines;
}
}
