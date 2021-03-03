package ut.set.sn.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RendezVous {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, updatable = false)
	private String codeRv;
	private String description;
	private String lieu;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate date;
	public RendezVous() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RendezVous(String codeRv, String description, String lieu, LocalDate date) {
		super();
		this.codeRv = codeRv;
		this.description = description;
		this.lieu = lieu;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodeRv() {
		return codeRv;
	}
	public void setCodeRv(String codeRv) {
		this.codeRv = codeRv;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
