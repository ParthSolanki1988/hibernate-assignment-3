package com.simform.transactional.controller;

import com.simform.transactional.dto.AppoinmentFormDto;
import com.simform.transactional.entity.Appointment;
import com.simform.transactional.service.BookAppoinmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appoinments")
public class BookAppoinmentController {

  @Autowired
  BookAppoinmentService bookAppoinmentService;

  //POST : localhost:8080/api/v1/bookappoinments

  @PostMapping
  public String bookApppointment(@RequestBody AppoinmentFormDto appoinmentFormDto) {
    return bookAppoinmentService.bookAppoinment(appoinmentFormDto);
  }

  //GET : localhost:8080/api/v1/bookappoinments

  @GetMapping
  public List<Appointment> getAllAppoinment() {
    return bookAppoinmentService.getAllAppoinment();
  }


  //GET : localhost:8080/api/v1/bookappoinments/{id}

  @GetMapping("{id}")
  public Appointment getById(@PathVariable("id") Long id){
    return bookAppoinmentService.getById(id);
  }




}
