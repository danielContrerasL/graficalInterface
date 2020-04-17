package Entity;

public class Person {
	private String name;
	private String lastName;
	private String gender;
	private int code;
	private int ownerCode;

	public int getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(int ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return name + " " + lastName;
	}

}
