package com.infytel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infytel.entity.SimDetails;
import com.infytel.entity.SimOffers;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetails, Long> {
	
	@Query(value = "select s from SimDetails s where s.serviceNumber = ?1 and s.simNumber = ?2")
	public SimDetails findByServiceNumberAndSimNumber(Long serviceNumber, Long simNumber);
	
	@Query(value = "select s from SimDetails s where s.customer.uniqueIdNumber = ?1")
	public SimDetails findByCustomerId(Long customerId);
	
}
