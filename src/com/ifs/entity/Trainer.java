package com.ifs.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "trainer_detail")
public class Trainer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private  String trainerId;
	
	@Column(name = "name")
    private  String name;
	
	@Column(name = "Type")
    private  String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Trainer() {
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name = "training_session_trainer",
			joinColumns = @JoinColumn(name = "trainer_id"),
			inverseJoinColumns = @JoinColumn(name = "training_session_id")
			)
	
	private List<TrainingSession> trainingSessions;
	
	
	
	
	public Trainer(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public List<TrainingSession> getTrainingSessions() {
		return trainingSessions;
	}

	public void setTrainingSessions(List<TrainingSession> trainingSessions) {
		this.trainingSessions = trainingSessions;
	}

	
	//adding a convenience method
	
	
	public void add(TrainingSession tempSession) {
		
		if(trainingSessions ==null) {
			
			trainingSessions = new ArrayList<TrainingSession>();
			
		}
		
		trainingSessions.add(tempSession);
		
		
	}
	
	
	
	
}
