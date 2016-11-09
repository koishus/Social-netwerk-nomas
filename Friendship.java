package project;

public class Friendship implements Comparable<Object>{
	private Person Friend1;
	private Person Friend2;
	
	public Friendship(Person F1, Person F2){
		this.Friend1=F1;
		this.Friend2=F2;
	}
	
	public Person getFriend1(){
		return this.Friend1;
	}
	
	public Person getFriend2(){
		return this.Friend2;
	}
	
	@Override
	public String toString(){
		return (this.Friend1.getIdentifier() + "," + this.Friend2.getIdentifier());
	}
	
	@Override
	public boolean equals(Object obj){
		Friendship other = (Friendship) obj;
		boolean result = (this.Friend1.getIdentifier()==other.Friend1.getIdentifier()) && (this.Friend2.getIdentifier()== other.Friend2.getIdentifier());
		return result;
	}
	
	@Override
	public int compareTo(Object anobject) {
		Friendship otherFriendship = (Friendship) anobject;
		if (this.equals(otherFriendship))
			return 0;
		return (this.Friend1.getIdentifier().compareTo(otherFriendship.getFriend1().getIdentifier()));
	}

}
