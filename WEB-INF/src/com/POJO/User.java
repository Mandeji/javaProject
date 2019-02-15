import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	
	//##############Properties and getter setter#########
	
	

public class User {

	private int userId;
	private String name;
	private String rollNo;
	private String password;
	private String phone;
	private String address;
	private boolean isStudent;    //accounType 
	private boolean isConfirmed;
	private boolean isBlock;
	private boolean isNotified;	
	
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String name, String rollNo, String password, String phone, String address,
			boolean isStudent, boolean isConfirmed, boolean isBlock, boolean isNotified) {
		super();
		this.userId = userId;
		this.name = name;
		this.rollNo = rollNo;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.isStudent = isStudent;
		this.isConfirmed = isConfirmed;
		this.isBlock = isBlock;
		this.isNotified = isNotified;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isStudent() {
		return isStudent;
	}
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	public boolean isConfirmed() {
		return isConfirmed;
	}
	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	public boolean isBlock() {
		return isBlock;
	}
	public void setBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}
	public boolean isNotified() {
		return isNotified;
	}
	public void setNotified(boolean isNotified) {
		this.isNotified = isNotified;
	}
	
//##################### Constructor for single parameter###########
	public User(String rollNo){
		this.rollNo = rollNo;
	}
//##################### Constructor for double parameters############3333

	public User(String rollNo,String password){
		this.rollNo = rollNo;
		this.password = password;
	}


	public boolean confirmUser() {
		
		String Query="update user set confirm_status=1 where usr_rollno=?";
		try {
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(Query);
			ps.setString(1, rollNo);
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			
			}
		return false;	
	
	}
	
	
	public boolean blockUser() {
		
		String Query="update user set block_status=1 where usr_rollno=?";
		try {
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(Query);
			ps.setString(1, rollNo); // Add rollNo;
			ps.executeQuery();
			return true;
		}
		catch(SQLException e) {
			return false;
			}
	}
	
	
	
	//#######login and sign up########
	
	public boolean LoginUser(String rollNo,String password) {
		
		//takes rool no and pass and return true fo succesfull login
		
		boolean flag=false;
		Connection connect=MyConnection.getConnection();
		String Fetch_Query="select * from user where usr_rollno=? and usr_password=?";
		
		try {
			//Statement state=connect.createStatement();
			PreparedStatement statement=connect.prepareStatement(Fetch_Query);
			statement.setString(1, rollNo);
			statement.setString(2, password);
			ResultSet set=statement.executeQuery();
			while(set.next()) {
				
				if((set.getString(2)).equals(Roll) && (set.getString(4)).equals(Password)){
					flag=true;//Want to Assign Instance Variable Here @Akash
					
				}
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
		
	}
	

	//##################Constructor for Four Parameter###########33

	public User(String name,String rollNo,String password,int AccountType){
		this.name = name;
		this.rollNo = rollNo;
		this.password = password;
		this.AccountType = AccountType;		
	}
	
	
	
	public boolean signUpUser(String name,String rollNo,String password,int AccountType) {
		boolean flag=false;
		//takes all data and returns true for sucessfull sign up
		
		Connection connect=MyConnection.getConnection();
		String InsertQuery="insert into user(usr_rollno,usr_password,usr_name,usr_account_type) values(?,?,?,?)";
		try {
			//Statement state=connect.createStatement();
			PreparedStatement statement=connect.prepareStatement(InsertQuery);
			statement.setString(1,rollNo);
			statement.setString(2,password);
			statement.setString(3,name);
			statement.setInt(4,AccountType);
			
			int t=statement.executeUpdate();
			if(t==1) {
				flag=true;
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return flag;
	}
	
	
	
	
	
	
	
	
	public boolean isAdmin() {
		boolean flag=false;
		//takes rollnumber and returns true if "is an admin" or false if " is not an admin"
		Connection connect=MyConnection.getConnection();
		String Fetch_Query="select * from user where usr_rollno=?";
		
		try {
			//Statement state=connect.createStatement();
			PreparedStatement statement=connect.prepareStatement(Fetch_Query);
			statement.setString(1, rollNo);
		
			ResultSet set=statement.executeQuery();
			while(set.next()) {
				
				if((set.getInt(8))==1){
					flag=true;
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
		
	
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	


	// INPUT -> editProfile (String usr_name, int usr_rollno, String usr_phone, String usr_address)
	// OUTPUTS boolean -> 'true' if action is successful else 'false'
	// This method updates the params (which it gets as input)
	// The updates will be directly made into the database 'user' for a given roll no.

	public boolean editProfile(){
		String SQL_UPDATE_ALL = "update user set usr_name=?, usr_phone=?, usr_address=? where usr_rollno=?";		
		try {
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(SQL_UPDATE_ALL);
			ps.setString(1, name);
			ps.setString(2, no);
			ps.setString(3, address);
			ps.setString(4, rollNo);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
	}


	// INPUT -> changePassword (int usr_rollno, String oldPassword, String newPassword, String confirmPassword)
	// OUTPUTS boolean -> 'true' if action is successful else 'false'
	// This method updates the password which it gets as input
	// The update will only be made if oldPassword == password (currently in database) AND newPassword == confirmPassword !
	// The updates will be directly made into the database 'user' for a given roll no.
	
	public boolean changePassword(String newPassword) {
		String SQL_UPDATE_PASSWORD = "update user set usr_password=? where usr_rollno=?";
		
		try {
			PreparedStatement ps = MyConnection.getConnection().prepareStatement(SQL_UPDATE_PASSWORD);
			ps.setString(1, newPassword);
			ps.setInt(2, rollNo);
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	
		
		return false;
		
	}

	
	// INPUT -> changeNotifyStatus(int rollNo) - only takes in rollNo of user whose notify status needs to be changed
	// OUTPUTS boolean -> 'true' if action is successful else 'false'
	// This method updates the notify param on database for the usr_rollno which it gets as input
	// The method updates value of notify=0 if its 1 and notify=1 if its 0.
	// notify=0 means notifications are blocked by that user otherwise notify=1 means we have to send notis to that user
	// The updates will be directly made into the database 'user' for a given roll no.

	public boolean changeNotifyStatus(){
		String SQL_UPDATE_NOTIFY = "update user set notify=? where usr_rollno=?";
		int notify;		
		
			try {	
				if(this.isNotified()==true)	notify = 1;				
				else notify = 0;

				PreparedStatement ps = MyConnection.getConnection().prepareStatement(SQL_UPDATE_NOTIFY);
				ps.setInt(1, notify);
				ps.setInt(2, rollNo);
				ps.executeQuery();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}		
		
	}


	
	
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	
	
	
	
	
	

}
