package main.control.action;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JOptionPane;

import main.control.ExpenseManager;

public class AddFriendAction extends ExpenseManagerAction{

	public AddFriendAction(ExpenseManager expenseManager) {
		super(expenseManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String string ="Escriba la ubicacion del archivo con los amigos,\n PD la informacion puede llegar a duplicarse si el amigo ya existia previamente \n"
				+ "Dicho archivo tiene que estar dividido por \";\" \n Con el formato: Nombre;Apellido;0 \n"
				+ "el 0 se lo puede cambiar por el valor que le deba el individuo si es que le debe plata \n";
		String seleccion = JOptionPane.showInputDialog(
				   (Component) e.getSource(),
				   string,
				   JOptionPane.QUESTION_MESSAGE);
				        
				System.out.println("El usuario ha escrito "+seleccion);	
	expenseManager.getOwnwerController().readFriends(seleccion);			
	}
	
}
