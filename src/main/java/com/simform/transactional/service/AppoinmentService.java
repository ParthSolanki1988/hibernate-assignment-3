package com.simform.transactional.service;

import com.simform.transactional.entity.Appointment;
import com.simform.transactional.repository.AppoinmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppoinmentService {
  @Autowired
  AppoinmentRepository appoinmentRepository;


  public Appointment createAppointment(Appointment appointment){
    Appointment save = appoinmentRepository.save(appointment);
    return save;
  }

  public List<Appointment> getAllAppoinment() {
    List<Appointment> allAppoinment = appoinmentRepository.findAll();
    return allAppoinment;
  }
}
