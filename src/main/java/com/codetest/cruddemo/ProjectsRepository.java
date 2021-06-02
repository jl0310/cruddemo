package com.codetest.cruddemo;  

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//repository that extends CrudRepository  
@Repository
public interface ProjectsRepository extends CrudRepository<Project, Integer>  
{  
}  