package com.ifs.dao;

import java.util.List;

import com.ifs.entity.Trainer;
import com.ifs.entity.VirtualMachine;

public interface VirtualMachineDAO {

	public List<VirtualMachine> getVirtualMachines();

	public void saveVirtualMachine(VirtualMachine virtualMachine );

	public VirtualMachine getVirtualMachine(String theId);

	public void updateVirtualMachine(VirtualMachine virtualMachine, String sessionId);



}
