package com.ifs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifs.entity.LeaveApplication;
import com.ifs.entity.VirtualMachine;

@Repository
public class LeaveApplicationDAOImpl implements LeaveApplicationDAO {
	
	

	
	//need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
		

	@Override
	public List<LeaveApplication> listAllLeaves() {

		//get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				//create a query 
				Query<LeaveApplication> theQuery = currentSession.createQuery("from LeaveApplication" , LeaveApplication.class);
				
				//execute query and get result list
				
				List <LeaveApplication> leaveApplications = theQuery.getResultList();
		
		
		return leaveApplications;
	}

	@Override
	public void saveOrUpdate(LeaveApplication leaveapplication) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(leaveapplication);
		
		
	}

	@Override
	public LeaveApplication findLeaveApplicationById(int id) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		LeaveApplication leaveApplication = currentSession.get(LeaveApplication.class, id);
		
		return leaveApplication;
	}

	@Override
	public void deleteLeaveApplication(int id) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		LeaveApplication leaveApplication = currentSession.get(LeaveApplication.class, id);
		
		currentSession.delete(leaveApplication);
		
		
	}

}
