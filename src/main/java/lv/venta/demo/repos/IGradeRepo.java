package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer> {

	public abstract ArrayList<Grade> findByStudentIdSt(int id);

	public abstract ArrayList<Grade> findByValueLessThan(int i);
	
	//nosaukums ir mazvarīgs, ja ir @Query anotacija
	@Query(value="SELECT AVG(VALUE) FROM GRADE WHERE ID_CO=?1", nativeQuery=true)
	public abstract float calculateAVGGradeByCourseId(int id);

	
	//nosaukums ir mazvarīgs, ja ir @Query anotacija
	@Query(value="SELECT AVG(VALUE) FROM GRADE WHERE ID_ST=?1", nativeQuery=true)
	public abstract float calculateAVGGradeByStudentId(int id);

	
	public abstract ArrayList<Grade> findByCourseIdCo(int id);

	public abstract ArrayList<Grade> findByStudentName(String name);

	public abstract ArrayList<Grade> findByCourseIdCoAndValueLessThan(int id, int i);
	

}
