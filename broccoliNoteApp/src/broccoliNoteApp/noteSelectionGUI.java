package broccoliNoteApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;


public class noteSelectionGUI extends javax.swing.JFrame
{
	private cBroccoliUser holder;
	private cNote[] nHolder;

	private cDBconnection myDB = new cDBconnection();
    private ActionListener  listener,
    						mnuItemListener;
    private MouseAdapter mouseEars; 
    						
    

    public noteSelectionGUI()
    {
        initComponents();
    }
    
    public noteSelectionGUI(cBroccoliUser user)
    {
        initComponents(user);
    }
                  
    private void initComponents()
    {
    	//listener = new ChoiceListener();
		mnuItemListener = new MenuItemListener();
		mouseEars = new MouseEars();
		

        jpRecent1 = new javax.swing.JPanel();
        lblTag1 = new javax.swing.JLabel();
        lblTag2 = new javax.swing.JLabel();
        lblTag3 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        jpRecent2 = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        lblTag4 = new javax.swing.JLabel();
        lblTag5 = new javax.swing.JLabel();
        lblTag6 = new javax.swing.JLabel();
        lblOtherNotes = new javax.swing.JLabel();
        spNotes = new javax.swing.JScrollPane();
        tblNotes = new javax.swing.JTable();
        jpRecent3 = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();
        lblTag7 = new javax.swing.JLabel();
        lblTag8 = new javax.swing.JLabel();
        lblTag9 = new javax.swing.JLabel();
        lblRecent = new javax.swing.JLabel();
        btnOpen = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        mnuNoteBar = new javax.swing.JMenuBar();
        mnuUser = new javax.swing.JMenu();
        mnuNew = new javax.swing.JMenu();
        mniUser = new javax.swing.JMenuItem();
        mniLogout = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();
    
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpRecent1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRecent1.setMaximumSize(new java.awt.Dimension(200, 0));
        jpRecent1.setMinimumSize(new java.awt.Dimension(200, 0));
        jpRecent1.setPreferredSize(new java.awt.Dimension(200, 0));

        lblTag1.setText("lblTag1");

        lblTag2.setText("lblTag2");

        lblTag3.setText("lblTag3");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle.setText("lblTitle");
        lblTitle.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jpRecent1Layout = new javax.swing.GroupLayout(jpRecent1);
        jpRecent1.setLayout(jpRecent1Layout);
        jpRecent1Layout.setHorizontalGroup(
            jpRecent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent1Layout.createSequentialGroup()
                .addGroup(jpRecent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRecent1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle))
                    .addGroup(jpRecent1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpRecent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTag1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(lblTag2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTag3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jpRecent1Layout.setVerticalGroup(
            jpRecent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTag1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jpRecent2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRecent2.setPreferredSize(new java.awt.Dimension(200, 216));

        lblTitle1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle1.setText("lblTitle");
        lblTitle1.setVerifyInputWhenFocusTarget(false);

        lblTag4.setText("lblTag1");

        lblTag5.setText("lblTag2");

        lblTag6.setText("lblTag3");

        javax.swing.GroupLayout jpRecent2Layout = new javax.swing.GroupLayout(jpRecent2);
        jpRecent2.setLayout(jpRecent2Layout);
        jpRecent2Layout.setHorizontalGroup(
            jpRecent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent2Layout.createSequentialGroup()
                .addGroup(jpRecent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRecent2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle1))
                    .addGroup(jpRecent2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpRecent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTag4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(lblTag5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTag6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jpRecent2Layout.setVerticalGroup(
            jpRecent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTag4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblOtherNotes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOtherNotes.setText("Other Notes");

        tblNotes.setColumnSelectionAllowed(true);
        tblNotes.getTableHeader().setReorderingAllowed(false);
        spNotes.setViewportView(tblNotes);
        tblNotes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jpRecent3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRecent3.setPreferredSize(new java.awt.Dimension(200, 216));

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle2.setText("lblTitle");
        lblTitle2.setVerifyInputWhenFocusTarget(false);

        lblTag7.setText("lblTag1");

        lblTag8.setText("lblTag2");

        lblTag9.setText("lblTag3");

        javax.swing.GroupLayout jpRecent3Layout = new javax.swing.GroupLayout(jpRecent3);
        jpRecent3.setLayout(jpRecent3Layout);
        jpRecent3Layout.setHorizontalGroup(
            jpRecent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent3Layout.createSequentialGroup()
                .addGroup(jpRecent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRecent3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle2))
                    .addGroup(jpRecent3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpRecent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTag7, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(lblTag8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTag9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jpRecent3Layout.setVerticalGroup(
            jpRecent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTag7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblRecent.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        lblRecent.setText("Recently Accessed");

        btnOpen.setText("Open");

        btnDelete.setText("Delete");

        mnuUser.setText("User");

        mniUser.setText("Edit User");
        mnuUser.add(mniUser);

        mniLogout.setText("Logout");
        mnuUser.add(mniLogout);

        mnuNoteBar.add(mnuUser);

        mnuEdit.setText("Edit");
        //mnuNoteBar.add(mnuEdit);
        
        mnuNew.setText("New");
        mnuNoteBar.add(mnuNew);
        
        mnuNew.addActionListener(mnuItemListener);
        mnuEdit.addActionListener(mnuItemListener);
        mnuNew.addActionListener(mnuItemListener);

        setJMenuBar(mnuNoteBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spNotes)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpRecent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpRecent2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpRecent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpen)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lblRecent, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(lblOtherNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblRecent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpRecent3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpRecent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpRecent1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOtherNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnDelete)))
        );

        pack();
    }// </editor-fold>                        
    private void initComponents(cBroccoliUser user)
    {
    	try
    	{    	
    		//listener = new ChoiceListener();
    		mnuItemListener = new MenuItemListener();
    		mouseEars = new MouseEars();
    		this.holder = user;
    		
    		
    		jpRecent1 = new javax.swing.JPanel();
    		lblTag1 = new javax.swing.JLabel();
    		lblTag2 = new javax.swing.JLabel();
    		lblTag3 = new javax.swing.JLabel();
    		lblTitle = new javax.swing.JLabel();
        	jpRecent2 = new javax.swing.JPanel();
        	lblTitle1 = new javax.swing.JLabel();
        	lblTag4 = new javax.swing.JLabel();
        	lblTag5 = new javax.swing.JLabel();
        	lblTag6 = new javax.swing.JLabel();
        	lblOtherNotes = new javax.swing.JLabel();
        	spNotes = new javax.swing.JScrollPane();
        	tblNotes = new javax.swing.JTable();
        	jpRecent3 = new javax.swing.JPanel();
        	lblTitle2 = new javax.swing.JLabel();
        	lblTag7 = new javax.swing.JLabel();
        	lblTag8 = new javax.swing.JLabel();
        	lblTag9 = new javax.swing.JLabel();
        	lblRecent = new javax.swing.JLabel();
        	btnOpen = new javax.swing.JButton();
        	btnDelete = new javax.swing.JButton();
        	mnuNoteBar = new javax.swing.JMenuBar();
        	mnuUser = new javax.swing.JMenu();
        	mniUser = new javax.swing.JMenuItem();
        	mniNewNote = new javax.swing.JMenuItem();
        	mniLogout = new javax.swing.JMenuItem();
        	mnuEdit = new javax.swing.JMenu();
        	mnuNew = new javax.swing.JMenu();
        	
        	cNote[] notes = myDB.RetrieveAllUserNotes(user.getUserID());
        	this.nHolder = notes;
        	
        	boolean bLessThan3 = false;
        	
        	if(notes.length <= 3)
        	{
        		notes = noteFailSafe(notes);
        		bLessThan3 = true;
        	}
        	

        	jpRecent1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        	jpRecent1.setMaximumSize(new java.awt.Dimension(200, 0));
        	jpRecent1.setMinimumSize(new java.awt.Dimension(200, 0));
        	jpRecent1.setPreferredSize(new java.awt.Dimension(200, 0));
        	
        	cTags[] tags = myDB.RetriveAllNoteTags(notes[0].getNoteID(), user.getUserID());
        	String[] arr3Tags = setTags(tags);

        	lblTag1.setText(arr3Tags[0]);

        	lblTag2.setText(arr3Tags[1]);

        	lblTag3.setText(arr3Tags[2]);
        	
        	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        	lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        	lblTitle.setText(notes[1].getTitle());
        	
        	lblTitle.setVerifyInputWhenFocusTarget(false);

        	javax.swing.GroupLayout jpRecent1Layout = new javax.swing.GroupLayout(jpRecent1);
        	jpRecent1.setLayout(jpRecent1Layout);
        	jpRecent1Layout.setHorizontalGroup(
            jpRecent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent1Layout.createSequentialGroup()
                .addGroup(jpRecent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRecent1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle))
                    .addGroup(jpRecent1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpRecent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTag1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(lblTag2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTag3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(92, Short.MAX_VALUE))
        			);
        	jpRecent1Layout.setVerticalGroup(
            jpRecent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTag1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        			);

        	jpRecent2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        	jpRecent2.setPreferredSize(new java.awt.Dimension(200, 216));
        	
        	tags = myDB.RetriveAllNoteTags(notes[1].getNoteID(), user.getUserID());
        	arr3Tags = setTags(tags);

        	lblTitle1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        	lblTitle1.setText(notes[1].getTitle());
        	lblTitle1.setVerifyInputWhenFocusTarget(false);

        	lblTag4.setText(arr3Tags[0]);

        	lblTag5.setText(arr3Tags[1]);

        	lblTag6.setText(arr3Tags[2]);

        	javax.swing.GroupLayout jpRecent2Layout = new javax.swing.GroupLayout(jpRecent2);
        	jpRecent2.setLayout(jpRecent2Layout);
        	jpRecent2Layout.setHorizontalGroup(
            jpRecent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent2Layout.createSequentialGroup()
                .addGroup(jpRecent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRecent2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle1))
                    .addGroup(jpRecent2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpRecent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTag4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(lblTag5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTag6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(108, Short.MAX_VALUE))
        			);
        	jpRecent2Layout.setVerticalGroup(
            jpRecent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTag4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			);

        	lblOtherNotes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        	lblOtherNotes.setText("Other Notes");

        	tblNotes.setColumnSelectionAllowed(true);
        	tblNotes.getTableHeader().setReorderingAllowed(false);
        	spNotes.setViewportView(tblNotes);
        	tblNotes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        	jpRecent3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        	jpRecent3.setPreferredSize(new java.awt.Dimension(200, 216));
        	
        	tags = myDB.RetriveAllNoteTags(notes[2].getNoteID(), user.getUserID());
        	arr3Tags = setTags(tags);

        	lblTitle2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        	lblTitle2.setText(notes[2].getTitle());
        	lblTitle2.setVerifyInputWhenFocusTarget(false);

        	lblTag7.setText(arr3Tags[0]);

        	lblTag8.setText(arr3Tags[1]);

        	lblTag9.setText(arr3Tags[2]);

        	javax.swing.GroupLayout jpRecent3Layout = new javax.swing.GroupLayout(jpRecent3);
        	jpRecent3.setLayout(jpRecent3Layout);
        	jpRecent3Layout.setHorizontalGroup(
            jpRecent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent3Layout.createSequentialGroup()
                .addGroup(jpRecent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRecent3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle2))
                    .addGroup(jpRecent3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jpRecent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTag7, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(lblTag8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTag9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(92, Short.MAX_VALUE))
        			);
        	jpRecent3Layout.setVerticalGroup(
            jpRecent3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecent3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTag7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTag9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			);

        	lblRecent.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        	lblRecent.setText("Recently Accessed");

        	btnOpen.setText("Open");

        	btnDelete.setText("Delete");

        	mnuUser.setText("User");

        	mniUser.setText("Edit User");
        	
        	mnuUser.add(mniUser);
        	mniLogout.setText("Logout");
        	mniNewNote.setText("New Note");
        	
        	mnuUser.add(mniLogout);
        	mnuNoteBar.add(mnuUser);

        	mnuEdit.setText("Edit");
        	//mnuNoteBar.add(mnuEdit);
        	
        	mnuNew.setText("New");
        	mnuNew.add(mniNewNote);
        	mnuNoteBar.add(mnuNew);
        	
        	mniLogout.setActionCommand("Logout");
        	mniUser.setActionCommand("Edit");
        	mniNewNote.setActionCommand("New");
        	

        	setJMenuBar(mnuNoteBar);
        	
        	//mniNewNote.addActionListener(mnuItemListener);
        	mniUser.addActionListener(mnuItemListener);
        	mniLogout.addActionListener(mnuItemListener);
        	mniNewNote.addActionListener(mnuItemListener);
        	
        	/*jpRecent1.addMouseListener(mouseEars);
        	jpRecent2.addMouseListener(mouseEars);
        	jpRecent3.addMouseListener(mouseEars);*/
        	

        	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        	getContentPane().setLayout(layout);
        	layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spNotes)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpRecent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpRecent2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpRecent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpen)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lblRecent, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(lblOtherNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        			);
        	layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblRecent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpRecent3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpRecent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpRecent1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOtherNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnDelete)))
        			);

        	pack();
    		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    		}	
    }

    

    
    class MouseEars extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            if(e.getClickCount()==2)
            {
            	switch(e.getSource())
            	{
            	
            	}
                
                //myDB.RetrieveNote(ALLBITS, holder.getUserID());
            }
        }
	}

	public cNote[] noteFailSafe(cNote[] notes)
    {
    	int target = 3;
    	int iDifference = target-notes.length;
    	int index;
    	
    	cNote[] arr3Notes = new cNote[notes.length + iDifference];
		
    	for (index = 0; index < notes.length; index++)
    		arr3Notes[index] = notes[index];
    	
    	for (index = index; index < arr3Notes.length; index++)
    		arr3Notes[index] = addDummyNote();
    	
		return arr3Notes;
	}

	public String[] setTags(cTags[] noteTags)
    {
    	String[] tagText = new String[3];
    	int i;
    	
    	for (i = 0; i < noteTags.length; i++)
    		tagText[i] = noteTags[i].getTagText();
    	
    	for (i = i; i < tagText.length; i++)
    		tagText[i] = "No Tags";
    	
    	return tagText;
    }
    
    public cNote addDummyNote()
    {
    	cNote dummy = new cNote();
    	
    	dummy.setTitle("No Title");
    	
    	return dummy;
    }
    
    
    class MenuItemListener implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {            
//	        JOptionPane.showMessageDialog(null, e.getActionCommand());	        
	        switch(e.getActionCommand())
	        {
	        	case "New":
	        		noteGUI newNote = new noteGUI();
	        		newNote.setVisible(true);
	        		break;	        	
	        	case "Logout":
	        		setVisible(false);
	        		cLoginGUI LoginGUI = new cLoginGUI();
	        		LoginGUI.setVisible(true);
	        		dispose();
	        		break;
	        	case "Edit":
	        		editUserGUI euGUI = new editUserGUI(holder);
	        		euGUI.setVisible(true);
	        		break;
	        }
	    }
	    
	}
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpen;
    private javax.swing.JPanel jpRecent1;
    private javax.swing.JPanel jpRecent2;
    private javax.swing.JPanel jpRecent3;
    private javax.swing.JLabel lblOtherNotes;
    private javax.swing.JLabel lblRecent;
    private javax.swing.JLabel lblTag1;
    private javax.swing.JLabel lblTag2;
    private javax.swing.JLabel lblTag3;
    private javax.swing.JLabel lblTag4;
    private javax.swing.JLabel lblTag5;
    private javax.swing.JLabel lblTag6;
    private javax.swing.JLabel lblTag7;
    private javax.swing.JLabel lblTag8;
    private javax.swing.JLabel lblTag9;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniUser;
    private javax.swing.JMenuItem mniNewNote;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenu mnuNew;
    private javax.swing.JMenuBar mnuNoteBar;
    private javax.swing.JMenu mnuUser;
    private javax.swing.JScrollPane spNotes;
    private javax.swing.JTable tblNotes;
    // End of variables declaration                   
}
