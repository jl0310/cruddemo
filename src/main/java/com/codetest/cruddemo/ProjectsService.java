package com.codetest.cruddemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService {
	
	@Autowired
	private ProjectsRepository projectsRepository;

	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<Project>();
		projectsRepository.findAll().forEach(projects::add);
		return projects;
	}

	public Project getProjectById(int projectid) {
		return projectsRepository.findById(projectid).get();
	}

	public void saveOrUpdate(Project project) {
		projectsRepository.save(project);
	}

	public void delete(int projectid) {
		projectsRepository.deleteById(projectid);
	}

	public void update(Project project, int projectid) {
		projectsRepository.save(project);
	}
}