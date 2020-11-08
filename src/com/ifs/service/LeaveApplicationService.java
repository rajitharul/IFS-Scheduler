package com.ifs.service;

import java.util.List;

import com.ifs.entity.LeaveApplication;
import com.ifs.entity.TrainingSession;
import com.ifs.entity.VirtualMachine;

public interface LeaveApplicationService {

	public List<LeaveApplication> listAllLeaves();
	 
	 public void saveOrUpdate(LeaveApplication leaveapplication);
	 
	 public LeaveApplication findLeaveApplicationById(int id);
	 
	 public void deleteLeaveApplication(int id);


}
