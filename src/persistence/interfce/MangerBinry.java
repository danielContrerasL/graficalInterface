package persistence.interfce;

import java.io.RandomAccessFile;

import Entity.Person;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MangerBinry extends RandomAccessFile {
	private String fileNme;
	
	public String getFileNme() {
		return fileNme;
	}

	public void setFileNme(String fileNme) {
		this.fileNme = fileNme;
	}


	public MangerBinry(String fileNme,String mode) throws FileNotFoundException {
		super(fileNme, mode);
		this.fileNme = fileNme;
	}
	
	
	
}
