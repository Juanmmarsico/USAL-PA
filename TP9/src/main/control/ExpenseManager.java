package main.control;

import main.GUI.mainWindow.Window.MainFrame;
import main.control.controllers.*;
public class ExpenseManager {
MainFrame mainFrame;
OwnwerController ownwerController;



public ExpenseManager(MainFrame mainFrame){
    this.mainFrame = mainFrame;
    ownwerController = new OwnwerController();
}

public OwnwerController getOwnwerController() {
	return ownwerController;
}

public void SaveAllValues() {
	// TODO Auto-generated method stub
	System.out.println("salvado por la campana");
}

public void updateFriendPanelList() {
	mainFrame.updateFriendList();
}

}
