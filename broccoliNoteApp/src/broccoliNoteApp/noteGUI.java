package broccoliNoteApp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class noteGUI extends javax.swing.JFrame
{
	
	private cBroccoliUser uHolder;
	private cNote nHolder;
	private cTags[] tHolder;

	private cDBconnection myDB = new cDBconnection();
    private ActionListener  listener,
    						mnuItemListener;

    public noteGUI()
    {
        initComponents();
    }
    
    public noteGUI(cBroccoliUser user)
    {
    	uHolder = user;
        initComponents();
    }
    public noteGUI(cBroccoliUser user, cNote note)
    {
    	uHolder = user;
    	nHolder = note;
        initComponents();
    }
    public noteGUI(cBroccoliUser user, cNote note, cTags tags[])
    {
    	uHolder = user;
    	nHolder = note;
    	tHolder = tags;
    	
        initComponents();
    }
                

    private void initComponents()
    {
    	
    	listener = new ChoiceListener();
    	mnuItemListener = new MenuItemListener();

        btnSave = new javax.swing.JButton();
        spNoteScroll = new javax.swing.JScrollPane();
        //taNoteArea = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        cboTags = new javax.swing.JComboBox<>();
        lblTags = new javax.swing.JLabel();
        btnAddTags = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        mnuNoteBar = new javax.swing.JMenuBar();
        mnuUser = new javax.swing.JMenu();
        mniUser = new javax.swing.JMenuItem();
        mniIncrease = new javax.swing.JMenuItem();
        mniDecrease = new javax.swing.JMenuItem(); 
        mniLogout = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        taNoteArea = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        taNoteArea.setText("Enter Note Here....");
        jScrollPane1.setViewportView(taNoteArea);

        /*taNoteArea.setColumns(20);
        taNoteArea.setRows(5);
        taNoteArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        taNoteArea.setRequestFocusEnabled(false);
        spNoteScroll.setViewportView(taNoteArea);*/

        lblTitle.setText("Title: ");
        lblDate.setText("Date:");
        
        if(nHolder!=null)
        {
        	txtTitle.setText(nHolder.getTitle());
        	txtDate.setText(nHolder.getDate());
        }

        if(tHolder!=null)
        {
        	for(int i =0; i < tHolder.length; i++)
        		cboTags.addItem(tHolder[i].getTagText());       		
        }
        
        cboTags.setEditable(false);

        lblTags.setText("Note Tags:");

        btnAddTags.setText("Add Tags");
        btnSave1.setText("Save and Close");
        btnSave.setText("Save");
        
        btnSave.addActionListener(listener);
        btnSave1.addActionListener(listener);
        btnAddTags.addActionListener(listener);
        cboTags.addActionListener(listener);

        mnuUser.setText("User");

        mniUser.setText("Edit User");
        mnuUser.add(mniUser);
        

        mniLogout.setText("Logout");
        mnuUser.add(mniLogout);

        mnuNoteBar.add(mnuUser);

        mnuEdit.setText("Edit");
        mnuNoteBar.add(mnuEdit);
        
        mniIncrease.setText("Increase Font");
        mniDecrease.setText("Decrease Font");
        
        mnuEdit.add(mniIncrease);
        mnuEdit.add(mniDecrease);
        
        mniLogout.setActionCommand("Logout");
    	mniUser.setActionCommand("Edit");
    	mniIncrease.setActionCommand("Increase");
    	mniDecrease.setActionCommand("Decrease");
        
        mniDecrease.addActionListener(mnuItemListener);
        mniIncrease.addActionListener(mnuItemListener);
    	mniUser.addActionListener(mnuItemListener);
    	mniLogout.addActionListener(mnuItemListener);

        setJMenuBar(mnuNoteBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddTags, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTags)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTags, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(cboTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTags)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDate)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddTags))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnSave1))
                .addContainerGap())
        );

        pack();
    }
    
    class MenuItemListener implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {            
//	        JOptionPane.showMessageDialog(null, e.getActionCommand());	        
	        switch(e.getActionCommand())
	        {
	        	case "Increase":
	        		int fontSize = taNoteArea.getFont().getSize();
	        		fontSize++;
	        		taNoteArea.setFont(new Font(taNoteArea.getFont().getName(), taNoteArea.getFont().getStyle(), fontSize));
	        		break;	  
	        	case "Decrease":
	        		int fontSize1 = taNoteArea.getFont().getSize();
	        		fontSize1--;
	        		taNoteArea.setFont(new Font(taNoteArea.getFont().getName(), taNoteArea.getFont().getStyle(), fontSize1));
	        		break;
	        	case "Logout":
	        		setVisible(false);
	        		cLoginGUI LoginGUI = new cLoginGUI();
	        		LoginGUI.setVisible(true);
	        		dispose();
	        		break;
	        	case "Edit":
	        		editUserGUI euGUI = new editUserGUI(uHolder);
	        		euGUI.setVisible(true);
	        		break;
	        }
	    }
	}
    class ChoiceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			switch(event.getActionCommand())
			{
				case "Save":
					SaveNote();
					break;
				case "Save and Close":
					SaveNote();
					setVisible(false);
					dispose();
					break;
				case "Add Tags":
					var newTag = JOptionPane.showInputDialog("What Tag Would You like to Add?");
					cboTags.addItem(newTag);
					break;
				
				
						
			}
		}
	}
    
    public void SaveNote()
    {
    	nHolder.setTitle(txtTitle.getText());
    	nHolder.setNote(taNoteArea.getText());
    	nHolder.setDate();
    	nHolder.setRecent(0);
    	
    	int num = cboTags.getItemCount();
    	for(int i = 0; i < num; i++)
    		tHolder[i].setTagText(cboTags.getItemAt(i));
    	
    	
    	
    	myDB.updateNote(nHolder);
    	
    	for(int i = 0; i < tHolder.length; i++)
    	{
    		myDB.updateTags(tHolder[i]);
    	}
    }
    


    
    private javax.swing.JButton btnAddTags;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JComboBox<String> cboTags;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblTags;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniUser,
    							  mniIncrease, 
    							  mniDecrease;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenuBar mnuNoteBar;
    private javax.swing.JMenu mnuUser;
    private javax.swing.JScrollPane spNoteScroll;
    //private javax.swing.JTextArea taNoteArea;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane taNoteArea;
    // End of variables declaration                   
}
