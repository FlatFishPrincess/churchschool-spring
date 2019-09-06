package gracehanin.org.churchschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gracehanin.org.churchschool.model.PastorDepartment;

@Repository
public interface PastorDepartmentRepository extends JpaRepository<PastorDepartment,String> {

}