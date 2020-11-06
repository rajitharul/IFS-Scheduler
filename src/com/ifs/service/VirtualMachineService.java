package com.ifs.service;

import java.util.List;

import com.ifs.entity.TrainingSession;
import com.ifs.entity.VirtualMachine;

public interface VirtualMachineService {

	public List<VirtualMachine> getVirtualMachines();

	public void saveVirtualMachine(VirtualMachine virtualMachine );

	public VirtualMachine getVirtualMachine(String theId);

	public void updateVirtualMachine(VirtualMachine virtualMachine, String sessionId);


}
