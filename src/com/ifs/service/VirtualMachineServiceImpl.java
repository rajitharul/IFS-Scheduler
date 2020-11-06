package com.ifs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifs.dao.VirtualMachineDAO;
import com.ifs.entity.VirtualMachine;

@Service
public class VirtualMachineServiceImpl implements VirtualMachineService {
	

	@Autowired
	private VirtualMachineDAO virtualMachineDAO;
	



	@Override
	@Transactional
	public List<VirtualMachine> getVirtualMachines() {
	
		
		return virtualMachineDAO.getVirtualMachines();
	}

	@Override
	@Transactional
	public void saveVirtualMachine(VirtualMachine virtualMachine) {

		virtualMachineDAO.saveVirtualMachine(virtualMachine);
	}

	@Override
	@Transactional
	public VirtualMachine getVirtualMachine(String theId) {

		
		return virtualMachineDAO.getVirtualMachine(theId);
	}

	@Override
	@Transactional
	public void updateVirtualMachine(VirtualMachine virtualMachine, String sessionId) {

		virtualMachineDAO.updateVirtualMachine(virtualMachine, sessionId);
		
	}

}
