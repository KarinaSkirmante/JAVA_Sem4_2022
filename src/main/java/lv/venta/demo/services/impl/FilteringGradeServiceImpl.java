package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.experimental.UtilityClass;
import lv.venta.demo.models.Grade;
import lv.venta.demo.repos.IGradeRepo;
import lv.venta.demo.repos.IStudentRepo;
import lv.venta.demo.services.IFilteringGradeService;

@Service
public class FilteringGradeServiceImpl implements IFilteringGradeService {

	//TODO apstrādāt ar existsBy un ja neeksistē, tad mest izņēmumu
	@Autowired
	private IGradeRepo gradeRepo;
	@Autowired
	private IStudentRepo studRepo;
	
	@Override
	public ArrayList<Grade> getAllGradesByStudentId(int id) throws Exception {
		if(studRepo.existsById(id))
		{
			ArrayList<Grade> result = gradeRepo.findByStudentIdSt(id);
			return result;
		}
		else
		{
			throw new Exception("Id nav eksistējošs");
		}
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
		return gradeRepo.findByCourseIdCo(id);
	}
	//TODO
	@Override
	public ArrayList<Grade> getAllGradesByStudentName(String name) throws Exception {
		// TODO Auto-generated method stub
		return gradeRepo.findByStudentName(name);
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
		return gradeRepo.findByCourseIdCoAndValueLessThan(id,4);
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
		return gradeRepo.calculateAVGGradeByStudentId(id);
	}
	
	//1.TODO visus servisā
	//2. izveidot kontroleiru klasi ar kontrolieru funkcijām (get)
	//3. uztaisīt html lapu vairāku atzmju attēlošanai
	//3.1. kontrolieros, kur sserviss atgriezīs float, tikai izprintēt
	//4. notestēt visus kontrolierus no 
	//web browsera izpildot atbisltošos url
	

}
