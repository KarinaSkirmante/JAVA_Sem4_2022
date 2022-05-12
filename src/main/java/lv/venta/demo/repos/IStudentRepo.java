package lv.venta.demo.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Student;

public interface IStudentRepo extends CrudRepository<Student, Integer>{

}
