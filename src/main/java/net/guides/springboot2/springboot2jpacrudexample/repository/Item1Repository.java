package net.guides.springboot2.springboot2jpacrudexample.repository;

import net.guides.springboot2.springboot2jpacrudexample.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//}

@Repository
public interface Item1Repository extends CrudRepository<Item1, Long>{
    //List<Item1> findByInstructorId(Long instructorId);
    //Optional<Course> findByIdAndInstructorId(Long id, Long instructorId);
}
