package dao.impl;

import dao.studentDao;
import entity.Student;
import utils.DBUtils;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDaoImpl extends DBUtils implements studentDao {

    ResultSet rs=null;
    @Override
    public List<Student> selectStudent() throws SQLException {
        boolean conn= getConn();
        List<Student> students = new ArrayList<>();
        String sql="select * from student";
        Object[] aa=null;
        if(conn){
           rs= selectSQL(sql,aa);
           while(rs.next()){
               Student student=new Student();
               student.setId(rs.getInt("id"));
               student.setUserName(rs.getString("userName"));
               student.setPassWord(rs.getString("passWord"));
               student.setClassName(rs.getString("className"));
               students.add(student);
           }
        }
        return students;
    }

    @Override
    public Integer insertStudent(Student student) throws SQLException {
        int result=0;
        String sql="insert into student(userName,passWord,className) values(?,?,?)";
        result=cudSQL(sql,new Object[]{student.getUserName(),student.getPassWord(),student.getClassName()});
        return result;
    }

    @Override
    public Integer updateStudent(Student student) throws SQLException {
        int result=0;
        String sql="update student set userName=? where id=?";
        result=cudSQL(sql,new Object[]{student.getUserName(),student.getId()});
        return result;
    }

    @Override
    public Integer deleteStudent(Student student) throws SQLException {
        int result=0;
        String sql="delete from student where id=?";
        result=cudSQL(sql,new Object[]{student.getId()});
        return result;
    }
}
