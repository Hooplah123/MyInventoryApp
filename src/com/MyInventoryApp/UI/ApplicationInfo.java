package com.MyInventoryApp.UI;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class ApplicationInfo {
	
	private String newNamePrompt = "Please enter your name: ";
	private String newUsernamePrompt = "Please enter the Username you would like to use: ";
	private String newPasswordPrompt = "Please enter the Password you would like to use: ";
	private String existingUsernamePrompt = "Please enter your Username: ";
	private String existingPasswordPrompt = "Please enter your password: ";

	public String getNewNamePrompt() {
		return newNamePrompt;
	}

	public void setNewNamePrompt(String newNamePrompt) {
		this.newNamePrompt = newNamePrompt;
	}
	public String getNewUsernamePrompt() {
		return newUsernamePrompt;
	}

	public void setNewUsernamePrompt(String newUsernamePrompt) {
		this.newUsernamePrompt = newUsernamePrompt;
	}

	public String getNewPasswordPrompt() {
		return newPasswordPrompt;
	}

	public void setNewPasswordPrompt(String newPasswordPrompt) {
		this.newPasswordPrompt = newPasswordPrompt;
	}

	public String getExistingUsernamePrompt() {
		return existingUsernamePrompt;
	}

	public void setExistingUsernamePrompt(String existingUsernamePrompt) {
		this.existingUsernamePrompt = existingUsernamePrompt;
	}

	public String getExistingPasswordPrompt() {
		return existingPasswordPrompt;
	}

	public void setExistingPasswordPrompt(String existingPasswordPrompt) {
		this.existingPasswordPrompt = existingPasswordPrompt;
	}


}