package main.GUI.expenseSelector;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.*;


public class ExpenseSelector extends JPanel{

    final static Dimension MIN_DIMENSION = new Dimension(300,100);
    final static Dimension LIST_DIMENSION = new Dimension(200,50);
    
	private JPanel  incomePanelList, expensesPanel, expensesListPanel;
    private JList jListExpense,jlistIncome;
    private JScrollPane scrollPaneExpense,scrollPaneIncome;


    public ExpenseSelector() {
		// TODO Auto-generated constructor stub
	}
    
    public JPanel buildExpensesListPanel() {    	
    	
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

	public JPanel getIncomePanelList() {
		return incomePanelList;
	}

	public JPanel getExpensesPanel() {
		return expensesPanel;
	}

	public JPanel getExpensesListPanel() {
		return expensesListPanel;
	}

	public JList getjListExpense() {
		return jListExpense;
	}

	public JList getJlistIncome() {
		return jlistIncome;
	}

	public void setIncomePanelList(JPanel incomePanelList) {
		this.incomePanelList = incomePanelList;
	}

	public void setExpensesPanel(JPanel expensesPanel) {
		this.expensesPanel = expensesPanel;
	}

	public void setExpensesListPanel(JPanel expensesListPanel) {
		this.expensesListPanel = expensesListPanel;
	}

	public void setjListExpense(JList jListExpense) {
		this.jListExpense = jListExpense;
	}

	public void setJlistIncome(JList jlistIncome) {
		this.jlistIncome = jlistIncome;
	}
	 
	private JScrollPane buildJScrollPaneExpense(){
	        expensesListPanel.setBackground(Color.RED);     
	        scrollPaneExpense = new JScrollPane(jListExpense);

	        return scrollPaneExpense;
	    }
	    private JScrollPane buildJScrollPaneIncome(){
	        incomePanelList.setBackground(Color.YELLOW);     
	        scrollPaneIncome = new JScrollPane(jlistIncome);

	        return scrollPaneIncome;
	    }
	  
}
