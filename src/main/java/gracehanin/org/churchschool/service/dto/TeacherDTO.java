package gracehanin.org.churchschool.service.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * TeacherDTO
 */
public class TeacherDTO {

  private Long id;

  private String personId;

  private Set<TeacherDivisionDTO> teacherDivisions = new HashSet<>();

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

  public Set<TeacherDivisionDTO> getTeacherDivisions() {
    return teacherDivisions;
  }

  public void setTeacherDivisions(Set<TeacherDivisionDTO> teacherDivisions) {
    this.teacherDivisions = teacherDivisions;
  }

  @Override
  public String toString() {
    return "TeacherDTO [id=" + id + ", personId=" + personId + "]";
  }

}
