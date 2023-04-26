package broccoliNoteApp;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class cDBconnection
{
	static final String DATABASE_URL="jdbc:ucanaccess://E:/broccoliNoteApp/src/broccoliNoteApp/BroccoliDatabase.accdb";
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	PreparedStatement insertNew = null;
	PreparedStatement updateUserSQL = null;

	public cDBconnection()
	{
		try 
		{
			//SQL
				//System.out.println("Starting database Connection");
			//establish connection
			connection = DriverManager.getConnection(DATABASE_URL);
				//System.out.println("Database Connection Made");
			
			//create SQL
			statement = connection.createStatement();
			String strSQL = "Select * from User";
			resultset = statement.executeQuery(strSQL);
				//System.out.println("Statement is Executed");
			
			while(resultset.next())
			{
//				JOptionPane.showMessageDialog(null, resultset.getString(2) + " " + resultset.getString(3));
			}

		} catch (SQLException sqlex)
		{
			JOptionPane.showMessageDialog(null, sqlex.getMessage());
		}
			
	}
	public int addNewUser(cBroccoliUser newUser)
	{
		int results = 0;
			
		String strSQL = "Insert into User (Username, Password) ";
		strSQL += "Values(?,?)";
		
		try
		{	
			insertNew = connection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
			insertNew.setString(1, newUser.getUsername());
			insertNew.setString(2, newUser.getPassword());
			
			results = insertNew.executeUpdate();
			
			if (results == 1)
			{
				JOptionPane.showMessageDialog(null, "Insert Succsessful");
			}
			else {JOptionPane.showMessageDialog(null, "Insert Unsuccsessful");}
			
		} catch (SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage());}
		
		return results;
	}
	public int addNewNote(cNote newNote)
	{
		int results = 0;
		
		String strSQL = "Insert into Notes (userID, noteDate, noteTitle, noteBody, noteRecent) ";
		strSQL += "Values(?,?,?,?,?)";

		try
		{	
			insertNew = connection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
			insertNew.setInt(1, newNote.getUserID());
			insertNew.setString(2, newNote.getDate());
			insertNew.setString(3, newNote.getTitle());
			insertNew.setString(4, newNote.getNote());
			insertNew.setInt(5, newNote.getRecent());
			
			results = insertNew.executeUpdate();
			
			if (results == 1)
			{
				JOptionPane.showMessageDialog(null, "Insert Succsessful");
			}
			else {JOptionPane.showMessageDialog(null, "Insert Unsuccsessful");}
			
		} catch (SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage());}
		
		return results;
	}
	public int addNewTag(cTags newTag)
	{
		int results = 0;
		
		String strSQL = "Insert into Tags (tagID, noteID, userID, tagText) ";
		strSQL += "Values(?,?,?,?)";

		try
		{	
			insertNew = connection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
			insertNew.setInt(1, newTag.getTagID());
			insertNew.setInt(2, newTag.getNoteID());
			insertNew.setInt(3, newTag.getUserID());
			insertNew.setString(4, newTag.getTagText());
			
			results = insertNew.executeUpdate();
			
			if (results == 1)
			{
				JOptionPane.showMessageDialog(null, "Insert Succsessful");
			}
			else {JOptionPane.showMessageDialog(null, "Insert Unsuccsessful");}
			
		} catch (SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage());}
		
		return results;
	}

	
	public cBroccoliUser[] RetrieveUsers() throws SQLException
	{
		// TODO Auto-generated method stub
		ArrayList<cBroccoliUser> UserArray = new ArrayList<cBroccoliUser>();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String strSQL = "Select * from User";
			
			ResultSet resultSet = statement.executeQuery(strSQL);
			int x = 0;
			while (resultSet.next())
			{
				//UserArray.add(new cBroccoliUser().setUserID(resultSet.getInt(1)));
				int tempID = resultSet.getInt(1);
				String tempName = resultSet.getString(2);
				String tempPassword = resultSet.getString(3);
				
				UserArray.add(new cBroccoliUser(tempName, tempPassword, tempID));
			}
		}
			catch (SQLException e) { JOptionPane.showMessageDialog(null, resultset.getString(1)); }
			finally 
			{
				try
				{
					statement.close();
				}catch (SQLException sqlex)
				{
					JOptionPane.showMessageDialog(null, sqlex.getMessage());
				}
			}
			
			cBroccoliUser [] users = new cBroccoliUser[UserArray.size()];
			users = UserArray.toArray(users);
			return users;
	}
	public cNote RetrieveNote(int noteID, int userID) throws SQLException
	{
		cNote foundNote = new cNote();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String strSQL = "Select * from Notes WHERE userID = " + userID + " and noteID = " + noteID;
			
			ResultSet resultSet = statement.executeQuery(strSQL);
			int x = 0;
			while (resultSet.next())
			{
				String  newDate,
						newTitle, 
						newBody; 
				
				int  newNoteID, 
					 intRecent;
				
				newNoteID = resultSet.getInt(1);
				newDate = resultSet.getString(3);
				newTitle = resultSet.getString(4);
				newBody = resultSet.getString(5);
				intRecent = resultSet.getInt(6);
				
				foundNote.setDate(newDate);
				foundNote.setNote(newBody);
				foundNote.setRecent(intRecent);
				foundNote.setTitle(newTitle);
				foundNote.setNoteID(newNoteID);
			}
		}
			catch (SQLException e) {JOptionPane.showMessageDialog(null, resultset.getString(1)); }
			finally 
			{
				try
				{
					statement.close();
				}catch (SQLException sqlex)
				{
					JOptionPane.showMessageDialog(null, sqlex.getMessage());
				}
			}
		
		return foundNote;
	}
	public cNote[] RetrieveAllUserNotes(int intID) throws SQLException
	{
		// TODO Auto-generated method stub
		ArrayList<cNote> noteArray = new ArrayList<cNote>();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String strSQL = "Select * from Notes WHERE userID = " + intID;
			
			ResultSet resultSet = statement.executeQuery(strSQL);
			int x = 0;
			while (resultSet.next())
			{
				String  newDate,
						newTitle, 
						newBody; 
				int  NoteID, 
					 intRecent;
				
				NoteID = resultSet.getInt(1);
				newDate = resultSet.getString(3);
				newTitle = resultSet.getString(4);
				newBody = resultSet.getString(5);
				intRecent = resultSet.getInt(6);
				
				noteArray.add(new cNote(newDate, newTitle, newBody,  NoteID, intRecent));
			}
		}
			catch (SQLException e) {JOptionPane.showMessageDialog(null, resultset.getString(1)); }
			finally 
			{
				try
				{
					statement.close();
				}catch (SQLException sqlex)
				{
					JOptionPane.showMessageDialog(null, sqlex.getMessage());
				}
			}
		
			noteArray = sortUserNotesByRecency(noteArray);
		
			cNote [] notes = new cNote[noteArray.size()];
			notes = noteArray.toArray(notes);
			return notes;
	}
	public cTags[] RetriveAllNoteTags(int noteID, int userID) throws HeadlessException, SQLException
	{
		// TODO Auto-generated method stub
		ArrayList<cTags> tagArray = new ArrayList<cTags>();
		
		try
		{
			Statement statement = connection.createStatement();
			
			String strSQL = "Select * from Tags WHERE userID = " + userID + " and noteID = " + noteID;
			
			ResultSet resultSet = statement.executeQuery(strSQL);
			int x = 0;
			while (resultSet.next())
			{
				String newText; 
				int tagID,
					newNoteID,
					newUserID;
				
				tagID = resultSet.getInt(1);
				newNoteID = resultSet.getInt(2);
				newUserID = resultSet.getInt(3);
				newText = resultSet.getString(4);

				
				tagArray.add(new cTags(tagID, newNoteID, newUserID,  newText));
			}
		}
			catch (SQLException e) { JOptionPane.showMessageDialog(null, resultset.getInt(1)); }
			finally 
			{
				try
				{
					statement.close();
				}catch (SQLException sqlex)
				{
					JOptionPane.showMessageDialog(null, sqlex.getMessage());
				}
			}
			
			cTags [] tags = new cTags[tagArray.size()];
			tags = tagArray.toArray(tags);
			return tags;
	}

	public ArrayList<cNote> sortUserNotesByRecency(ArrayList<cNote> noteArray)
	{
		ArrayList<cNote> sortedList = new ArrayList<cNote>();
		
		for (int first = 0; first < noteArray.size(); first++)
		{
			for (int second = 0; second < noteArray.size(); second++)
			{
				if(noteArray.get(second).getRecent() == first)
					sortedList.add(noteArray.get(second));
			}
		}
		
		return sortedList;
	}
	

	public int updateTags(cTags updatedTag)
	{
		int results = 0;
		
		//PreparedStatement insertNewEmployee = null;
		String strSQL = "Update Tags SET tagText = ? " ;
		strSQL += "WHERE tagID = ? AND userID = ? AND noteID = ?";
		
		//JOptionPane.showMessageDialog(null, strSQL);
		try
		{	
			updateUserSQL = connection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
			updateUserSQL.setString(1, updatedTag.getTagText());
			updateUserSQL.setInt(2, updatedTag.getTagID());
			updateUserSQL.setInt(3, updatedTag.getUserID());
			updateUserSQL.setInt(4, updatedTag.getNoteID());

			
			results = updateUserSQL.executeUpdate();
			
			if (results == 1)
			{
				JOptionPane.showMessageDialog(null, "Insert Succsessful");
			}
			else {JOptionPane.showMessageDialog(null, "Insert Unsuccsessful");}
			
		} catch (SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage());}
		finally
		{
			try 
			{
				statement.close();
			} catch (SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage()); }
		}
		
		return results;
	}
	public int updateUser(cBroccoliUser updateUser)
	{
		int results = 0;
		
		//PreparedStatement insertNewEmployee = null;
		String strSQL = "Update User SET Username = ?, Password = ? " ;
		strSQL += "WHERE userID = ?";
		
		//JOptionPane.showMessageDialog(null, strSQL);
		try
		{	
			updateUserSQL = connection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
			updateUserSQL.setString(1, updateUser.getUsername());
			updateUserSQL.setString(2, updateUser.getPassword());
			updateUserSQL.setInt(3, updateUser.getUserID());
			
			results = updateUserSQL.executeUpdate();
			
			if (results == 1)
			{
				JOptionPane.showMessageDialog(null, "Insert Succsessful");
			}
			else {JOptionPane.showMessageDialog(null, "Insert Unsuccsessful");}
			
		} catch (SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage());}
		finally
		{
			try 
			{
				statement.close();
			} catch (SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage()); }
		}
		
		return results;
	}
	public int updateNote(cNote updatedNote)
	{
		int results = 0;
		
		//PreparedStatement insertNewEmployee = null;
		String strSQL = "Update Notes SET noteDate = ?, noteTitle = ?, noteBody= ?,  noteRecent = ? " ;
		strSQL += "WHERE noteID = ?";
		
		//JOptionPane.showMessageDialog(null, strSQL);
		try
		{	
			updateUserSQL = connection.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
			updateUserSQL.setString(1, updatedNote.getDate());
			updateUserSQL.setString(2, updatedNote.getTitle());
			updateUserSQL.setString(3, updatedNote.getNote());
			updateUserSQL.setInt(4, updatedNote.getRecent());			
			updateUserSQL.setInt(5, updatedNote.getNoteID());
			
			results = updateUserSQL.executeUpdate();
			
			if (results == 1)
			{
				JOptionPane.showMessageDialog(null, "Insert Succsessful");
			}
			else {JOptionPane.showMessageDialog(null, "Insert Unsuccsessful");}
			
		} catch (SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage());}
		finally
		{
			try 
			{
				statement.close();
			} catch (SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage()); }
		}
		
		return results;
	}

		
	
}
