package project;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.DefaultListModel;

import DSA.DoubleOrderedList;

public class FriendList {
	private DoubleOrderedList<Friendship> list = new DoubleOrderedList<Friendship>();
	private String path2Friends = "friends.txt";
	private PersonList Plist = new PersonList();
	
	public void initFriends() throws IOException{
		File input = new File(path2Friends);
		if(!input.exists()){
			input.createNewFile();
			PrintWriter wrt = new PrintWriter(input);
			wrt.println("friend1,friend2");
			wrt.close();
		}else{
			updateFriends(input);
		}
	}
	public DefaultListModel<String> populateFriends(){
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		Iterator<Friendship> itr = list.iterator();
		while (itr.hasNext()){
			listModel.addElement(itr.next().toString());
		}
		return listModel;
	}
	public void updateFriends(File input) throws IOException {
		Scanner read = new Scanner(input);
		Friendship friends;
		String data;
		String[] tokens;
		read.nextLine();
		Plist.initialize();
		while (read.hasNextLine()){
			data = read.nextLine();
			tokens = data.split(",");
			if (Plist.contains(new Person(tokens[0])) && Plist.contains(new Person(tokens[1]))){
				friends = new Friendship(new Person(tokens[0]), new Person(tokens[1]));
				list.add(friends);
			}
		}
		read.close();
		PrintWriter wrt = new PrintWriter(new File (path2Friends));
		wrt.println("friend1,friend2");
		Iterator<Friendship> itr = list.iterator();
		while(itr.hasNext()){
			wrt.println(itr.next());
		}
		wrt.close();
	}
	public PersonList getFriends (Person P){
		Iterator<Friendship> itr = list.iterator();
		Friendship F;
		PersonList Perlist = new PersonList();
		while (itr.hasNext()){
			F = itr.next();
			if(F.getFriend1().equals(P)){
				Perlist.addPerson(P);
			}
		}
		return Perlist;
	}

}
