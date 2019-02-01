package com.itamp.Model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="vaccineprofile")
public class VaccineProfile {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="profileId")
   private Long profileId;
   @Column(name="currentVaccine")
   private String currentVaccine;
   
   
  
}
