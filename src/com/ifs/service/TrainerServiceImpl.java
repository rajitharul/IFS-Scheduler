package com.ifs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifs.dao.LeaveApplicationDAO;
import com.ifs.dao.TrainerDAO;
import com.ifs.entity.LeaveApplication;
import com.ifs.entity.Trainer;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired

	private TrainerDAO trainerDAO;
	
	
	@Override
	@Transactional
	public Trainer getTrainer(String trainerId) {
		
		return trainerDAO.getTrainer(trainerId);
	}

	
	

}
