package lv.venta.demo.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Professor;

public interface IProfessorRepo extends CrudRepository<Professor, Integer> {

}
