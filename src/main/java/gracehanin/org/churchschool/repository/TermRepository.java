package gracehanin.org.churchschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gracehanin.org.churchschool.model.Term;

@Repository
public interface TermRepository extends JpaRepository<Term,Long> {

}