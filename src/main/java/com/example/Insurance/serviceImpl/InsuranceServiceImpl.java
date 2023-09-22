package com.example.Insurance.serviceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Insurance.exception.ResourceNotFoundException;
import com.example.Insurance.model.Insurance;
import com.example.Insurance.repo.InsuranceRepoJpa;
import com.example.Insurance.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceRepoJpa repo;

	@Override
	public Insurance saveInsurance(Insurance insurance) {
		repo.save(insurance);
		return insurance;
	}

	@Override
	public List<Insurance> getInsurance() {
		List<Insurance> list = repo.findAll();
		return list;
	}

	@Override
	public Insurance getById(int id) {
		Optional<Insurance> insurance = repo.findById(id);
		if(insurance.isPresent()) {
			return insurance.get();
		}
		throw new ResourceNotFoundException("Insurance","Id",id);
	}

	@Override
	public Insurance updateInsurance(Insurance insurance, int id) {
		Insurance insurance2 = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance","Id",id));
		insurance2.setInsurance_name(insurance.getInsurance_name());
		insurance2.setProduct_name(insurance.getProduct_name());
		insurance2.setClient_status(insurance.getClient_status());
		insurance2.setPremium(insurance.getPremium());
		insurance2.setAge(insurance.getAge());
		repo.save(insurance2);
		return insurance2;
	}

	@Override
	public String deleteInsurance(int id) {
		Insurance insurance = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance","Id",id));
		repo.delete(insurance);
		return "Insurance deleted";
	}

}
