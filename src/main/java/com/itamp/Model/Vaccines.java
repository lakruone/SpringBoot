package com.itamp.Model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="vaccines")
public class Vaccines {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="vaccinename")
	private String vaccinename;
	
	@Column(name="dos")
	private float dos;
	
	@Column(name="timerange")
	private String timerange;

}
