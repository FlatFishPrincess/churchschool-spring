package gracehanin.org.churchschool.service.dto;

import java.time.LocalDate;

import gracehanin.org.churchschool.model.enumeration.AttendanceType;

/**
 * TeacherAttendanceDTO
 */
public class TeacherAttendanceDTO {

  private long id;
  private String personId;
  private AttendanceType attendanceType;

  private String description;

  private LocalDate attendanceDate;

  private Long teacherDivisionId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
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

  public Long getTeacherDivisionId() {
    return teacherDivisionId;
  }

  public void setTeacherDivisionId(Long teacherDivisionId) {
    this.teacherDivisionId = teacherDivisionId;
  }

  @Override
  public String toString() {
    return "TeacherAttendanceDTO [attendanceDate=" + attendanceDate + ", attendanceType=" + attendanceType
        + ", description=" + description + ", id=" + id + ", personId=" + personId + ", teacherDivisionId="
        + teacherDivisionId + "]";
  }

}
