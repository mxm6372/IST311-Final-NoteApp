package broccoliNoteApp;

public class cTags
{
	private int tagID,
				noteID,
				userID;
	private String tagText;
	
	public cTags(int tagID, int newNoteID, int newUserID, String newText)
	{
		// TODO Auto-generated constructor stub
		this.tagID = tagID;
		this.noteID = newNoteID;
		this.userID = newUserID;
		this.tagText = newText;
	}
	
	public int getTagID()
	{
		return this.tagID;
	}
	public int getNoteID()
	{
		return this.noteID;
	}
	public int getUserID()
	{
		{
			return this.userID;
		}
	}
	public String getTagText()
	{
		return this.tagText;
	}
	
	public void setTagID(int ID)
	{
		this.tagID = ID;
	}
	public void setNoteID(int ID)
	{
		this.noteID = ID;
	}
	public void setUserID(int ID)
	{
		this.userID = ID;
	}
	public void setTagText(String tagText)
	{
		this.tagText = tagText;
	}
	
	
	
			
}
