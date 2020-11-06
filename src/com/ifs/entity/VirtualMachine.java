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
@Table(name = "virtual_machine")
public class VirtualMachine {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vm_id")
	private  String virtualMachineId;
	
	@Column(name = "product")
    private  String product;
	
	@Column(name = "version")
    private  String version;

	@Column(name = "region")
    private  String region;

	@Column(name = "status")
    private  String status;

	
	
	public String getVirtualMachineId() {
		return virtualMachineId;
	}

	public void setVirtualMachineId(String virtualMachineId) {
		this.virtualMachineId = virtualMachineId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public VirtualMachine() {
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name = "training_session_virtual_machine",
			joinColumns = @JoinColumn(name = "vm_id"),
			inverseJoinColumns = @JoinColumn(name = "s_id")
			)
	
	private List<TrainingSession> trainingSessions;
	
	
	

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
