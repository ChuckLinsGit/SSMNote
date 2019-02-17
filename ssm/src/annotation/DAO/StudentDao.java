package annotation.DAO;

import annotation.entity.Student;

/**
 * 为保持myBatis的效率，一般不适用注解式开发
 * @author www25
 *
 */
public interface StudentDao {

	void insertStu(Student stu);

}
