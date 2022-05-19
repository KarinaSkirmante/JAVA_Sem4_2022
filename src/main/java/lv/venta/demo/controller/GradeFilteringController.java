package lv.venta.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.demo.services.IFilteringGradeService;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilteringController {

	@Autowired
	private IFilteringGradeService gradeService;
	
	@GetMapping("/student/{id}") //localhost:8080/grade/filter/student/2
	public String getGradeByStudentId(@PathVariable(name="id") int id,
			Model model)
	{
		try
		{
			model.addAttribute("package", 
					gradeService.getAllGradesByStudentId(id));//padod izfiltrētoss datus
			return "all-grades-page";//all-grades-page.html ielāde
			
		}
		catch (Exception e) {
			System.out.println(e);
			return "error-page";
		}
	}
	
	@GetMapping("/course/{id}") //localhost:8080/grade/filter/course/4
	public String getGradeByCourseId(@PathVariable(name="id") int id,
			Model model)
	{
		try
		{
			model.addAttribute("package", 
					gradeService.getAllGradesByCourseId(id));//padod izfiltrētoss datus
			return "all-grades-page";//all-grades-page.html ielāde
			
		}
		catch (Exception e) {
			System.out.println(e);
			return "error-page";
		}
	}
	
	@GetMapping("/student") //localhost:8080/grade/filter/student?name=Baiba
	public String getGradeByStudentName(@RequestParam(name="name") String name,
			Model model)
	{
		try
		{
			model.addAttribute("package", 
					gradeService.getAllGradesByStudentName(name));//padod izfiltrētoss datus
			return "all-grades-page";//all-grades-page.html ielāde
			
		}
		catch (Exception e) {
			System.out.println(e);
			return "error-page";
		}
	}
	
	@GetMapping("/course/{id}/bad") //localhost:8080/grade/filter/course/4/bad
	public String getGradeByCourseIdBad(@PathVariable(name="id") int id,
			Model model)
	{
		try
		{
			model.addAttribute("package", 
					gradeService.getAllFailingGradesByCourseId(id));//padod izfiltrētoss datus
			return "all-grades-page";//all-grades-page.html ielāde
			
		}
		catch (Exception e) {
			System.out.println(e);
			return "error-page";
		}
	}
	@GetMapping("/course/bad") //localhost:8080/grade/filter/course/bad
	public String getGradeBad(Model model)
	{
		try
		{
			model.addAttribute("package", 
					gradeService.getAllFailingGrades());//padod izfiltrētoss datus
			return "all-grades-page";//all-grades-page.html ielāde
			
		}
		catch (Exception e) {
			System.out.println(e);
			return "error-page";
		}
	}
	
	
	//TODO - pārējāš kontrolieru funkcijas
}
