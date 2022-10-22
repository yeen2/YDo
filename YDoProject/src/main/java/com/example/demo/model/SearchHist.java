package com.example.demo.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Data
@Entity
@Table(name = "search_hist")
public class SearchHist implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String sno;
	@Id
	private String id;
	@Id
	private String serailNo;
	private String regdate;
	private String delYn;
	
}
