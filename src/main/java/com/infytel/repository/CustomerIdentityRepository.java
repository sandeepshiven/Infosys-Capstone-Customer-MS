package com.infytel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infytel.entity.CustomerIdentity;

@Repository
public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity, Long> {

}
