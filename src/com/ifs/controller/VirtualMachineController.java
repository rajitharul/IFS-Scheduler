package com.ifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifs.entity.VirtualMachine;
import com.ifs.service.VirtualMachineService;

@Controller
@RequestMapping("/virtualMachine")
public class VirtualMachineController {

	
	//need to inject the Virtual Machine Service 
	@Autowired
	private VirtualMachineService virtualMachineService;
	
	
	
	
	@RequestMapping("/addVirtualMachine")
	public String addVirtualMachine(Model theModel) {
			
		//create Virtual Machine and add it to the model
		
		VirtualMachine virtualMachine = new VirtualMachine();
				
		theModel.addAttribute("virtualMachine",virtualMachine);
		

		return "VirtualMachine-form";

	}
	
	
	@RequestMapping("/saveVirtualMachine")
	public String saveVirtualMachine(@ModelAttribute("virtualMachine")VirtualMachine virtualMachine) {
			
		System.out.println(virtualMachine.getProduct());
		virtualMachineService.saveVirtualMachine(virtualMachine);
	

		return "VirtualMachine-form";

	}
	
	
}
