package xmlConfiguration.services;

import xmlConfiguration.DAO.StudentDao;
import xmlConfiguration.entity.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao stuDao;
	

	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}


	@Override
	public void addStudent(Student stu) {
		stuDao.insertStu(stu);
	}

}
