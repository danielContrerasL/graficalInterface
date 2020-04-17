package config;

import java.io.IOException;


public class HandlerLanguage {
	
	private String fileNameLanguageUsed;
	public static String language ="";
	
	public HandlerLanguage(String fileName) {
		this.fileNameLanguageUsed = fileName;
	}
	
	public void loadLanguage() throws IOException {
		HandlerProperties handlerProperties =  new HandlerProperties(fileNameLanguageUsed);
		language = handlerProperties.getProperty("language");
	}
	
	public void saveLanguage() throws IOException {
		HandlerProperties  handlerProperties =  new HandlerProperties(fileNameLanguageUsed);
		handlerProperties.setProperty("language", language);
		handlerProperties.save();
	}

}
