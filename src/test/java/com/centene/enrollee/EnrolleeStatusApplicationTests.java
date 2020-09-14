//package com.centene.enrollee;
//
//import static org.junit.Assert.assertNotNull;
//
//import java.time.LocalDate;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.centene.enrollee.model.EnrolleeRequest;
//import com.centene.enrollee.service.EnrolleeService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class EnrolleeStatusApplicationTests {
//
//	EnrolleeRequest enrolleeRequest = null;
//
//	@Test
//	void contextLoads() {
//		enrolleeRequest = new EnrolleeRequest();
//		enrolleeRequest.setEnrolleeDOB(LocalDate.ofYearDay(1988, 100));
//		enrolleeRequest.setEnrolleeName("David");
//		enrolleeRequest.setPhoneNumber("123-456-7890");
//	}
//
//	@Autowired
//	EnrolleeService es;
//
//	@Test(expected = NullPointerException.class)
//	public void testAddEnrollee() {
//		assertNotNull(es.addEnrollee(enrolleeRequest));
//	}
//
//}
