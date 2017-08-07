package main.control.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import main.model.Friend;

public class FriendController {
	OwnwerController ownwerController;
		String friendPath;
		int id = 0;
		
		public FriendController() {
			// TODO Auto-generated constructor stub
		}
		public FriendController(String source, OwnwerController ownwerController){
			friendPath = source;
			this.ownwerController = ownwerController;
			readFriends();
		}
		
	private ArrayList<Friend> readFriends() {
			// TODO Auto-generated method stub
			ArrayList<Friend> friends = new ArrayList<Friend>();
			try {
				Scanner scanner = new Scanner(new File(friendPath));
				while (scanner.hasNextLine()){
					String [] strings = scanner.nextLine().split(";");
					String mail=strings[4];
					long celNumber = Long.parseLong(strings[5].length()==0?"0":strings[5]);
					String name =strings[1];
					String lastName= strings[2];
					boolean adeuda =Boolean.parseBoolean(strings[3]);
					if (mail.length()==0) {
						addFriend(id, name, lastName, adeuda);
					}else{
						addFriend(mail, id, celNumber, name, lastName, adeuda);
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return friends;
		}
	public void	writeFriends(){
		try {
			FileWriter fWriter = new FileWriter(new File(friendPath),true);
			if(ownwerController.getOwner().getFriends().isEmpty()){
				fWriter.write(ownwerController.getOwner().getFriends().toString());
				fWriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addFriend (String mail, int id, long celNumber, String name, String lastName,boolean adeuda){
//		ownwerController.getOwner().AddFriend(new Friend(mail, id, celNumber, name, lastName,adeuda));
		id++;
	}
	public void addFriend (int id, String name, String lastName, boolean adeuda){
//	ownwerController.getOwner().AddFriend(new Friend(id,name, lastName,adeuda));
	id++;
	}
}
