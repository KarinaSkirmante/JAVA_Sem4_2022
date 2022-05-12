package lv.venta.demo.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Student {
	//1. mainīgie
		@Column(name="IdSt")
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Setter(value=AccessLevel.NONE)
		private int idSt;
		
		@Column(name="Name")
		private String name;
		
		@Column(name="Surname")
		private String surname;
		
		
		@OneToMany(mappedBy="student")
		@ToString.Exclude
		private Collection<Grade> grades;


		public Student(String name, String surname) {
			this.name = name;
			this.surname = surname;
		}
		
		
		
		
		
		
	
}
