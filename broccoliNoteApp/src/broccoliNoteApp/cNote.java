package broccoliNoteApp;

//import java.sql.Date;
//import java.time.LocalDateTime;  
//import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;

public class cNote
{
	private String currentDate;
	private String strTitle;
    private String strNoteBody;
    private int userID; //Foreign  key from user Table
    private int noteID; //Primary Key for note Table
    private int intRecent;

    public cNote() 
    {
        this.strNoteBody = "";
        this.currentDate = LocalDate.now().toString();
        this.strTitle = "";
        this.intRecent = 1;
    }
    
    public cNote(String newDate, String newTitle, String newBody, int NoteID, int Recent) 
    {
        this.strNoteBody = newBody;
        this.currentDate = LocalDate.now().toString();
        this.strTitle = newTitle;
        this.noteID = NoteID;
        this.intRecent = Recent;
    }
    
    public void setTitle(String title)
    {
        this.strTitle = title;
    }
    
    public void setNote(String note) 
    {
        this.strNoteBody = note;
    }
   
    public String getNote() {
        return strNoteBody;
    }

    public String getTitle()
    {
        return strTitle;
    }
    
    public void setDate()
    {
    	this.currentDate = LocalDate.now().toString();
    }
    public void setDate(String newDate)
    {
    	this.currentDate = newDate;
    }
    
    public String getDate()
    {
    	return this.currentDate.toString();
    }
    
    public void setUserID(int userID)
    {
    	//Forgien key from usertable
    	this.userID=userID;
    }
    
    public int getUserID()
    {
    	//Forgien key from usertable
    	return this.userID;
    }
    
    public void setNoteID(int noteID)
    {
    	//Primary key for noteTable
    	this.noteID = noteID;
    }
    
    public int getNoteID()
    {
    	//Primary key for noteTable
    	return this.noteID;
    }
    
    public int getRecent()
    {
    	return this.intRecent;
    			
    }
    public int setRecent(int iRecent)
    {
    	return this.intRecent = iRecent;		
    }
    
}
