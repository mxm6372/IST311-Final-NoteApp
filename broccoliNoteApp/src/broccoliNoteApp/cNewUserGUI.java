package broccoliNoteApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


/**********************************************************
 *Filename:			AppMain.java
 *Package:
 *Project:			311-Final
 *Author:			mxm6372
 *Section:			IST 311
 *Assignment:		Final
 *Description:		
 *Date Created:		4/19/2023
 *Date Modified:	4/19/2023
 *Modifier:			N/A
 *Changes:			N/A			
 *
*********************************************************/
public class cNewUserGUI extends javax.swing.JFrame
{
	private cDBconnection dbConnection = new cDBconnection();

	//constructor for GUI
    public cNewUserGUI()
    {
    	NewUserListener = new NewUserListener();
        txtPassword = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtConfirm = new javax.swing.JTextField();
        lblConfirm = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        lblConfirm.setText("Confirm Password:");

        btnCreate.setText("Create New User");
        
        btnCreate.addActionListener(NewUserListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnCreate)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreate)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }// </editor-fold>                        
                                    
    class NewUserListener implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	    	switch(e.getActionCommand())
	        {
	        	case "Create New User":
	        		sendNewUser();
	        		break;
	        }
	    }
	}
	public void sendNewUser()
	{
		// TODO Auto-generated method stub
		cBroccoliUser newUser = new cBroccoliUser(txtUsername.getText(), txtPassword.getText());
		
		if(!(txtUsername.getText().equals("")))
		{
			JOptionPane.showMessageDialog(null, "Please enter a Username");
		}
		else
		{

			if(txtPassword.getText().equals(txtConfirm.getText()))
			{
				dbConnection.addNewUser(newUser);
				setVisible(false);
				dispose();
			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The Passwords do not match.");
				txtPassword.setText("");
				txtConfirm.setText("");
			}
		}
	}
    
    // Variables declaration - do not modify                     
    public javax.swing.JButton btnCreate;
    public javax.swing.JLabel lblConfirm;
    public javax.swing.JLabel lblPassword;
    public javax.swing.JLabel lblUsername;
    public javax.swing.JTextField txtConfirm;
    public javax.swing.JTextField txtPassword;
    public javax.swing.JTextField txtUsername;
    private ActionListener 	listener,
    						NewUserListener;
    // End of variables declaration                   
}
