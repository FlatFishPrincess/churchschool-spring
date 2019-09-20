package gracehanin.org.churchschool.web.vm;

import gracehanin.org.churchschool.service.dto.TeacherDTO;

/**
 * View Model object for Teacher Page.
 */

public class TeacherVM extends TeacherDTO {

  private Long departmentId;
  private Long divisionid;

  public TeacherVM() {
    // Empty constructor needed for Jackson?
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public Long getDivisionid() {
    return divisionid;
  }

  public void setDivisionid(Long divisionid) {
    this.divisionid = divisionid;
  }

  @Override
  public String toString() {
    return "TeacherVM [departmentId=" + departmentId + ", divisionid=" + divisionid + "]";
  }

}
