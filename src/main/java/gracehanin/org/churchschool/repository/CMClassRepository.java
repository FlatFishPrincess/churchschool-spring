package gracehanin.org.churchschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gracehanin.org.churchschool.model.CMClass;

@Repository
public interface CMClassRepository extends JpaRepository<CMClass,Long> {

}