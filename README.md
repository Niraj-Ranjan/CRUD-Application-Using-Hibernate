# CRUD-Application-Using-Servlet-JSP-Hibernate

#Maven Dependency File
https://mvnrepository.com


#Database File

		CREATE TABLE IF NOT EXISTS student (
		  student_id int(100) NOT NULL AUTO_INCREMENT,
		  student_name varchar(50) DEFAULT NULL,
		  roll_number varchar(50) DEFAULT NULL,
		  course varchar(50) DEFAULT NULL,  
		  PRIMARY KEY (student_id)
		);

#Kindly Change Hibernate Configuration File

    		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/databasename</property>
		<property name="hibernate.connection.username">root</property>
		<property name="hibernate.connection.password">passoword</property>
