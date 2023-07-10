package com.simform.transactional.repository;

import com.simform.transactional.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AppoinmentRepository extends JpaRepository<Appointment , Long> {

}
