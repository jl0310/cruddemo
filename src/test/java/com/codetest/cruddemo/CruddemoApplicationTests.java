package com.codetest.cruddemo;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class CruddemoApplicationTests {

	@Autowired
	private ProjectsRepository repo;

	@Test
	void contextLoads() {
	}
	
	
	@Test
	@Rollback(false)
	@Order(1)
	public void testCreateProject() {
		Project savedProject1 = repo.save(new Project("test1 name", "test1 desc"));
		Project savedProject2 = repo.save(new Project("test2 name", "test2 desc"));
		Project savedProject3 = repo.save(new Project("test3 name", "test3 desc"));
		
		assertThat(savedProject1.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void testFindProjectById() {
		Project project = repo.findById(2).get();		
		assertThat(project.getId()).isEqualTo(2);
	}
	
	@Test
	@Order(3)
	public void testListProjects() {
		List<Project> projects = (List<Project>) repo.findAll();		
		assertThat(projects).size().isGreaterThan(0);
	}	
	
	@Test
	@Rollback(false)
	@Order(4)
	public void testUpdateProject() {
		Project project = repo.findById(3).get();
		project.setName("test3 new name");
		
		repo.save(project);
		
		Project updatedProject = repo.findById(3).get();
		
		assertThat(updatedProject.getName()).isEqualTo("test3 new name");
	}
	
	@Test
	@Rollback(false)
	@Order(5)
	public void testDeleteProject() {
		Project project = repo.findById(2).get();
		
		repo.deleteById(project.getId());		
		assertThat(repo.existsById(2)).isFalse();		
		
	}	

}
