package com.ifs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifs.entity.TrainingSession;
import com.ifs.service.TrainingSessionService;

@Controller
@RequestMapping("/trainingSession")
public class TrainingSessionController {
	

	//need to inject the customer Service 
	@Autowired
	private TrainingSessionService trainingSessionservice;
	
	
	
	
	@RequestMapping("/listSessions")
	public String showForm(Model theModel) {
	
		
		//get the Training Sessions from the service method
		
		List <TrainingSession> trainingSessions = trainingSessionservice.getTrainingSessions();
		//add the customers to the model
		theModel.addAttribute("trainingSessions",trainingSessions);
		

		return "list-trainingSessions";

	}
	

	@RequestMapping("/addTrainingSession")
	public String showaddTrainingSessionForm(Model theModel) {
			
		//create training Session and add it to the model
		
		TrainingSession trainingSession = new TrainingSession();
				
		theModel.addAttribute("trainingSession",trainingSession);
		

		return "trainingSession-form";

	}
	
	
	@RequestMapping("/saveTrainingSession")
	public String saveTrainingSessionForm(@ModelAttribute("trainingSession")TrainingSession trainingSession) {
			
		trainingSessionservice.saveTrainingSession(trainingSession);
		
		
		return "redirect:/trainingSession/listSessions";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate (Model theModel){
		
		
		//get the customer from the service 
		TrainingSession trainingSession  = new TrainingSession();
				
		//set customer as a model attribute to pre-populate the form 
		
		//delete this after check temp codesssssss
		
			
		theModel.addAttribute("trainingSession" , trainingSession);
		
		//send over to out form
	
		
		return "update-trainingSession-form2";
		
	}
	
	

	
	
	@RequestMapping("/updateTrainingSession")
	public String updateTrainingSessionForm(@ModelAttribute("trainingSession")TrainingSession trainingSession) {
		
		System.out.println("updating traingini Session " + trainingSession ); 	
		
		String sessionId = trainingSession.getSessionId();
		
		trainingSessionservice.updateTrainingSession(trainingSession,sessionId);
		
		return "redirect:/trainingSession/listSessions";

	}
	
	
	
	
	
}
