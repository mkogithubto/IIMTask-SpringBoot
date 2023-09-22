package com.example.Insurance.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Insurance.model.Insurance;
import com.example.Insurance.service.InsuranceService;

@RestController
public class InsuranceController {
	
	@Autowired
	InsuranceService service;
	
	@PostMapping("addInsurance")
	public ResponseEntity<Insurance> saveInsurance(@RequestBody Insurance insurance){
		return new ResponseEntity<Insurance>(service.saveInsurance(insurance),HttpStatus.CREATED);
	}
	
	@GetMapping("allInsurances")
	public List<Insurance> getInsurance(){
		return service.getInsurance();
	}
	
	@GetMapping("Insurance/{id}")
	public ResponseEntity<Insurance> getById(@PathVariable("id") int id){
		return new ResponseEntity<Insurance>(service.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("Update/{id}")
	public ResponseEntity<Insurance> updateInsurance(@RequestBody Insurance insurance, @PathVariable("id") int id){
		return new ResponseEntity<Insurance>(service.updateInsurance(insurance,id),HttpStatus.OK);
	}
	
	@DeleteMapping("Delete/{id}")
	public String deleteInsurance(@PathVariable("id") int id){
		return service.deleteInsurance(id);
	}
}
