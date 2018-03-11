package com.janejsmund.student.dal;

import com.janejsmund.student.dal.entities.Customer;
import com.janejsmund.student.dal.entities.Student;
import com.janejsmund.student.dal.repos.CustomerRepository;
import com.janejsmund.student.dal.repos.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
    private CustomerRepository customerRepository;

	@Test
	public void testCreateStudent() {

		Student student = new Student();
		student.setName("John");
		student.setCourse("Java Web Services");
		student.setFee(30d);

		studentRepository.save(student);
	}

	@Test
	public void testFindStudentById() {

        Student student;
	    if (studentRepository.findById(1l).isPresent()) {
            student = studentRepository.findById(1l).get();
			System.out.println(student);
        }

	}

	@Test
	public void testUpdateStudent() {

		Student student;
		if (studentRepository.findById(1l).isPresent()) {
			student = studentRepository.findById(1l).get();
			student.setFee(50d);
			studentRepository.save(student);
		}
	}

	@Test
    public void testDeleteStudent() {
	    studentRepository.deleteById(1l);
    }

    @Test
    public void testCreateCustomer() {

        Customer customer = new Customer();
        customer.setName("my customer");
        customer.setEmail("my.customer@mail.com");

        customerRepository.save(customer);
    }

    @Test
    public void testFindCustomerById() {
	    if (customerRepository.findById(1l).isPresent()) {
	        Customer customer = customerRepository.findById(1l).get();
            System.out.println(customer);
        }
    }

    @Test
    public void testUpdateCustomer() {
        if (customerRepository.findById(1l).isPresent()) {
            Customer customer = customerRepository.findById(1l).get();
            customer.setEmail("another@mail.com");
            customerRepository.save(customer);
        }
    }

    @Test
    public void testDeleteCustomer() {
	    customerRepository.deleteById(1l);
    }

}
