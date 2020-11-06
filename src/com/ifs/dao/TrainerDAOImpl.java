package com.ifs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifs.entity.Trainer;
import com.ifs.entity.TrainingSession;
import com.ifs.service.TrainingSessionService;

@Repository
public class TrainerDAOImpl implements TrainerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Trainer getTrainer(String trainerId) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	
		Trainer trainer = currentSession.get(Trainer.class, trainerId);
		
		return trainer;
	}


}
