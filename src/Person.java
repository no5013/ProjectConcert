//elab-source: Person.java
public class Person {
	private String ID;
	private String name;
	private String lastname;
	private String gender;
	
	public Person() {
		ID="";
		name="";
		lastname="";
		gender="";
	}
	public Person(String newID,String newName,String newLastname,String newGender) {
		ID = newID;
		name = newName;
		lastname = newLastname;
		gender = newGender;
	}
	public String getId() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getLastname() {
		return lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setId (String newID) {
		ID = newID;
	}
	public void setName (String newName) {
		name = newName;
	}
	public void setLastname(String newLastname) {
		lastname = newLastname;
 	}
	public void setGender(String newGender) {
		gender = newGender;
	}
	public boolean equals(Person key){
		boolean checkP = false;
		if(ID.equals(key.getId())&&name.equals(key.getName())&&lastname.equals(key.getLastname())&&gender.equals(key.getGender())){
			checkP = true;
		}
		return checkP;
	}
	public String toString() {
		return ID+", "+name+" "+lastname+", "+gender;
	}
	
	public String writeFile(){
		return ID+" "+name+" "+lastname+" "+gender;
	}
}
