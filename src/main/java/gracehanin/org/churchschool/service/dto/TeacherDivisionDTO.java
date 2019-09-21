package gracehanin.org.churchschool.service.dto;

import java.time.LocalDate;

import gracehanin.org.churchschool.model.enumeration.TeacherType;

/**
 * TeacherDivisionDTO
 */
public class TeacherDivisionDTO {

  private Long id;

  private Long teacherId;

  private String personId;

  private TeacherType teacherType;

  private LocalDate startDate;

  private LocalDate endDate;

  // ----- ManyToOne Relationship -----
  // private Long termId;

  private Long divisionId;

  private String divisionName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(Long teacherId) {
    this.teacherId = teacherId;
  }

  public TeacherType getTeacherType() {
    return teacherType;
  }

  public void setTeacherType(TeacherType teacherType) {
    this.teacherType = teacherType;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  // public Long getTermId() {
  // return termId;
  // }

  // public void setTermId(Long termId) {
  // this.termId = termId;
  // }

  public Long getDivisionId() {
    return divisionId;
  }

  public void setDivisionId(Long divisionId) {
    this.divisionId = divisionId;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
  }

  public String getDivisionName() {
    return divisionName;
  }

  public void setDivisionName(String divisionName) {
    this.divisionName = divisionName;
  }

  @Override
  public String toString() {
    return "TeacherDivisionDTO [divisionId=" + divisionId + ", divisionName=" + divisionName + ", endDate=" + endDate
        + ", id=" + id + ", personId=" + personId + ", startDate=" + startDate + ", teacherId=" + teacherId
        + ", teacherType=" + teacherType + "]";
  }
}
