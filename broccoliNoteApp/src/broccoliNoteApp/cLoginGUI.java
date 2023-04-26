package broccoliNoteApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class cLoginGUI extends javax.swing.JFrame
{
	private cDBconnection myDB = new cDBconnection();
    private ActionListener	listener;

    public cLoginGUI()
    {
        initComponents();
        
    }
                   
    private void initComponents()
    {

        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnNewUser = new javax.swing.JButton();
        btnForgot = new javax.swing.JButton();
        
        listener = new ChoiceListener();
		
       
        btnLogin.addActionListener(listener);
        btnNewUser.addActionListener(listener);
        btnForgot.addActionListener(listener);
        



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUsername.setText("Username:");
        lblPassword.setText("Password:");
        btnLogin.setText("Login");
        btnNewUser.setText("Sign Up");
        btnForgot.setText("Forgot Sign In");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNewUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnForgot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnForgot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewUser)
                .addGap(13, 13, 13))
        );

        pack();
        btnForgot.setVisible(false);
    }                    

	class ChoiceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			switch(event.getActionCommand())
			{
				case "Forgot Sign In":
					
					break;
				
				case "Login":
					userLogin();
					break;
				case "Sign Up":
					cNewUserGUI SignUpGUI = new cNewUserGUI();
					SignUpGUI.setVisible(true);
					//setVisible(false);
					break;
					
				case "Exit":
					System.exit(0);		
			}
		}
	}
	
	public void userLogin()
	{
		 String strUsernameInput = this.txtUsername.getText();
	     String strPasswordInput = this.txtPassword.getText();
	     
	     try
	     {
			cBroccoliUser[] users = myDB.RetrieveUsers();
			//System.out.println(strUsernameInput);
			
			for (int i = 0; i < users.length; i++)
			{
				 if(strUsernameInput.equals(users[i].getUsername()) && strPasswordInput.equals(users[i].getPassword()))
				 {
					 //System.out.println("you logged in!");
					 noteSelectionGUI selGUI = new noteSelectionGUI(users[i]);
					 selGUI.setVisible(true);
					 setVisible(false);
					 dispose();
				 }
			}
		
		 } catch (SQLException e)
	     {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		 }
	    
	     
	}
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnForgot;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    public javax.swing.JTextField txtPassword;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration                   
}
