package com.ifs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifs.dao.TrainerDAO;
import com.ifs.dao.TrainingSessionDAO;
import com.ifs.dao.VirtualMachineDAO;
import com.ifs.entity.TrainingSession;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {

	
	@Autowired
	private TrainingSessionDAO trainingSessionDAO;
	
	@Autowired
	private TrainerDAO trainerDAO;
	
	@Autowired
	private VirtualMachineDAO virtualMachineDAO;
	
	@Override
	@Transactional
	public List<TrainingSession> getTrainingSessions() {
		
		return trainingSessionDAO.getTrainingSessions();
	}


	@Override
	@Transactional
	public void saveTrainingSession(TrainingSession trainingSession) {

		//add trainers to the training Session 
		
		
		for(int i=0 ; i<trainingSession.gettrainerids().length ; i++) {
			
			System.out.println(trainerDAO.getTrainer(trainingSession.gettrainerids()[i]).getName());
			
			trainingSession.add(trainerDAO.getTrainer(trainingSession.gettrainerids()[i]));
			
		}		
		
		
		//add VMs to the Training Sessionn
		
	for(int i=0 ; i<trainingSession.getVmIds().length ; i++) {
			

			trainingSession.addVM(virtualMachineDAO.getVirtualMachine(trainingSession.getVmIds()[i]));
			
		}		
		
		
		
		
		
		trainingSessionDAO.saveTrainingSession(trainingSession);
		
	}


	@Override
	@Transactional
	public TrainingSession getTrainingSession(String theId) {

		TrainingSession trainingSession = trainingSessionDAO.getTrainingSession(theId);
		
		return trainingSession;
	}


	@Override
	@Transactional
	public void updateTrainingSession(TrainingSession trainingSession, String sessionId) {

		
	//add trainers to the training Session 
		
			trainingSession.setTrainers(null);
		
		for(int i=0 ; i<trainingSession.gettrainerids().length ; i++) {
			
			System.out.println(trainerDAO.getTrainer(trainingSession.gettrainerids()[i]).getName());
			
			trainingSession.add(trainerDAO.getTrainer(trainingSession.gettrainerids()[i]));
			
		}		
		
		
		//add VMs to the Training Sessionn
		trainingSession.setVirtualMachines(null);

		
	for(int i=0 ; i<trainingSession.getVmIds().length ; i++) {
			

			trainingSession.addVM(virtualMachineDAO.getVirtualMachine(trainingSession.getVmIds()[i]));
			
		}		
		
		
		trainingSessionDAO.updateTrainingSession(trainingSession,sessionId);
	}

}



	

