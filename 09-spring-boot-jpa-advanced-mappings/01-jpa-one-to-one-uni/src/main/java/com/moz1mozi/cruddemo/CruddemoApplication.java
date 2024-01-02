package com.moz1mozi.cruddemo;

import com.moz1mozi.cruddemo.dao.AppDAO;
import com.moz1mozi.cruddemo.entity.Instructor;
import com.moz1mozi.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);

			deleteInstructor(appDAO);
		};
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId =1 ;
		System.out.println("Finding instructor id: " +theId);
		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}
	private void createInstructor(AppDAO appDAO) {

		// create the instructor
//		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@moz1mozi.com");
//
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.moz1mozi.coom/youtube",
//				"Moz1mozi!!!");

		Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@moz1mozi.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.moz1mozi.coom/youtube",
				"Guitar");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//
		// NOTE : this will ALSO save the details object
		// because of CascadeType.ALL
		System.out.println("saving instructor: " +tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
