package com.simform.transactional.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "pat_name")
  private String name;

  @Column(name = "age")
  private int age;

  @Column(name = "mobile")
  private String phone;

  @Column(name = "gender")
  private String gender;

}
