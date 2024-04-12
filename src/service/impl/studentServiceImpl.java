package service.impl;

import dao.impl.studentDaoImpl;
import dao.studentDao;
import entity.Student;
import service.studentService;

import java.sql.SQLException;
import java.util.List;

public class studentServiceImpl  implements studentService {
    private studentDao st =new studentDaoImpl();
    @Override
    public List<Student> select() throws SQLException {
       return st.selectStudent();
    }

    @Override
    public Integer delete(Student ss) throws SQLException {
        return st.deleteStudent(ss);
    }
}
