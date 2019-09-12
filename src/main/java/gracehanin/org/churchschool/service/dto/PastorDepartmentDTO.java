package gracehanin.org.churchschool.service.dto;

import java.util.Date;
/**
 * PastorDepartmentDTO DTO
 */
public class PastorDepartmentDTO {

  private long id;
  private Date startDate;
  private Date endDate;

  private Long departmentId;
  private String departmentName;
  private Long pastorId;
  private Long personId;
  private Long termId;
  private Long termName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public Long getPastorId() {
    return pastorId;
  }

  public void setPastorId(Long pastorId) {
    this.pastorId = pastorId;
  }

  public Long getTermId() {
    return termId;
  }

  public void setTermId(Long termId) {
    this.termId = termId;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public Long getTermName() {
    return termName;
  }

  public void setTermName(Long termName) {
    this.termName = termName;
  }

  @Override
  public String toString() {
    return "PastorDepartmentDTO [departmentId=" + departmentId + ", departmentName=" + departmentName + ", endDate="
        + endDate + ", id=" + id + ", pastorId=" + pastorId + ", startDate=" + startDate + ", termId=" + termId + "]";
  }
  
}
