package gracehanin.org.churchschool.web.vm;

import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;

/**
 * View Model for All Teacher List Page.
 */

public class AllTeacherListVM extends TeacherDivisionDTO {

  private String departmentName;

  private String ministryName;

  private int numberOfStudents;

  private String className;

  private String personId;

  public AllTeacherListVM() {
    // Empty constructor needed for Jackson..?what?
  }

  public AllTeacherListVM(TeacherDivisionDTO teacherDivisionDTO) {
    this.setId(teacherDivisionDTO.getId());
    this.setTeacherId(teacherDivisionDTO.getTeacherId());
    this.setPersonId(teacherDivisionDTO.getPersonId());
    this.setTeacherType(teacherDivisionDTO.getTeacherType());
    this.setStartDate(teacherDivisionDTO.getStartDate());
    this.setEndDate(teacherDivisionDTO.getEndDate());
    this.setDivisionId(teacherDivisionDTO.getDivisionId());
    this.setDivisionName(teacherDivisionDTO.getDivisionName());
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getMinistryName() {
    return ministryName;
  }

  public void setMinistryName(String ministryName) {
    this.ministryName = ministryName;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }

  public void setNumberOfStudents(int numberOfStudents) {
    this.numberOfStudents = numberOfStudents;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
  }

  @Override
  public String toString() {
    return "AllTeacherListVM [className=" + className + ", departmentName=" + departmentName + ", ministryName="
        + ministryName + ", numberOfStudents=" + numberOfStudents + ", personId=" + personId + "]";
  }

}
