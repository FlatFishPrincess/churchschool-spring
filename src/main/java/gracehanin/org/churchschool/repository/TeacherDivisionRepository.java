package gracehanin.org.churchschool.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gracehanin.org.churchschool.model.TeacherDivision;
import gracehanin.org.churchschool.web.vm.AllTeacherListVM2;

@Repository
public interface TeacherDivisionRepository extends JpaRepository<TeacherDivision, Long> {
  List<TeacherDivision> findAll();

  @Query("Select new gracehanin.org.churchschool.web.vm.AllTeacherListVM2"
      + "(c.name, c.instructor.member.lastName, c.department.name) from Course c where c.id=?1")
  Page<AllTeacherListVM2> getAllTeacherListVM(Pageable pageable);

}