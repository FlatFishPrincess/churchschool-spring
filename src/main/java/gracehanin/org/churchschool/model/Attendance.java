package gracehanin.org.churchschool.model;

import java.time.LocalDate;

import javax.persistence.*;

import gracehanin.org.churchschool.model.enumeration.AttendanceType;

@Entity
public class Attendance {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private Long entityId;

  @Column
  private String entityType;

  @Column
  private LocalDate attendanceDate;

  @ManyToOne(cascade = { CascadeType.ALL })
  private TeacherDivision teacherDivision;

  private AttendanceType attendanceType;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getEntityId() {
    return entityId;
  }

  public void setEntityId(Long entityId) {
    this.entityId = entityId;
  }

  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public LocalDate getAttendanceDate() {
    return attendanceDate;
  }

  public void setAttendanceDate(LocalDate attendanceDate) {
    this.attendanceDate = attendanceDate;
  }

  public TeacherDivision getClassTeacher() {
    return teacherDivision;
  }

  public void setClassTeacher(TeacherDivision teacherDivision) {
    this.teacherDivision = teacherDivision;
  }

  public AttendanceType getAttendanceType() {
    return attendanceType;
  }

  public void setAttendanceType(AttendanceType attendanceType) {
    this.attendanceType = attendanceType;
  }

  @Override
  public String toString() {
    return "Attendance [attendanceDate=" + attendanceDate + ", attendanceType=" + attendanceType + ", teacherDivision="
        + teacherDivision + ", entityId=" + entityId + ", entityType=" + entityType + ", id=" + id + "]";
  }

}