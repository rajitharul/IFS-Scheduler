package com.ifs.dao;

import java.util.List;

import com.ifs.entity.TrainingSession;


public interface TrainingSessionDAO {

	public List<TrainingSession> getTrainingSessions();	

	public void saveTrainingSession(TrainingSession trainingSession);

	public TrainingSession getTrainingSession(String theId);

	public void updateTrainingSession(TrainingSession trainingSession, String sessionId);

	
}
