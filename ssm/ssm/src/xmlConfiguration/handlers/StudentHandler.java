package xmlConfiguration.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import xmlConfiguration.entity.Student;
import xmlConfiguration.services.StudentService;



public class StudentHandler implements Controller {

	private StudentService studetnService;

	public void setStudetnService(StudentService studetnService) {
		this.studetnService = studetnService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sname=request.getParameter("name");		
		String ageStr=request.getParameter("age");
		Integer sage=Integer.valueOf(ageStr);		
		String scoreStr=request.getParameter("score");
		Integer sscore=Integer.valueOf(scoreStr);		
		String classidStr=request.getParameter("classid");
		Integer sclassid=Integer.valueOf(classidStr);	
		Student stu=new Student(sname, sage, sscore, sclassid);
		
		ModelAndView mView=new  ModelAndView();
		
		if(stu!=null) {
			studetnService.addStudent(stu);
			mView.addObject("Message", "成功添加！");			
		}else {
			mView.addObject("Message", "添加失败！");			
		}
		mView.setViewName("/input.jsp");
		return mView;
	}


}
