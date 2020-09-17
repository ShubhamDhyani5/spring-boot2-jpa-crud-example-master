package net.guides.springboot2.springboot2jpacrudexample.repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Order1;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.model.Order;
import net.guides.springboot2.springboot2jpacrudexample.model.OrderItem;


//@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//}

@Repository
public interface Order1Repository extends CrudRepository<Order1, Long>{

}
