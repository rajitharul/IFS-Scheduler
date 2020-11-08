package com.ifs.dao;

import java.util.List;

import com.ifs.entity.LeaveApplication;

public interface LeaveApplicationDAO {

	public List<LeaveApplication> listAllLeaves();
	 
	 public void saveOrUpdate(LeaveApplication leaveapplication);
	 
	 public LeaveApplication findLeaveApplicationById(int id);
	 
	 public void deleteLeaveApplication(int id);

}
