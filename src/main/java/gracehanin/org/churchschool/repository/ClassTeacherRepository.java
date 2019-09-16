package gracehanin.org.churchschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gracehanin.org.churchschool.model.ClassTeacher;

@Repository
public interface ClassTeacherRepository extends JpaRepository<ClassTeacher,Long> {

}