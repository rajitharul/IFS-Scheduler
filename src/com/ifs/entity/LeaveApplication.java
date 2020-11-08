package com.ifs.entity;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Entity
@Table(name = "leave_application")
public class LeaveApplication {
	
	
	@javax.persistence.Transient
	public String trainerid;

	public String getTrainerid() {
		return trainerid;
	}


	public void setTrainerid(String trainerid) {
		this.trainerid = trainerid;
	}


	public LeaveApplication(Date date, int duration, Trainer trainer) {
		this.date = date;
		this.duration = duration;
		this.trainer = trainer;
	}


	public LeaveApplication() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "l_id")
	private  String l_id;

	@Column(name = "date")
    @Temporal(TemporalType.DATE)    
    private  Date date;
    
	@Column(name = "duration")
    private  int duration;

	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "t_id")
	private Trainer trainer;


	public String getL_id() {
		return l_id;
	}


	public void setL_id(String l_id) {
		this.l_id = l_id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public Trainer getTrainer() {
		return trainer;
	}


	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
		
		
	
}
