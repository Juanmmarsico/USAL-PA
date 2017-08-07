package main.GUI.mainWindow.Window;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import main.GUI.expenseSelector.ExpenseSelector;
import main.control.ExpenseManager;
import main.control.action.AboutAction;
import main.control.action.AddFriendAction;
import main.control.action.IngressIncomeOrExpenseAction;
import main.control.action.ModifyAction;
import main.control.action.SearchAction;

public class MainFrame {
   
	 	private JFrame mainFrame;
	    private JPanel mainPanel, buttonPanel, expensesListPanel, friendPanelList, incomePanelList, expensesPanel;
	    private JScrollPane scrollPaneExpense,scrollPaneFriend,scrollPaneIncome;
	    private JButton addFriendButton, modifyButton, addExpenseButton;
	    private JMenuBar menuBar;
	    private JMenuItem addExpense, search, about, exit, modify;
	    private JMenu expenseMenu, fileMenu;
	    private JList jListExpense,jlistIncome,jlistFriend;
	    
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
	        mainFrame.add(buildExpensesListPanel(),BorderLayout.WEST);
	        mainFrame.add(buildMainPanel(),BorderLayout.CENTER);
	        mainFrame.add(buildFriendPanel(), BorderLayout.EAST);
	        mainFrame.add(buildButtonPanel(), BorderLayout.SOUTH);

	        configMainFrameLayout((BorderLayout) mainFrameLayout);
	        
	        mainFrame.addWindowListener(new WindowAdapter() {
	        	 @Override
	        	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	        	        if (JOptionPane.showConfirmDialog(mainFrame, 
	        	            "Are you sure to close this window?", "Really Closing?", 
	        	            JOptionPane.YES_NO_OPTION,
	        	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
	        	        	expenseManager.SaveAllValues();
	        	            System.exit(0);
	        	        }
	        	    }
			});

	        mainFrame.pack();

	        return mainFrame;
	    }
	    private JPanel buildFriendPanel() {
			// TODO Auto-generated method stub
	    	 friendPanelList = new JPanel(new BorderLayout());
		        JLabel friendListLabel = new JLabel("Amigos");
		        friendPanelList.add(new JTextArea("Amigos"));
		        friendPanelList.setBackground(Color.YELLOW);
		        jlistFriend = new JList();
		        jlistFriend.setPreferredSize(LIST_DIMENSION);
		        jlistFriend.setBackground(Color.WHITE);
		        friendPanelList.add(friendListLabel, BorderLayout.NORTH);
		        friendPanelList.add(jlistFriend,BorderLayout.EAST);
		        friendPanelList.add(buildJScrollPaneFriend(), BorderLayout.CENTER);


		        return friendPanelList;
		        }

		private void configMainFrameLayout(BorderLayout mainFrameLayout) {
//	        Container container = mainFrame.getContentPane();
//
//	        mainFrameLayout.add(BorderLayout.WEST, expensesListPanel,
//	                5,
//	                SpringLayout.WEST, container);
//
//	        mainFrameLayout.putConstraint(SpringLayout.NORTH, expensesListPanel,
//	                5,
//	                SpringLayout.NORTH, container);
//
//	        mainFrameLayout.putConstraint(SpringLayout.SOUTH, expensesListPanel,
//	                5,
//	                SpringLayout.SOUTH, container);
//
//	        mainFrameLayout.putConstraint(SpringLayout.WEST, mainPanel,
//	                5,
//	                SpringLayout.EAST, jList);
//
//	        mainFrameLayout.putConstraint(SpringLayout.NORTH, mainPanel,
//	                5,
//	                SpringLayout.NORTH, container);
//
//	        mainFrameLayout.putConstraint(SpringLayout.EAST, mainPanel,
//	                5,
//	                SpringLayout.EAST, container);
//
//	        mainFrameLayout.putConstraint(SpringLayout.SOUTH, mainPanel,
//	                5,
//	                SpringLayout.SOUTH, container);

	    }
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
	    private JScrollPane buildJScrollPaneExpense(){
	        expensesListPanel.setBackground(background);     
	        scrollPaneExpense = new JScrollPane(jListExpense);

	        return scrollPaneExpense;
	    }
	    private JScrollPane buildJScrollPaneIncome(){
	        incomePanelList.setBackground(background);     
	        scrollPaneIncome = new JScrollPane(jlistIncome);

	        return scrollPaneExpense;
	    }
	    private JScrollPane buildJScrollPaneFriend(){
	        friendPanelList.setBackground(background);     
	        scrollPaneFriend = new JScrollPane(jlistFriend);

	        return scrollPaneFriend;
	    }
	    public JPanel buildExpensesListPanel() {
	    	ExpenseSelector expenseSelector = new ExpenseSelector();
	    	
//	    	expenseSelector.buildExpensesListPanel(mainFrame,expenseManager,expensesPanel,)
	    	
	    	String [] data = {"1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2"};
	    	String [] data2 = {"a","b","a","b","a","b","a","b","a","b","a","b","a","b","a","b","a","b","a","b","a","b","c"};

	    	
	        expensesPanel = new ExpenseSelector();
	    	Container container = expensesPanel;
	        JLabel expensesListLabel = new JLabel("Gastado o Recibido");
	        expensesPanel.add(new TextArea("panel"));

	        expensesListPanel = new JPanel(null);
	        incomePanelList = new JPanel(null);

	        incomePanelList.setBounds(50, 50, 290, 220);
	        expensesListPanel.setBounds(50, 50, 290, 220);

	        
	        expensesListPanel.add(new TextArea("expensas"));
	        expensesListPanel.setBackground(Color.CYAN);
	        jListExpense = new JList(data);
	        jListExpense.setPreferredSize(LIST_DIMENSION);
	        jListExpense.setBackground(Color.WHITE);
	       

	        expensesListPanel.add(expensesListLabel, BorderLayout.NORTH);
	        expensesListPanel.add(jListExpense,BorderLayout.EAST);

	        expensesListPanel.add(buildJScrollPaneExpense(), BorderLayout.CENTER);
	        //
	        
	        incomePanelList.add(new TextArea("Income"));
	        incomePanelList.setBackground(Color.CYAN);
	        jlistIncome = new JList(data2);
	        jlistIncome.setPreferredSize(LIST_DIMENSION);
	        jlistIncome.setBackground(Color.WHITE);
	       

	        incomePanelList.add(expensesListLabel, BorderLayout.NORTH);
	        incomePanelList.add(jlistIncome,BorderLayout.EAST);

	        incomePanelList.add(buildJScrollPaneIncome(), BorderLayout.CENTER);
	        incomePanelList.setVisible(true);
	        expensesListPanel.setVisible(true);
	        
	        container.add(expensesListPanel, BorderLayout.SOUTH);
	        container.add(incomePanelList,BorderLayout.NORTH);
	        
	        return expensesPanel;
	    }
	    
}
