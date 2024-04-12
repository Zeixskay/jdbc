package dao;

import entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface studentDao {
    List<Student> selectStudent() throws SQLException;
    Integer insertStudent(Student student) throws SQLException;
    Integer updateStudent(Student student) throws SQLException;
    Integer deleteStudent(Student student) throws SQLException;
}
