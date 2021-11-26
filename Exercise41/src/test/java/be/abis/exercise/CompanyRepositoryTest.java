package be.abis.exercise;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CompanyJpaRepository;
import be.abis.exercise.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CompanyRepositoryTest {

	@Autowired
	CompanyJpaRepository compRep;

	@Test
	public void company4IsEscon(){
		Company comp = compRep.findCompanyById(4);
		assertEquals("ESCON",comp.getName().trim());
	}

	@Test
	public void companyEsconIsLocatedInGent() {
		Company comp = compRep.findByNameStartsWith("ESCON");
		assertEquals("GENT",comp.getAddress().getTown().trim());
	}

	@Test
	public void companyEsconInGentHasId4() {
       Company comp = compRep.getByNameAndTown("ESCON","GENT");
       assertEquals(4,comp.getId());
	}

	@Test
	@Transactional
	public void addCompany() {
		Address a = new Address("Diestsevest","32","3000","Leuven");
		a.setCountryCode("B");
		Company c = new Company("Abis","016/455610","BE12345678",a);
		long sizeBefore = compRep.count();
		compRep.save(c);
		long sizeAfter = compRep.count();
		assertEquals(1,sizeAfter-sizeBefore);
	}

	@Test
	@Transactional
	public void updateCompany() {
		Company comp = compRep.findCompanyById(3);
		comp.setName("Other Name");
		compRep.save(comp);
		assertEquals("Other Name", compRep.findCompanyById(3).getName());

	}

	@Test
	@Transactional
	// 17 will give exception, because of referential constraint
	//show also 14, does not exist
	public void deleteCompany17() {
		Address a = new Address("Diestsevest","32","3000","Leuven");
		a.setCountryCode("B");
		Company c = new Company("NewComp","016/455610","BE12345678",a);
		Company newc = compRep.save(c);

		long sizeBefore = compRep.count();
		//compRep.deleteById(17);
		compRep.deleteById(newc.getId());
		long sizeAfter = compRep.count();
		assertEquals(-1,sizeAfter-sizeBefore);
	}

	
	

}
