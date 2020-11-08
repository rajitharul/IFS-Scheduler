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
public class LeaveApplicationServiceImpl implements LeaveApplicationService {

	@Autowired
	private LeaveApplicationDAO leaveApplicationDAO;
	
	@Autowired
	private TrainerDAO trainerDAO;
	
	
	
	@Override
	@Transactional
	public List<LeaveApplication> listAllLeaves() {

		return leaveApplicationDAO.listAllLeaves();
	}

	@Override
	@Transactional
	public void saveOrUpdate(LeaveApplication leaveapplication) {
		System.out.println("int the form");
	
		Trainer trainer = trainerDAO.getTrainer(leaveapplication.getTrainerid());
				
		System.out.println(trainer);
		
		leaveapplication.setTrainer(trainer);
		
		leaveApplicationDAO.saveOrUpdate(leaveapplication);
		
	}

	@Override
	@Transactional
	public LeaveApplication findLeaveApplicationById(int id) {

		return leaveApplicationDAO.findLeaveApplicationById(id);
	}

	@Override
	@Transactional
	public void deleteLeaveApplication(int id) {
		leaveApplicationDAO.deleteLeaveApplication(id);
		
	}

}
