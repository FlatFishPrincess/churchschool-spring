package gracehanin.org.churchschool.web.vm;

import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;

/**
 * View Model for All Teacher List Page.
 */

public class AllTeacherListVM2 extends TeacherDivisionDTO {

  private String ministryName;

  private Long numberOfStudents;

  public AllTeacherListVM2() {
    // Empty constructor needed for Jackson..?what?
  }

  public String getMinistryName() {
    return ministryName;
  }

  public void setMinistryName(String ministryName) {
    this.ministryName = ministryName;
  }

  public Long getNumberOfStudents() {
    return numberOfStudents;
  }

  public void setNumberOfStudents(Long numberOfStudents) {
    this.numberOfStudents = numberOfStudents;
  }

  @Override
  public String toString() {
    return "AllTeacherListVM2 [ministryName=" + ministryName + ", numberOfStudents=" + numberOfStudents + "]";
  }

}
