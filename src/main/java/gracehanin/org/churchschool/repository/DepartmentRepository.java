package gracehanin.org.churchschool.repository;

import gracehanin.org.churchschool.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  // @Query("select * from department inner join division on department.id=division.departmentId where division.id=:divisionId")
  // Optional<Department> findDepartmentByDivisionId(@Param("divisionId") Long divisionId);
}