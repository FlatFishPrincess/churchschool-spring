package gracehanin.org.churchschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gracehanin.org.churchschool.model.Pastor;

@Repository
public interface PastorRepository extends JpaRepository<Pastor,String> {

}