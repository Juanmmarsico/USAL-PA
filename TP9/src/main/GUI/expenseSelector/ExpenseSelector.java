package main.GUI.expenseSelector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextArea;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.control.ExpenseManager;
import main.model.AbstractExpense;
import main.model.Expense;
import main.model.Friend;
import main.model.Income;


public class ExpenseSelector extends JFrame{

	
	
	
	
    final static Dimension MIN_DIMENSION = new Dimension(300,100);
    final static Dimension LIST_DIMENSION = new Dimension(200,50);
    
	private JPanel  incomePanelList,  expensesListPanel;
    private JList jListExpense,jlistIncome;
    private JScrollPane scrollPaneExpense,scrollPaneIncome;
    private DefaultListModel<Expense> expenseModel;
    private	DefaultListModel<Income> incomeModel;
    private ExpenseManager expenseManager;
    
    public ExpenseSelector() {
		// TODO Auto-generated constructor stub
    

    }

	public ExpenseSelector(ExpenseManager expenseManager) {
		// TODO Auto-generated constructor stub
		this();
		this.expenseManager = expenseManager;
		this.setTitle("ingresos y gastos");
    	this.add(buildIncomePanel(), BorderLayout.EAST);
    	this.add(buildExpensePanel(), BorderLayout.WEST);
    	
    	int [] algo= {1};
    	expenseManager.getOwnwerController().getOwner().addIncome(1, algo, "asd", 23, Calendar.getInstance());;
    	expenseManager.getOwnwerController().getOwner().addExpense("asd", 23, Calendar.getInstance(),2);
    	
    	updateExpenseOrIncomeList();
    	this.setVisible(true);
	}

	private JPanel buildExpensePanel() {
		// TODO Auto-generated method stub
		expensesListPanel = new JPanel();
		JLabel expenseListLabel = new JLabel("Gastado");
		expensesListPanel.add(new JTextArea("gastos"));
		expensesListPanel.setBackground(Color.RED);
		
		expenseModel = new DefaultListModel<Expense>();
		jListExpense = new JList<Expense>();

		expensesListPanel.add(jListExpense);
      jListExpense.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				jlistIncome.clearSelection();
			}
		});
		return expensesListPanel;
	}

	private JPanel buildIncomePanel() {
		// TODO Auto-generated method stub
		incomePanelList = new JPanel();
		JLabel incomeListLabel = new JLabel("ingresos");
		incomePanelList.add(new JTextArea("ingreso"));
		incomePanelList.setBackground(Color.GREEN);
		
		incomeModel = new DefaultListModel<Income>();
		jlistIncome = new JList<>();
		
		incomePanelList.add(jlistIncome);
      jlistIncome.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				jListExpense.clearSelection();
			}
		});
      jlistIncome.setSize(100, 100);
      
		
		return incomePanelList;
	}

	  public void updateExpenseOrIncomeList() {
	    	if (expenseManager.getOwnwerController().getOwner().getExpense().size()>0) {
	    		incomeModel.removeAllElements();
	    		expenseModel.removeAllElements();
	    		for (Expense f : expenseManager.getOwnwerController().ExpenseThisMonth()) {
			    	expenseModel.addElement(f);
				}
	    		for (Income f : expenseManager.getOwnwerController().IncomeThisMonth()) {
			    	incomeModel.addElement(f);
				}
			}
	        jListExpense = new JList<Expense>(expenseModel);	
	        jlistIncome = new JList<Income>(incomeModel);
	        }

//    public ExpenseSelector() {
//		// TODO Auto-generated constructor stub
//	}
//    
//    public JFrame buildExpensesListPanel() {    	
//    	
//    	String [] data = {"1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2"};
//    	String [] data2 = {"a","b","a","b","a","b","a","b","a","b","a","b","a","b","a","b","a","b","a","b","a","b","c"};
//
//    	
////        expensesPanel = new ExpenseSelector();
//    	expensesPanel = new JPanel();
//    	Container container = expensesPanel;
//        JLabel expensesListLabel = new JLabel("Gastado o Recibido");
//        expensesPanel.add(new TextArea("panel"));
//
//        expensesListPanel = new JPanel(null);
//        incomePanelList = new JPanel(null);
//
//        incomePanelList.setBounds(50, 50, 290, 220);
//        expensesListPanel.setBounds(50, 50, 290, 220);
//
//        
//        expensesListPanel.add(new TextArea("expensas"));
//        expensesListPanel.setBackground(Color.CYAN);
//        jListExpense = new JList(data);
//        jListExpense.setPreferredSize(LIST_DIMENSION);
//        jListExpense.setBackground(Color.WHITE);
//       
//
//        expensesListPanel.add(expensesListLabel, BorderLayout.NORTH);
//        expensesListPanel.add(jListExpense,BorderLayout.EAST);
//
//        expensesListPanel.add(buildJScrollPaneExpense(), BorderLayout.CENTER);
//        //
//        
//        incomePanelList.add(new TextArea("Income"));
//        incomePanelList.setBackground(Color.CYAN);
//        jlistIncome = new JList(data2);
//        jlistIncome.setPreferredSize(LIST_DIMENSION);
//        jlistIncome.setBackground(Color.WHITE);
//       
//
//        incomePanelList.add(expensesListLabel, BorderLayout.NORTH);
//        incomePanelList.add(jlistIncome,BorderLayout.EAST);
//
//        incomePanelList.add(buildJScrollPaneIncome(), BorderLayout.CENTER);
//        incomePanelList.setVisible(true);
//        expensesListPanel.setVisible(true);
//        
	  
	  
	  
	  
	  
	  
//        container.add(expensesListPanel, BorderLayout.SOUTH);
//        container.add(incomePanelList,BorderLayout.NORTH);
//        
//        this.add(expensesPanel);
//        
//        return this;
//    }
//
//	public JPanel getIncomePanelList() {
//		return incomePanelList;
//	}
//
//	public JPanel getExpensesPanel() {
//		return expensesPanel;
//	}
//
//	public JPanel getExpensesListPanel() {
//		return expensesListPanel;
//	}
//
//	public JList getjListExpense() {
//		return jListExpense;
//	}
//
//	public JList getJlistIncome() {
//		return jlistIncome;
//	}
//
//	public void setIncomePanelList(JPanel incomePanelList) {
//		this.incomePanelList = incomePanelList;
//	}
//
//	public void setExpensesPanel(JPanel expensesPanel) {
//		this.expensesPanel = expensesPanel;
//	}
//
//	public void setExpensesListPanel(JPanel expensesListPanel) {
//		this.expensesListPanel = expensesListPanel;
//	}
//
//	public void setjListExpense(JList jListExpense) {
//		this.jListExpense = jListExpense;
//	}
//
//	public void setJlistIncome(JList jlistIncome) {
//		this.jlistIncome = jlistIncome;
//	}
//	 
//	private JScrollPane buildJScrollPaneExpense(){
//	        expensesListPanel.setBackground(Color.RED);     
//	        scrollPaneExpense = new JScrollPane(jListExpense);
//
//	        return scrollPaneExpense;
//	    }
//	    private JScrollPane buildJScrollPaneIncome(){
//	        incomePanelList.setBackground(Color.YELLOW);     
//	        scrollPaneIncome = new JScrollPane(jlistIncome);
//
//	        return scrollPaneIncome;
//	    }
//	  
}
