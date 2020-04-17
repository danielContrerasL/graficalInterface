package logic;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Person;
import persistence.interfce.Iperdistence;

public class PersonLogic {
	@SuppressWarnings("unused")
	private PersonFileTxt fileTxt;
	private Iperdistence iperdistence;

	public PersonLogic() {
		fileTxt = new PersonFileTxt(PersonFileTxt.TABLE_INFORMATION);
	}

	public void save(Person person) throws Exception {
		validateCharaterChain(person.getName());
		validateCharaterChain(person.getLastName());
		validateGender(person.getGender());
		if (iperdistence == null) {
			throw new IOException("No Persistence");
		}
		iperdistence.svePerson(person);
	}

	public void validateGender(String gender) throws Exception {
		if (gender.equals("n")) {
			throw new Exception("Definir Genero");
		}
	}

	public void validateCharaterChain(String name) throws Exception {
		if (name == null || name.length() < 3) {
			throw new Exception(name + ": Etencion invalida");
		}
	}

	public ArrayList<Person> load() throws IOException {
		if (iperdistence == null) {
			throw new IOException("No Persistence");
		}
		return iperdistence.lodPerson();
	}

	public void setPersistence(Iperdistence iperdistence) {
		this.iperdistence = iperdistence;
	}

	public void setIperdistence(Iperdistence iperdistence) {
		this.iperdistence = iperdistence;
	}

}
