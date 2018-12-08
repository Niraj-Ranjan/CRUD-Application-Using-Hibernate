package com.niraj.operation;

import java.util.List;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("\n=======CREATE RECORDS=======\n");
		
		Dboperation.createRecord();
				
		System.out.println("\n=======READ RECORDS=======\n");
		List<Student> student = Dboperation.displayRecords();
		
			for(Student studentObj : student) {
				System.out.println(studentObj.toString());
			}
			
			
			
			
			System.out.println("\n=======UPDATE RECORDS=======\n");
			int updateId = 32;
			Dboperation.updateRecord(updateId);
			System.out.println("\n=======READ RECORDS AFTER UPDATION=======\n");
			List<Student> students = Dboperation.displayRecords();
			
			for(Student studentObj : students) {
				System.out.println(studentObj.toString());
			}
		
		
			
			System.out.println("\n=======DELETE RECORD=======\n");
			int deleteId = 35;
			Dboperation.deleteRecord(deleteId);
			System.out.println("\n=======READ RECORDS AFTER DELETION=======\n");
			List<Student> deleteStudentRecord = Dboperation.displayRecords();
			for(Student studentObj : deleteStudentRecord) {
				System.out.println(studentObj.toString());
			}
		
		
			System.out.println("\n=======DELETE ALL RECORDS=======\n");
			Dboperation.deleteAllRecords();
			System.out.println("\n=======READ RECORDS AFTER ALL RECORDS DELETION=======");
			List<Student> deleteAll = Dboperation.displayRecords();
			if(deleteAll.size() == 0) {
				System.out.println("\nNo Records Are Present In The Database Table!\n");
			}		
			System.exit(0);
		} 

		
		
		
		
	}
	
	
	
	



