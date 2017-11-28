package com.kaishengit.test;

import com.kaishengit.pojo.Student;
import com.kaishengit.pojo.Teacher;
import com.kaishengit.pojo.Util.MybatisUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class ManyToManyTest {

    private Session session;
    @Before
    public void before() {
        session = MybatisUtil.session();
        session.getTransaction().begin();
    }

    @After
    public void after() {
        session.getTransaction().commit();
    }

    @Test
    public void save(){
        Teacher teacher=new Teacher();
        teacher.setTeacherName("newTeacher");

        session.save(teacher);

        Student student= (Student) session.get(Student.class,2);

        Set<Teacher> teachers=student.getTeacherSet();
        teachers.add(teacher);

        student.setTeacherSet(teachers);

    }

    @Test
    public void findByStudent(){
        Student student= (Student) session.get(Student.class,2);
        System.out.println(student.getStudentName());

        Set<Teacher> teachers=student.getTeacherSet();
        for(Teacher teacher:teachers){
            System.out.println(teacher.getId()+"---"+teacher.getTeacherName());
        }
    }

    @Test
    public void save2(){
        Student student=new Student();
        student.setStudentName("xixi");

        Student student2=new Student();
        student2.setStudentName("xixi2");

        Teacher teacher=new Teacher();
        teacher.setTeacherName("teacher2");

        Teacher teacher2=new Teacher();
        teacher2.setTeacherName("teacher3");

       Set<Teacher> teachers=new HashSet<Teacher>();
        teachers.add(teacher);
        teachers.add(teacher2);

        student.setTeacherSet(teachers);
        student2.setTeacherSet(teachers);

        Set<Student> students=new HashSet<Student>();
       students.add(student);
       students.add(student2);

       teacher.setStudentSet(students);
       teacher2.setStudentSet(students);



        session.save(student);
        session.save(student2);
        session.save(teacher);
        session.save(teacher2);


    }
}
