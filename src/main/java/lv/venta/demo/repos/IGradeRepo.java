package lv.venta.demo.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer> {

}
