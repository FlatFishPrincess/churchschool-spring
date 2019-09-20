package gracehanin.org.churchschool.service.dto;

/**
 * TeacherDTO
 */
public class TeacherDTO {

  private Long id;
  private String personId;

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

  @Override
  public String toString() {
    return "TeacherDTO [id=" + id + ", personId=" + personId + "]";
  }

}
