package com.simform.transactional.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;


  @Column(name = "apt_no")
  private int appointmentNo;

  @Column(name = "apt_date")
  private Date date;

  @Column(name = "doctor_no")
  private Long doctorNo;

  @Column(name = "pat_No")
  private int patientNo;
}
