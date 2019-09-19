package gracehanin.org.churchschool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String personId;

  @OneToMany(mappedBy = "teacher")
  private Set<TeacherDivision> teacherDivision = new HashSet<>();

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

  public Set<TeacherDivision> getClassTeachers() {
    return teacherDivision;
  }

  public void setClassTeachers(Set<TeacherDivision> teacherDivision) {
    this.teacherDivision = teacherDivision;
  }

  @Override
  public String toString() {
    return "Teacher [teacherDivision=" + teacherDivision + ", id=" + id + ", personId=" + personId + "]";
  }

}