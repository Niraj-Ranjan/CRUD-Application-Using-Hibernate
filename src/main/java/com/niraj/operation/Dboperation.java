package com.niraj.operation;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class Dboperation {
	
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	//public final static Logger logger = Logger.getLogger(Dboperation.class);
	
	// This Method Is Used To Create The Hibernate's SessionFactory Object
	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

    	
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
		// Creating Hibernate SessionFactory Instance
		return sf;
	}
	
	
	
	// Method 1: This Method Used To Create A New Student Record In The Database Table
	public static void createRecord() {
		int count = 0;
		Student studentObj = null;
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			// Creating Transaction Entities
			for(int j = 101; j <= 105; j++) {
				count = count + 1;
				studentObj = new Student();				
				studentObj.setRollnumber(j);
				studentObj.setStudentname("Editor " + j);
				studentObj.setCourse("Bachelor Of Technology");	
				sessionObj.save(studentObj);
			}

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			System.out.println("\nSuccessfully Created '" + count + "' Records In The Database!\n");
		} catch(Exception sqlException) {
			System.out.println(sqlException);
			
		} 
	}
	
	// Method 2: This Method Is Used To Display The Records From The Database Table
	@SuppressWarnings("unchecked")
	public static List displayRecords() {
		List studentsList = new ArrayList();		
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			studentsList = sessionObj.createQuery("FROM Student").list();
		} catch(Exception sqlException) {
			
			sqlException.printStackTrace();
		} 
		return studentsList;
	}
	
	
	
	// Method 3: This Method Is Used To Update A Record In The Database Table	
		public static void updateRecord(int student_id) {		
			try {
				// Getting Session Object From SessionFactory
				sessionObj = buildSessionFactory().openSession();
				// Getting Transaction Object From Session Object
				sessionObj.beginTransaction();

				// Creating Transaction Entity
				Student stuObj = (Student) sessionObj.get(Student.class, student_id);
				stuObj.setStudentname("Java Code Geek");
				stuObj.setCourse("Masters Of Technology");

				// Committing The Transactions To The Database
				sessionObj.getTransaction().commit();
				System.out.println("\nStudent With Id?= " + student_id + " Is Successfully Updated In The Database!\n");
			} catch(Exception sqlException) {
				sqlException.printStackTrace();
			} 
			}
		
	
	
	

//Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table
	public static void deleteRecord(Integer student_id) {
		try {
			// Getting Session Object From SessionFactory
			sessionObj = buildSessionFactory().openSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			Student studObj = findRecordById(student_id);
			sessionObj.delete(studObj);

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
			System.out.println("\nStudent With Id?= " + student_id + " Is Successfully Deleted From The Database!\n");
		} catch(Exception sqlException) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if(sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	
	
	// Method 4(b): This Method To Find Particular Record In The Database Table
		public static Student findRecordById(Integer find_student_id) {
			Student findStudentObj = null;
			try {
				// Getting Session Object From SessionFactory
				sessionObj = buildSessionFactory().openSession();
				// Getting Transaction Object From Session Object
				sessionObj.beginTransaction();

				findStudentObj = (Student) sessionObj.load(Student.class, find_student_id);
			} catch(Exception sqlException) {
				if(null != sessionObj.getTransaction()) {
					System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
					sessionObj.getTransaction().rollback();
				}
				sqlException.printStackTrace();
			} 
			return findStudentObj;
		}
		
		
		
		// Method 5: This Method Is Used To Delete All Records From The Database Table
		public static void deleteAllRecords() {
			try {
				// Getting Session Object From SessionFactory
				sessionObj = buildSessionFactory().openSession();
				// Getting Transaction Object From Session Object
				sessionObj.beginTransaction();

				Query queryObj = sessionObj.createQuery("DELETE FROM Student");
				queryObj.executeUpdate();

				// Committing The Transactions To The Database
				sessionObj.getTransaction().commit();
				System.out.println("\nSuccessfully Deleted All Records From The Database Table!\n");
			} catch(Exception sqlException) {
				if(null != sessionObj.getTransaction()) {
					System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
					sessionObj.getTransaction().rollback();
				}
				sqlException.printStackTrace();
			} finally {
				if(sessionObj != null) {
					sessionObj.close();
				}
			}
		}

}