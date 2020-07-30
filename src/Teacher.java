
/**
 * @author ������
 *
 */
public class Teacher {
	
	public String id;
	public String passWord;
	public String Command;
	public String User;
	public String Attribute;
	public String getAttribute(){
		return Attribute;
	}
	public void setAttribute(String Attribute){
		this.Attribute=Attribute;
	}
	
	public String getUser(){
		return User;
	}
	public void setUser(String User){
		this.User = User;
	}
	public String getCommand(){
		return Command;
	}
	public void setCommand(String Command){
		this.Command = Command;
	}
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	
	public Teacher(String id, String User ,String password , String Command  ) {
	
		this.id = id;
		this.User =User;
		this.passWord = password;
		this.Command = Command;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPassword(String password) {
		this.passWord = password;
	}

	
    


    
    
}