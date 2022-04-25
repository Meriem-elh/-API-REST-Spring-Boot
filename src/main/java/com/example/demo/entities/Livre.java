package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
@Table(name="Book")

public class Livre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	
	private Long id;
	@Column(length = 50)
	@NonNull
	private String titre;
	@Column(updatable=false)
	@NonNull
	
	private String mEdition;
	@Column
	@NonNull
	private Date dsortie;
	@Column
	@NonNull
	private String auteur;
	@Column
	@NonNull
	private int nbpages;
	@Column(unique=true,updatable=false)
	@NonNull
  
	private int ISBN;
	@Column
	@NonNull
	private Date dconsultation;
	@Column
	@NonNull
	private boolean disponibilite;

	

}
