package com.ifs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifs.entity.LeaveApplication;
import com.ifs.entity.TrainingSession;
import com.ifs.service.LeaveApplicationService;

@Controller
@RequestMapping("/leaveApplication")
public class LeaveApplicationController {
	

	//need to inject the customer Service 
	@Autowired
	private LeaveApplicationService  leaveApplicationservice;
	
	
	
	
	@RequestMapping("/listApplications")
	public String showForm(Model theModel) {
	
		
		//get the Training Sessions from the service method
		
		List <LeaveApplication> leaveApplications = leaveApplicationservice.listAllLeaves();
		
		//add the Leave applications to the model
		theModel.addAttribute("leaveApplications",leaveApplications);
		

		return "list-leaveApplications";

	}
	

	@RequestMapping("/addLeaveApplication")
	public String showaddLeaveApplicationForm(Model theModel) {
			
		//create training Session and add it to the model
		
		LeaveApplication leaveApplication = new LeaveApplication();
				
		theModel.addAttribute("leaveApplication",leaveApplication);
		

		return "leaveApplication-form";

	}
	
	
	@RequestMapping("/saveLeaveApplication")
	
	public String saveLeaveApplication(@ModelAttribute("leaveApplication")LeaveApplication leaveApplication) {
			
		leaveApplicationservice.saveOrUpdate(leaveApplication);
		
		
		return "redirect:/leaveApplication/listApplications";

	}

	
	
	
	
	
}
