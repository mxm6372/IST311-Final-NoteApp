package broccoliNoteApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class editUserGUI extends javax.swing.JFrame {

	private cBroccoliUser holder;

	private cDBconnection myDB = new cDBconnection();
    private ActionListener  listener,
    						mnuItemListener;

    public editUserGUI() 
    {
        initComponents();
    }

                     
    public editUserGUI(cBroccoliUser user)
    {
    	initComponents(user);
	}


	private void initComponents()
    {

        lblCurrentUser = new javax.swing.JLabel();
        lblCurrentUsername = new javax.swing.JLabel();
        btnChangeName = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCurrentUser.setText("Current User:");

        lblCurrentUsername.setText("tempUser");

        btnChangeName.setText("Change Username");

        btnChangePassword.setText("Change Password");

        btnDelete.setText("Delete User");

        btnClose.setText("Close");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnChangeName)
                                .addGap(18, 18, 18)
                                .addComponent(btnChangePassword)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCurrentUser))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCurrentUsername)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurrentUsername)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangeName)
                    .addComponent(btnChangePassword)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        
	private void initComponents(cBroccoliUser user)
    {
		this.holder = user;

        lblCurrentUser = new javax.swing.JLabel();
        lblCurrentUsername = new javax.swing.JLabel();
        btnChangeName = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        
        listener = new ChoiceListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCurrentUser.setText("Current User:");

        lblCurrentUsername.setText(user.getUsername());

        btnChangeName.setText("Change Username");
        btnChangePassword.setText("Change Password");
        btnClose.setText("Close");
        
        btnChangeName.addActionListener(listener);
        btnChangePassword.addActionListener(listener);
        btnClose.addActionListener(listener);

        btnDelete.setText("Delete User");
        btnDelete.setVisible(false);

       

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnChangeName)
                                .addGap(18, 18, 18)
                                .addComponent(btnChangePassword)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCurrentUser))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCurrentUsername)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurrentUsername)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangeName)
                    .addComponent(btnChangePassword)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addContainerGap())
        );

        pack();
    }
	
	class ChoiceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			switch(event.getActionCommand())
			{
				case "Change Username":			
					var newName = JOptionPane.showInputDialog("What is your New Username?");
					holder.setUsername(newName);
					lblCurrentUsername.setText(newName);
					myDB.updateUser(holder);				
					break;
				case "Change Password":
					var newPassword = JOptionPane.showInputDialog("What is your New Password?");
					holder.setPassword(newPassword);
					myDB.updateUser(holder);				
					break;
				
				case "Close":
					setVisible(false);
					dispose();
					break;
			}
		}
	}
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnChangeName;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel lblCurrentUser;
    private javax.swing.JLabel lblCurrentUsername;
    // End of variables declaration                   
}
