package gracehanin.org.churchschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gracehanin.org.churchschool.model.TeacherDivision;

@Repository
public interface TeacherDivisionRepository extends JpaRepository<TeacherDivision, Long> {

}