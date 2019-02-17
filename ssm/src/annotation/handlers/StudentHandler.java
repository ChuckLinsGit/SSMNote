package annotation.handlers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import annotation.entity.Student;
import annotation.services.StudentService;

@Controller
public class StudentHandler {

  /*不删除spring-service.xml:即service任由xml文件来注入
   * @Autowired
	@Qualifier("StudentService")
	*/
	
	/*删除spring-service.xml则需要用resource注解，并在serviece中加入service注解*/
	@Resource(name="StudentService")
	private StudentService studetnService;

	public void setStudetnService(StudentService studetnService) {
		this.studetnService = studetnService;
	}

	@RequestMapping("test.do")
	public String  handleRequest(String name,int age,int score,int classid,Model model) throws Exception {

		Student stu=new Student(name, age, score, classid);
		
		ModelAndView mView=new  ModelAndView();
		
		if(stu!=null) {
			studetnService.addStudent(stu);
			model.addAttribute("Message", "成功添加！");			
		}else {
			model.addAttribute("Message", "添加失败！");			
		}
		return "/input.jsp";
	}


}
