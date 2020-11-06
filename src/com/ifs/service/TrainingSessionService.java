package com.ifs.service;

import java.util.List;

import com.ifs.entity.TrainingSession;

public interface TrainingSessionService {

	public List<TrainingSession> getTrainingSessions();

	public void saveTrainingSession(TrainingSession trainingSession );

	public TrainingSession getTrainingSession(String theId);

	public void updateTrainingSession(TrainingSession trainingSession, String sessionId);


}
