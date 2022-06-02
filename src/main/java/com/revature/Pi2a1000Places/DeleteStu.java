package com.sdnext.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sdnext.hibernate.tutorial.dto.Student;
import com.sdnext.hibernate.tutorial.utility.HibernateUtil;

public class DeleteStudent {

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
  Student student = (Student)session.load(Student.class, 4);
  session.delete(student);
  System.out.println("Deleted Successfully");
  session.getTransaction().commit();
     sessionFactory.close();
 }
}