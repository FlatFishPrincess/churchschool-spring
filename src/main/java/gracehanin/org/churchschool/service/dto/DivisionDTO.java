package gracehanin.org.churchschool.service.dto;

/**
 * DivisionDTO
 */
public class DivisionDTO {

  private Long id;

  private String name;

  private String description;

  private Long departmentId;

  private String departmentName;

  private Long termId;

  private String termName;
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public Long getTermId() {
    return termId;
  }

  public void setTermId(Long termId) {
    this.termId = termId;
  }

  public String getTermName() {
    return termName;
  }

  public void setTermName(String termName) {
    this.termName = termName;
  }

  @Override
  public String toString() {
    return "DivisionDTO [departmentId=" + departmentId + ", departmentName=" + departmentName + ", description="
        + description + ", id=" + id + ", name=" + name + ", termId=" + termId + ", termName=" + termName + "]";
  }
}
