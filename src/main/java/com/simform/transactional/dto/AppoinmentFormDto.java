package com.simform.transactional.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Lombok;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppoinmentFormDto {
  private String name;

  private String gender;

  private Long phone;

  private int age;


}
