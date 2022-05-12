package lv.venta.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.demo.models.Course;
import lv.venta.demo.models.Grade;
import lv.venta.demo.models.ProfDegree;
import lv.venta.demo.models.Professor;
import lv.venta.demo.models.Student;
import lv.venta.demo.repos.ICourseRepo;
import lv.venta.demo.repos.IGradeRepo;
import lv.venta.demo.repos.IProfessorRepo;
import lv.venta.demo.repos.IStudentRepo;

@SpringBootApplication
public class JavaSem4Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSem4Application.class, args);
	}
	
	@Bean //ar šo notāciju, funkcja izpildīsies automātiski startējo projektu
	public CommandLineRunner testDB(IProfessorRepo profRepo, IStudentRepo studRepo, 
			ICourseRepo courRepo, IGradeRepo gradRepo)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Baiba", "Jauka");
				studRepo.save(st1);
				studRepo.save(st2);
				
				Professor prof1 = new Professor("Karina", "Skirmante", ProfDegree.master);
				Professor prof2 = new Professor("Estere", "Vitola", ProfDegree.master);
				profRepo.save(prof1);
				profRepo.save(prof2);
				
				Course cour1 = new Course("JAVA", 4, prof1);
				Course cour2 = new Course("Matematika", 2, prof2);
				courRepo.save(cour1);
				courRepo.save(cour2);
				
				
				gradRepo.save(new Grade(5, cour1, st1));//5 JAVA Janis
				gradRepo.save(new Grade(6, cour2, st1));//6 Matematika Janis
				gradRepo.save(new Grade(10, cour1, st2));//10 JAVA Baiba
				gradRepo.save(new Grade(3, cour2, st2));//3 Matematika Baiba
				
			}
		};
	}

}
