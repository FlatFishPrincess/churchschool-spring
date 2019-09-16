package gracehanin.org.churchschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gracehanin.org.churchschool.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

}