package com.example.Insurance.service;
import java.util.List;
import com.example.Insurance.model.Insurance;

public interface InsuranceService {

	Insurance saveInsurance(Insurance insurance);
	
	List<Insurance> getInsurance();
	
	Insurance getById(int id);
	
	Insurance updateInsurance(Insurance insurance, int id);
	
	String deleteInsurance(int id);
	
}
