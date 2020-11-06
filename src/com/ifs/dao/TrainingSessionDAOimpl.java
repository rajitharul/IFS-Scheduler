package com.ifs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifs.entity.TrainingSession;

@Repository
public class TrainingSessionDAOimpl implements TrainingSessionDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<TrainingSession> getTrainingSessions() {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query 
		Query<TrainingSession> theQuery = currentSession.createQuery("from TrainingSession" , TrainingSession.class);
		
		//execute query and get result list
		
		List <TrainingSession> trainingSessions = theQuery.getResultList();
		
		//return the results 
		
		return trainingSessions;
		
	}


	@Override
	public void saveTrainingSession(TrainingSession trainingSession) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//save the trainingSession 
		
		currentSession.saveOrUpdate(trainingSession);
	}


	@Override
	public TrainingSession getTrainingSession(String theId) {
		//get the current hibernate session
		System.out.println("in the get trainer method in DAO Impl");

		Session currentSession = sessionFactory.getCurrentSession();
		
		TrainingSession trainingSession = currentSession.get(TrainingSession.class, theId);
				
		return trainingSession;
	}


	@Override
	public void updateTrainingSession(TrainingSession trainingSession, String sessionId) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//save the trainingSession 
		
		currentSession.update(sessionId, trainingSession);
		
		
	}

}
