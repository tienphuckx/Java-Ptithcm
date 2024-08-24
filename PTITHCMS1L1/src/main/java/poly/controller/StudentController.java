package poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	
	@RequestMapping(value = "/student")
	public String student()
	{
		return "student/student_home";
	}
	
//	@RequestMapping(value = "/student")
//	public String student(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String mark = request.getParameter("mark");
//		String major = request.getParameter("major");
//		
//		request.setAttribute("name", name);
//		request.setAttribute("mark", mark);
//		request.setAttribute("major", major);
//	
//		return "student/student_list";
//	}
	//HttpServletRequest request
//	@RequestMapping(value = "/student/save")
//	public String student(HttpServletRequest request, HttpServletResponse response) {
//		String name = request.getParameter("name");
//		String mark = request.getParameter("mark");
//		String major = request.getParameter("major");
//		
//		request.setAttribute("name", name);
//		request.setAttribute("mark", mark);
//		request.setAttribute("major", major);
//	
//		return "student/student_list";
//	}
	
	
	@RequestMapping(value = "/student/input")
	public String student_input()
	{
		return "student/student_input";
	}
}
