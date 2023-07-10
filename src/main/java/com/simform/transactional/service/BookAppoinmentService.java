package com.simform.transactional.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simform.transactional.dto.AppoinmentFormDto;
import com.simform.transactional.entity.Appointment;
import com.simform.transactional.entity.Patient;
import com.simform.transactional.repository.AppoinmentRepository;
import com.simform.transactional.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BookAppoinmentService {

  @Autowired
  AppoinmentRepository appoinmentRepository;

  @Autowired
  PatientService patientService;

  @Transactional(propagation = Propagation.REQUIRED , isolation = Isolation.SERIALIZABLE)
  public String bookAppoinment(AppoinmentFormDto appoinmentFormDto){
    Patient patient = new ObjectMapper().convertValue(appoinmentFormDto, Patient.class);
    patientService.createPatient(patient);
    int id = patient.getId();
    System.out.println("Save Patient .......................");

    /**
     * give null pointer exception
     */
//    appoinmentRepository = null;

    Appointment appointment = Appointment.builder()
            .date(new Date(System.currentTimeMillis()))
            .doctorNo(101L)
            .patientNo(id)
            .build();

    int appointmentNo = appoinmentRepository.save(appointment).getId();
    return "Appoinment Booked Id : " + appointmentNo;
  }

  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public List<Appointment> getAllAppoinment() {
    return appoinmentRepository.findAll();
  }


//  @Transactional(isolation = Isolation.READ_COMMITTED)
//  public List<Appointment> getAllAppoinment() {
//    return appoinmentRepository.findAll();
//  }

  /**
   * start transaction;
   * update appointment set doctor_no=120 where id=1;
   * hit getById() method in postman --> without  coommit update value show in postman, it is  dirty read
   * @param id
   * @return
   */
  @Transactional(isolation = Isolation.READ_UNCOMMITTED)
  public Appointment getById(Long id) {
    return appoinmentRepository.findById(id).get();
  }

}
