package gracehanin.org.churchschool.web.vm;

import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;

/**
 * View Model for All Teacher List Page.
 */

public class AllTeacherListVM extends TeacherDivisionDTO {

  private String departmentName;

  private String ministryName;

  private Long numberOfStudents;

  private String personId;

  public AllTeacherListVM() {
    // Empty constructor needed for Jackson..?what?
  }

  public AllTeacherListVM(TeacherDivisionDTO teacherDivisionDTO) {
    // FIXME: very ugly construction, need to fix it
    this.setId(teacherDivisionDTO.getId());
    this.setTeacherId(teacherDivisionDTO.getTeacherId());
    this.setPersonId(teacherDivisionDTO.getPersonId());
    this.setTeacherType(teacherDivisionDTO.getTeacherType());
    this.setStartDate(teacherDivisionDTO.getStartDate());
    this.setEndDate(teacherDivisionDTO.getEndDate());
    this.setDivisionId(teacherDivisionDTO.getDivisionId());
    this.setDivisionName(teacherDivisionDTO.getDivisionName());
    this.setTermId(teacherDivisionDTO.getTermId());
    this.setTermName(teacherDivisionDTO.getTermName());
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

  public Long getNumberOfStudents() {
    return numberOfStudents;
  }

  public void setNumberOfStudents(Long numberOfStudents) {
    this.numberOfStudents = numberOfStudents;
  }

  @Override
  public String getPersonId() {
    return personId;
  }

  @Override
  public void setPersonId(String personId) {
    this.personId = personId;
  }

  @Override
  public String toString() {
    return "AllTeacherListVM [departmentName=" + departmentName + ", ministryName="
        + ministryName + ", numberOfStudents=" + numberOfStudents + ", personId=" + personId + "]";
  }

}
