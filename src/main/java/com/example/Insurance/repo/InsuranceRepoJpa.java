package com.example.Insurance.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Insurance.model.Insurance;

public interface InsuranceRepoJpa extends JpaRepository<Insurance, Integer>{

}
