package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.model.Order;
import net.guides.springboot2.springboot2jpacrudexample.model.OrderItem;


//@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//}

@Repository
public interface EmployeeRepository extends JpaRepository<Order, Long>{

}