package lv.venta.demo.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Course {
	@Column(name="IdCo")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(value=AccessLevel.NONE)
	private int idCo;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Cp")
	private int cp;
	
	//vairākiem kursim ir viens pasniedzējs
	//@ManyToOne
	//@JoinColumn(name="IdPr")
	//private Professor professor;

	
	//viens-pret-viens
	@OneToOne
	@JoinColumn(name="IdPr")
	private Professor professor;

	
	//1. anotācijas izvēle
	//3.izdomāt, kurā pusē būs otras tabulass PK jeb piesaistīts id
	//tajā pusē būs @joinColumns, otra pūse būs
	//mappedBy
	//3.1. mappedBy - uz mainīga nosaukumu
	//3.2. @JoinColumns - id kolonns nosaukumu
	@OneToMany(mappedBy="course")
	//4.toString.exclude izmantošana vienā pusē
	@ToString.Exclude
	//2.izveidot otras klases mainīgo (viens vai kolekcija)
	private Collection<Grade> grades;
	
	

	public Course(String title, int cp, Professor professor) {
		this.title = title;
		this.cp = cp;
		this.professor = professor;
	}

	

}
