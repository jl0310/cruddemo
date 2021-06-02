package com.codetest.cruddemo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectsController {
	@Autowired
	ProjectsService projectsService;

	@GetMapping("/projects")
	private List<Project> getAllProjects() {
		return projectsService.getAllProjects();
	}

	// creating a get mapping that retrieves the detail of a specific project
	@GetMapping("/project/{projectid}")
	private Project getProjects(@PathVariable("projectid") int projectid) {
		return projectsService.getProjectById(projectid);
	}

	// creating a delete mapping that deletes a specified project
	@DeleteMapping("/project/{projectid}")
	private void deleteProject(@PathVariable("projectid") Integer projectid) {
		projectsService.delete(projectid);
	}

	@PostMapping("/project")
	private long saveBook(@RequestBody Project project) {
		projectsService.saveOrUpdate(project);
		return project.getId();
	}

	@PutMapping("/project/{projectid}")
	private Project update(@RequestBody Project project) {
		projectsService.saveOrUpdate(project);
		return project;
	}
}