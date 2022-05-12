package lv.venta.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Grade {
	//1. mainīgie
			@Column(name="IdGr")
			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
			@Setter(value=AccessLevel.NONE)
			private int idGr;
			
			@Column(name="Value")
			private int value;
			//1. anotācijas izvēle
		@ManyToOne
		//3.izdomāt, kurā pusē būs otras tabulass PK jeb piesaistīts id
		//tajā pusē būs @joinColumns, otra pūse būs
		//mappedBy
		//3.1. mappedBy - uz mainīga nosaukumu
		//3.2. @JoinColumns - id kolonns nosaukumu
		@JoinColumn(name="IdCo")
		//2.izveidot otras klases mainīgo (viens vai kolekcija)
		private Course course;	
			
				
			
			
			
	
		@ManyToOne()
		@JoinColumn(name="IdSt")
		private Student student;






		public Grade(int value, Course course, Student student) {
			this.value = value;
			this.course = course;
			this.student = student;
		}
		
		
		
		
		
			
}
