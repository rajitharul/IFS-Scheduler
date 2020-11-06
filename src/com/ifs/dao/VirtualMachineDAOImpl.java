package com.ifs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifs.entity.TrainingSession;
import com.ifs.entity.VirtualMachine;
import com.ifs.service.VirtualMachineService;

@Repository
public class VirtualMachineDAOImpl implements VirtualMachineDAO {

	
	
	//need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
		
	
	@Override
	public List<VirtualMachine> getVirtualMachines() {

		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query 
		Query<VirtualMachine> theQuery = currentSession.createQuery("from VirtualMachine" , VirtualMachine.class);
		
		//execute query and get result list
		
		List <VirtualMachine> virtualMachines = theQuery.getResultList();
		
		//return the results 
		
		return virtualMachines;
	
	}

	@Override
	public void saveVirtualMachine(VirtualMachine virtualMachine) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(virtualMachine);
		
		
	}

	@Override
	public VirtualMachine getVirtualMachine(String theId) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		
		VirtualMachine virtualMachine = currentSession.get(VirtualMachine.class, theId);
				
		return virtualMachine;
	}

	@Override
	public void updateVirtualMachine(VirtualMachine virtualMachine, String sessionId) {
		// TODO Auto-generated method stub

	}

}
