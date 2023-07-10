package com.simform.transactional.service;

import com.simform.transactional.entity.Appointment;
import com.simform.transactional.entity.Patient;
import com.simform.transactional.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PatientService {
  @Autowired
  PatientRepository patientRepository;

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Patient createPatient(Patient patient){
    log.info("Business logic here");
    Patient save = patientRepository.save(patient);
    return save;
  }

  public List<Patient> getAllPatient() {
    List<Patient> allPatient = patientRepository.findAll();
    return allPatient;
  }
}
