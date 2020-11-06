package com.ifs.entity;

import java.beans.Transient;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "training_session")
public class TrainingSession {
	
	@javax.persistence.Transient
	public String [] trainerids;
	
	@javax.persistence.Transient
	public String [] vmIds;
		

		public String[] getVmIds() {
		return vmIds;
	}

	public void setVmIds(String[] vmIds) {
		this.vmIds = vmIds;
	}


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "session_id")
		private  String sessionId;

	    
		@Column(name = "session_name")
	    private  String sessionName;

	    
		@Column(name = "starting_date")
	    @Temporal(TemporalType.DATE)    
	    private  Date startDate;

	    
		@Column(name = "duration")
	    private  int duration;

	    
		@Column(name = "max_participation")
	    private  int maxParticipants;

	    
		@Column(name = "ifs_applicationversion")

	    private  String ifsApplicationVersion;

	    
		@Column(name = "buffer_time")

	    private  int bufferTime;

	    
		@Column(name = "manager_comment")

	    private  String managerComment;

	    
		@Column(name = "delivery_method")

	    private  String deliveryMethod;
	    
	    
		
		@ManyToMany(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
		@JoinTable(
				name = "training_session_trainer",
				joinColumns = @JoinColumn(name = "training_session_id"),
				inverseJoinColumns = @JoinColumn(name = "trainer_id")
				)
		
		private List<Trainer> trainers;
		



			public List<Trainer> getTrainers() {
			return trainers;
		}

		public void setTrainers(List<Trainer> trainers) {
			this.trainers = trainers;
		}

		
		
	    
	    public TrainingSession( String sessionName,  int duration,
				 int maxParticipants,  String ifsApplicationVersion,  int bufferTime,
				 String managerComment,  String deliveryMethod) {
			super();
			this.sessionName = sessionName;
			this.duration = duration;
			this.maxParticipants = maxParticipants;
			this.ifsApplicationVersion = ifsApplicationVersion;
			this.bufferTime = bufferTime;
			this.managerComment = managerComment;
			this.deliveryMethod = deliveryMethod;
		}

		public TrainingSession() {
			// TODO Auto-generated constructor stub
		}

		public String getSessionId() {
			return sessionId;
		}

		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}

		public String getSessionName() {
			return sessionName;
		}

		public void setSessionName(String sessionName) {
			this.sessionName = sessionName;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public int getMaxParticipants() {
			return maxParticipants;
		}

		public void setMaxParticipants(int maxParticipants) {
			this.maxParticipants = maxParticipants;
		}

		public String getIfsApplicationVersion() {
			return ifsApplicationVersion;
		}

		public void setIfsApplicationVersion(String ifsApplicationVersion) {
			this.ifsApplicationVersion = ifsApplicationVersion;
		}

		public int getBufferTime() {
			return bufferTime;
		}

		public void setBufferTime(int bufferTime) {
			this.bufferTime = bufferTime;
		}

		public String getManagerComment() {
			return managerComment;
		}

		public void setManagerComment(String managerComment) {
			this.managerComment = managerComment;
		}
		
		
		public String [] gettrainerids() {
			return trainerids;
		}

		public void settrainerids(String [] trainerids) {
			this.trainerids = trainerids;
		}

		
		
		
		
		
		

		public String getDeliveryMethod() {
			return deliveryMethod;
		}

		public void setDeliveryMethod(String deliveryMethod) {
			this.deliveryMethod = deliveryMethod;
		}

		
		//adding a convenience method
		
		
		public void add(Trainer tempTrainer) {
			
			if(trainers ==null) {
				
				trainers = new ArrayList<Trainer>();
				
			}
			
			trainers.add(tempTrainer);
			
			
		}
		
		
		@ManyToMany(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
		@JoinTable(
				name = "training_session_virtual_machine",
				joinColumns = @JoinColumn(name = "s_id"),
				inverseJoinColumns = @JoinColumn(name = "vm_id")
				)
		
		private List<VirtualMachine> virtualMachines;




		public List<VirtualMachine> getVirtualMachines() {
			return virtualMachines;
		}

		public void setVirtualMachines(List<VirtualMachine> virtualMachines) {
			this.virtualMachines = virtualMachines;
		}
		
		//add a convience method to add virtual machines 
			public void addVM(VirtualMachine virtualMachine) {
			
			if(virtualMachines ==null) {
				
				virtualMachines = new ArrayList<VirtualMachine>();
				
			}
			
			virtualMachines.add(virtualMachine);
			
			
		}
		
		

	
	
}
