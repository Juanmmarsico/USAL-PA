package main.GUI.tableModel;

import java.util.LinkedList;

import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.AbstractTableModel;

import main.control.ExpenseManager;
import main.model.Friend;

public class FriendTableModel extends AbstractTableModel{
	
	private static final String[] coloumName = {"Nombre", "Apellido", "Adeuda"};
	private  LinkedList<Friend> list;
	ExpenseManager expenseManager;
	
	public FriendTableModel(ExpenseManager expenseManager) {
		// TODO Auto-generated constructor stub
	list = new LinkedList<Friend>();
	this.expenseManager = expenseManager;
	}
	
	public void addAllFriends() {
		
		list.addAll(expenseManager.getOwnwerController().getOwner().getFriends());
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
