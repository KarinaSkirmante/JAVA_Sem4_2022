package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.models.Course;
import lv.venta.demo.models.Grade;
import lv.venta.demo.models.Student;

public interface IFilteringGradeService {
	//Atrast kāda konkrēta studenta visas atzīmes
	public abstract ArrayList<Grade> getAllGradesByStudentId(int id) throws Exception;
    
	//Atrast visas atzīmes konkrētā kursā
	public abstract ArrayList<Grade> getAllGradesByCourseId(int id) throws Exception;
        
    //Atrast visas konkrēta studenta atzīmes pēc viņa vārda
	public abstract ArrayList<Grade> getAllGradesByStudentName(String name) throws Exception;
    
    //Atrast visas nesekmīgās atzīmes un šo atzīmju studentus
	public abstract ArrayList<Grade> getAllFailingGrades() throws Exception;
    
  //Atrast visas nesekmīgās atzīmes konkrētā kursā un šo atzīmju studentus
	public abstract ArrayList<Grade> getAllFailingGradesByCourseId(int id) throws Exception;
    
	public abstract float getGradeAverageByCourseId(int id)throws Exception;
	public abstract float getGradeAverageByStudentId(int id)throws Exception;
	
}
