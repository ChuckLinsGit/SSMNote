package annotation.services;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import annotation.DAO.StudentDao;
import annotation.entity.Student;

@Service("StudentService")//注解式开发：同controller一样，还需在配置文件使用context:component-scan标签
public class StudentServiceImpl implements StudentService {

	/*@Autowired
	@Qualifier("StudentDao")*/
	
	//注解式开发时，dao的注入仍由MapperScannerConfigurer自动生产代理对象，无需声明，并且此处怪现象仍然存在
	@Resource(name="studentDao")
	private StudentDao stuDao;
	

	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}


	@Override
	/*使用默认的事务设置*/
	@Transactional
	public void addStudent(Student stu) {
		stuDao.insertStu(stu);
	}

}
