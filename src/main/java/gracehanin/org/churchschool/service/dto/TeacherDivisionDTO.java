package gracehanin.org.churchschool.service.dto;

import java.time.LocalDate;

import gracehanin.org.churchschool.model.enumeration.TeacherType;

/**
 * TeacherDivisionDTO
 */
public class TeacherDivisionDTO {

  private Long id;

  private String personId;

  private TeacherType teacherType;

  private LocalDate startDate;

  private LocalDate endDate;

  // ----- ManyToOne Relationship -----
  // private Long termId;

  private Long divisionId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
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

  @Override
  public String toString() {
    return "TeacherDivisionDTO [divisionId=" + divisionId + ", endDate=" + endDate + ", id=" + id + ", personId="
        + personId + ", startDate=" + startDate + ", teacherType=" + teacherType + ", termId=" + "]";
  }

}
