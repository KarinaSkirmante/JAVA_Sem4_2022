package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.Grade;
import lv.venta.demo.repos.IGradeRepo;
import lv.venta.demo.services.IFilteringGradeService;

@Service
public class FilteringGradeServiceImpl implements IFilteringGradeService {

	@Autowired
	private IGradeRepo gradeRepo;
	
	@Override
	public ArrayList<Grade> getAllGradesByStudentId(int id) throws Exception {
		ArrayList<Grade> result = gradeRepo.findByStudentIdSt(id);
		return result;
	}
	
	/*public void deleteStudentById(int id)
	{
		//dabūju Jāņa atzīme
		ArrayList<Grade> result = gradeRepo.findByStudentIdSt(id);
		
		for(Grade gr: result)
		{
			gr.setStudent(null);//noņemu saiti uz dzesamo jāni
		}
		
		studentRepo.deleteById(id);
		
	}
	*/
	
	//TODO
	@Override
	public ArrayList<Grade> getAllGradesByCourseId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	//TODO
	@Override
	public ArrayList<Grade> getAllGradesByStudentName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Grade> getAllFailingGrades() throws Exception {
		ArrayList<Grade> result = gradeRepo.findByValueLessThan(4);
		return result;
	}

	//TODO
	@Override
	public ArrayList<Grade> getAllFailingGradesByCourseId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getGradeAverageByCourseId(int id) throws Exception {
		// TODO Auto-generated method stub
		float result = gradeRepo.calculateAVGGradeByCourseId(id);
		return result;
	}

	//TODO
	@Override
	public float getGradeAverageByStudentId(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
