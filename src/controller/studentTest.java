package controller;


import entity.Student;
import service.impl.studentServiceImpl;
import service.studentService;
import utils.DBUtils;

import java.sql.SQLException;
import java.util.List;

public class studentTest {
    private  static studentService sr =new studentServiceImpl();

    public  static void selectStudent() throws SQLException {
      List<Student> students= sr.select();
      for(Student students1:students){
          System.out.println(students1);
      }
    }
    public  static void deleteStudent() throws SQLException {
        Student student2=new Student();
        student2.setId(3);
        int i=sr.delete(student2);
        System.out.println("删除成功！受影响的行数："+i);
    }



    public static void main(String[] args) throws SQLException {

        selectStudent();
        deleteStudent();

       /* Student student=new Student();
        student.setUserName("孙悟空2");
        student.setPassWord("753");
        student.setClassName("体育");
        int i = studentDao.insertStudent(student);
        System.out.println("-----------------------------插入-----------------------------");
        System.out.println("插入成功！受影响的行数："+i);
        System.out.println("--------------------------------------------------------------");

        Student student1=new Student();
        student1.setId(3);
        student1.setUserName("老干妈");
        int j=studentDao.updateStudent(student1);
        List<Student> res1= studentDao.selectStudent();
        System.out.println("-----------------------------更改-----------------------------");
        System.out.println("更改成功！受影响的行数："+j);
        System.out.println("--------------------------------------------------------------");
        System.out.println("更改后");
        for(Student ans1:res1){
            System.out.println(ans1);
        }
        System.out.println("--------------------------------------------------------------");

        Student student2=new Student();
        student2.setId(2);
        int k=studentDao.deleteStudent(student2);
        List<Student> res2= studentDao.selectStudent();
        System.out.println("-----------------------------删除-----------------------------");
        System.out.println("删除成功！受影响的行数："+k);
        System.out.println("--------------------------------------------------------------");
        System.out.println("删除后");
        for(Student ans2:res2){
            System.out.println(ans2);
        }
        System.out.println("--------------------------------------------------------------");
*/
        DBUtils.closeResource();

    }

}
