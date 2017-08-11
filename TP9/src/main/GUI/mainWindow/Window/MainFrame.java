package main.GUI.mainWindow.Window;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import main.GUI.expenseSelector.ExpenseSelector;
import main.GUI.tableModel.FriendTableModel;
import main.control.ExpenseManager;
import main.control.action.AboutAction;
import main.control.action.AddFriendAction;
import main.control.action.IngressIncomeOrExpenseAction;
import main.control.action.ModifyAction;
import main.control.action.SearchAction;
import main.model.Friend;

public class MainFrame {
   
	 	private JFrame mainFrame;
	    private JPanel mainPanel, buttonPanel, friendPanelList;
	    private JScrollPane scrollPaneFriend;
	    private JButton addFriendButton, modifyButton, addExpenseButton;
	    private JMenuBar menuBar;
	    private JMenuItem addExpense, search, about, exit, modify;
	    private JMenu expenseMenu, fileMenu;
	    private JTable jlistFriend;
	    private FriendTableModel friendModel;
	    
	    private ExpenseManager expenseManager;
	    
	    Color background = Color.WHITE;
	    
	    final static Dimension INITIAL_DIMENSION = new Dimension(900,900);
	    final static Dimension MIN_DIMENSION = new Dimension(500,300);
	    final static Dimension LIST_DIMENSION = new Dimension(170,0);
	    

	    public MainFrame() {
	        expenseManager = new ExpenseManager(this);

	        buildMainFrame();
	        mainFrame.setLocationRelativeTo(null);
	        mainFrame.setVisible(true);
	        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        mainFrame.pack();
	    }
	    
	    private JPanel buildMainPanel() {
	        mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout());
	        mainPanel.add(new JTextArea("dueno"), BorderLayout.CENTER);
	        

	        return mainPanel;
	    }
	    
	    private JFrame buildMainFrame() {
	        mainFrame = new JFrame("GASTE?");

	        mainFrame.setPreferredSize(INITIAL_DIMENSION);
	        mainFrame.setMinimumSize(MIN_DIMENSION);

	        LayoutManager mainFrameLayout = new BorderLayout();
	        mainFrame.setLayout(mainFrameLayout);
	        mainFrame.setJMenuBar(buildMenuBar());
//	        mainFrame.add(buildExpensesListPanel(),BorderLayout.WEST);
	        buildExpensesListPanel();
	        mainFrame.add(buildMainPanel(),BorderLayout.CENTER);
	        mainFrame.add(buildFriendPanel(), BorderLayout.EAST);
	        mainFrame.add(buildButtonPanel(), BorderLayout.SOUTH);

//	        configMainFrameLayout((BorderLayout) mainFrameLayout);
	        
	        mainFrame.addWindowListener(new WindowAdapter() {
	        	 @Override
	        	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	        	        if (JOptionPane.showConfirmDialog(mainFrame, 
	        	            "Are you sure to close this window?", "Really Closing?", 
	        	            JOptionPane.YES_NO_OPTION,
	        	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
	        	        	expenseManager.SaveAllValues();
	        	            System.exit(0);
	        	        }else {
	        	        	System.out.println("estoy");
	        	        	return;
	        	        }
	        	    }
			});

	        mainFrame.pack();

	        mainFrame.repaint();
	        return mainFrame;
	    }
	    private JPanel buildFriendPanel() {
			// TODO Auto-generated method stub
	    	 friendPanelList = new JPanel(new BorderLayout());
		        JLabel friendListLabel = new JLabel("Amigos");
		        friendPanelList.add(new JTextArea("Amigos"));
		        friendPanelList.setBackground(Color.YELLOW);
		    	
		    	friendModel= new FriendTableModel(expenseManager);
		    	
				    	
		    	updateFriendList();
//		    	expenseManager.getOwnwerController().getOwner().addFriend(new Friend("Carlos", "antonio", 212));
//		    	friendModel.addElement(expenseManager.getOwnwerController().getOwner().getFriends().get(0));


		        jlistFriend.setPreferredSize(LIST_DIMENSION);
		        jlistFriend.setBackground(Color.WHITE);
		        friendPanelList.add(friendListLabel, BorderLayout.NORTH);
		        friendPanelList.add(jlistFriend,BorderLayout.EAST);
		        friendPanelList.add(buildJScrollPaneFriend(), BorderLayout.CENTER);

		        return friendPanelList;
		        }

//		private void configMainFrameLayout(BorderLayout mainFrameLayout) {
//	        Container container = mainFrame.getContentPane();
//	    }
	    private JMenuBar buildMenuBar() {
	        menuBar = new JMenuBar();

	        menuBar.add(buildSystem());
	        menuBar.add(buildOperation());


	        return menuBar;
	    }
	    
	    private JMenu buildSystem() {
	        expenseMenu = new JMenu("Sistema");

	        about = new JMenuItem("Acerca de");
	        about.addActionListener(new AboutAction(expenseManager));
	        expenseMenu.add(about);

	        exit = new JMenuItem("salir");
	        exit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					closeApp();
				}
			});
	        expenseMenu.add(exit);

	        return expenseMenu;
	    }
	    
	    protected void closeApp() {
			// TODO Auto-generated method stub
	    	mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
	    }

		private JMenu buildOperation() {
	        expenseMenu = new JMenu("Operaciones");
	
	        addExpense = new JMenuItem("Agregar Gasto o ingreso");
	        addExpense.addActionListener(new IngressIncomeOrExpenseAction(expenseManager));
	        expenseMenu.add(addExpense);
	
	        search = new JMenuItem("Busqueda Masiva");
	        search.addActionListener(new SearchAction(expenseManager));
	        expenseMenu.add(search);
	        
	        modify = new JMenuItem("Consulta y Actualizacion");
	        modify.addActionListener(new SearchAction(expenseManager));
	        expenseMenu.add(modify);

	        return expenseMenu;
	    }

	    private JPanel buildButtonPanel() {
	        buttonPanel = new JPanel(new GridLayout(1, 3));


	        addFriendButton = new JButton("Agregar Amigos");
	        addFriendButton.addActionListener(new AddFriendAction(expenseManager));
	        buttonPanel.add(addFriendButton, BorderLayout.WEST);

	        addExpenseButton = new JButton("Agregar Gasto O Ingreso");
	        addExpenseButton.addActionListener(new IngressIncomeOrExpenseAction(expenseManager));
	        buttonPanel.add(addExpenseButton, BorderLayout.CENTER);

	        modifyButton = new JButton("Modificar y Actualizar");
	        modifyButton.addActionListener(new ModifyAction(expenseManager));
	        buttonPanel.add(modifyButton, BorderLayout.EAST);


	        return buttonPanel;
	    }
	    
	    private JScrollPane buildJScrollPaneFriend(){
	        friendPanelList.setBackground(background);     
	        scrollPaneFriend = new JScrollPane(jlistFriend);

	        return scrollPaneFriend;
	    }
	  
	    public JFrame buildExpensesListPanel() {
	    	ExpenseSelector expenseSelector = new ExpenseSelector(expenseManager);	
	    	expenseSelector.setVisible(true);
	        return expenseSelector;
	    }
	    
	    public void updateFriendList() {
	    	if (expenseManager.getOwnwerController().getOwner().getFriends().size()>0) {
	    	
	    		for (Friend f : expenseManager.getOwnwerController().ownerFriends()) {
//			    	friendModel.add(f);
	    			
				}
			}
	        jlistFriend = new JTable();	 
	        jlistFriend.setModel(friendModel);
	        }
}
