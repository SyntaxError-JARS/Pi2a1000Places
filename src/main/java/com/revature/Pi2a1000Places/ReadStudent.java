package com.sdnext.hibernate.tutorial;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sdnext.hibernate.tutorial.dto.Student;
import com.sdnext.hibernate.tutorial.utility.HibernateUtil;

public class ReadStudent {

 /**
  * @param args
  */
 public static void main(String[] args) 
 {
  //Create session factory object
  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
  //getting session object from session factory
  Session session = sessionFactory.openSession();
  //getting transaction object from session object
  session.beginTransaction();
  Query query = session.createQuery("from Student");
  List students = query.list();
  for(Student student : students)
  {
System.out.println("Roll Number: "+student.getRollNumber()+", Student Name: "+student.getStudentName()+", Course: "+student.getCourse());
  }
  session.getTransaction().commit();
  sessionFactory.close();
 }
}