	package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import main.GUI.mainWindow.Window.MainFrame;
import main.model.Friend;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			MainFrame mainFrame = new MainFrame();
		
//		
//			Calendar calendar = new GregorianCalendar(2000, 0, 1);
//			SimpleDateFormat sdf = new SimpleDateFormat("MM");
//			System.out.println(sdf.format(calendar.getTime()));
//			
//			try {
//				FileWriter fw = new FileWriter(new File("./Files/Calendar.txt"));
//				for (int i = 0; calendar.get(Calendar.YEAR) <= 2050; i++) {
//					fw.write(sdf.format(calendar.getTime())+calendar.getActualMaximum(Calendar.DAY_OF_MONTH)+calendar.get(Calendar.YEAR)+'\n');
//					calendar.add(Calendar.MONTH,1);
//				}
//				fw.flush();
//				fw.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addExpense("algo", 12, Calendar.getInstance(), 2);
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addExpense("sdasf", 12, Calendar.getInstance(), 2);
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addExpense("fasd", 12, Calendar.getInstance(), 2);
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addExpense("trte", 12, Calendar.getInstance(), 2);
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addExpense("ytry", 12, Calendar.getInstance(), 2);
//			
//			
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("carlos", "adsa");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("dfad", "ppo");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("gadfd", "netr");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("hrt", "jyt");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("ngdf", "verw");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("wtre", "rwe");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("er", "se");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("qe", "fd");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("tw", "re");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("w", "gfd");
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addFriend("ywre", "fd");
//			
//			
//			int [] algo= {1};
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addIncome(1, algo, "asd", 23, Calendar.getInstance());
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addIncome(1, algo, "dsafd", 12, Calendar.getInstance());
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addIncome(1, algo, "asewd", 2343, Calendar.getInstance());
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addIncome(1, algo, "treqer", 2412, Calendar.getInstance());
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addIncome(1, algo, "bafvda", 8989, Calendar.getInstance());
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addIncome(1, algo, "kop", 2, Calendar.getInstance());

////			
//			ArrayList<Friend> f = new ArrayList<>(mainFrame.getExpenseManager().getOwnwerController().getOwner().searchAllFriend("a"));
//			
//			mainFrame.getExpenseManager().getOwnwerController().getOwner().addExpense("ytry", 12, Calendar.getInstance(), f,2);
//
//
//			mainFrame.repaint();
			
//		ArrayList<String> algo = new ArrayList<String>();
//		algo.add("algo");
//		algo.add("as");
//		algo.add("asd");
//		algo.add("as");
//		algo.add("as");
//		algo.add("algo");
//		algo.add("as");
//		algo.add("asd");
//		algo.add("as");
//		algo.add("as");
//		
//		LinkedList< String> linkedList = new LinkedList<>();
//		linkedList.addAll(algo);
//		
//		ArrayList<String> a = new ArrayList<>();
//		for (String string : linkedList) {
//			if (string.contains("s")) {
//				a.add(string);
//			}
//		}
//		
//			System.out.println(a);
			
	
		
		
//		Calendar calendar = new GregorianCalendar(1991, 11, 12);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
//		System.out.println(sdf.format(calendar.getTime()));
		
//		JFrame jFrame = new JFrame("algo");
//		jFrame.setSize(300, 300);
//		jFrame.setLayout(new BorderLayout());
//		JPanel jPanelExt = new JPanel();
//		JPanel jPanelWest = new JPanel();
//		JPanel jPanelEast = new JPanel();
//		jPanelEast.add(new JTextArea("espero que este a la izquierda"));
//		jPanelWest.add(new JTextArea("espero que este a la derecha"));
//		
//		JPanel jPanel = new JPanel();
//		jPanel.add(new JTextArea("east"),BorderLayout.EAST);
//		jPanel.add(new JTextArea("west"),BorderLayout.WEST);
//		JPanel jPanel2 = new JPanel();
//		jPanel2.add(new JTextArea("north"),BorderLayout.NORTH);
//		jPanel2.add(new JTextArea("south"),BorderLayout.SOUTH);
//		jPanel2.setBackground(Color.BLUE);
//		jPanel.setBackground(Color.red);
//		jPanelExt.add(jPanel,BorderLayout.NORTH);
//		jPanelExt.add(jPanel2,BorderLayout.SOUTH);
//		
//		jFrame.add(jPanelExt, BorderLayout.CENTER);
//		jFrame.add(jPanelEast, BorderLayout.EAST);
//		jFrame.add(jPanelWest, BorderLayout.WEST);
//		jFrame.setVisible(true);
		
	}

}
