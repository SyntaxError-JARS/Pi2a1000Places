package com.sdnext.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sdnext.hibernate.tutorial.dto.Student;
import com.sdnext.hibernate.tutorial.utility.HibernateUtil;

public class CreateStudent {

 /**
  * @param args
  */
 public static void main(String[] args) 
 {
  //Create student entity object
  Student student = new Student();
  student.setStudentName("Dinesh Rajput");
  student.setRollNumber(01);
  student.setCourse("MCA");
  
  //Create session factory object
  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
  //getting session object from session factory
  Session session = sessionFactory.openSession();
  //getting transaction object from session object
  session.beginTransaction();
  
  session.save(student);
  System.out.println("Inserted Successfully");
  session.getTransaction().commit();
  session.close();
  sessionFactory.close();
 }
}