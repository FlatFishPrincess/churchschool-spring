package gracehanin.org.churchschool.model;

import java.time.LocalDate;
import javax.persistence.*;

import gracehanin.org.churchschool.model.enumeration.AttendanceType;

@Entity
public class TeacherAttendance {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private AttendanceType attendanceType;

  private String description;

  private LocalDate attendanceDate;

  // @ManyToOne
  // private TeacherDivision teacherDivision;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AttendanceType getAttendanceType() {
    return attendanceType;
  }

  public void setAttendanceType(AttendanceType attendanceType) {
    this.attendanceType = attendanceType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getAttendanceDate() {
    return attendanceDate;
  }

  public void setAttendanceDate(LocalDate attendanceDate) {
    this.attendanceDate = attendanceDate;
  }

  // public TeacherDivision getTeacherDivision() {
  // return teacherDivision;
  // }

  // public void setTeacherDivision(TeacherDivision teacherDivision) {
  // this.teacherDivision = teacherDivision;
  // }

  // @Override
  // public String toString() {
  // return "TeacherAttendance [attendanceDate=" + attendanceDate + ",
  // attendanceType=" + attendanceType
  // + ", description=" + description + ", id=" + id + ", teacherDivision=" +
  // teacherDivision + "]";
  // }

}