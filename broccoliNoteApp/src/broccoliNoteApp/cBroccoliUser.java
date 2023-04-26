package broccoliNoteApp;

import java.util.Scanner;

public class cBroccoliUser
{
	private int UserID;
	private String Username;
	private String strPassword;
	
	public cBroccoliUser(String uName, String pWord)
	{
		this.strPassword = pWord;
		this.Username = uName;
	}
	
	public cBroccoliUser(String uName, String pWord, int ID)
	{
		this.strPassword = pWord;
		this.Username = uName;
		this.UserID = ID;
	}
	
	public cBroccoliUser()
	{
		// TODO Auto-generated constructor stub
	}

	public String getUsername()
	{
		return this.Username;
	}
	
	public String getPassword()
	{
		return this.strPassword;
	}
	
	public int getUserID()
	{
		//when database is implemented userID will be randomly generated and stored in database
		return this.UserID;
	}
	
	public void setUsername(String Name)
	{
		this.Username = Name;
	}
	
	public void setPassword(String Password)
	{
		this.strPassword = Password;
	}
	
	public void setUserID(int ID)
	{
		//when database is implemented userID will be incrementally generated and stored in database
		//Primary Key
		this.UserID = ID;
	}
}
