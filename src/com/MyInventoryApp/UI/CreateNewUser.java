package com.MyInventoryApp.UI;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.MyInventoryApp.DTO.User;
import com.MyInventoryApp.Service.IUserService;

@Named
@ManagedBean
@Scope("session")
public class CreateNewUser {
	
	@Inject
	private User user;
	
	@Inject
	private IUserService userService;
	
	public String execute() {
		String returnValue = "success";
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		try {
			userService.save(user);
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "User Saved");
			//display the message
			currentInstance.addMessage(null, fm);
		} catch (Exception e) {
			e.printStackTrace();
			
			//what is the message we want to show?
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to Save", "User Not Saved");
			//display the message
			currentInstance.addMessage(null, fm);
			returnValue = "failure";
		}
		
		return returnValue;	
	}


}