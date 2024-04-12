package service;

import entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface studentService {
      List<Student>  select() throws SQLException;
      Integer delete(Student ss) throws SQLException;
}
