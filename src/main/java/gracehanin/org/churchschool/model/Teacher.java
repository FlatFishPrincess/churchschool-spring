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
  private Set<TeacherDivision> teacherDivisions = new HashSet<>();

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

  public Set<TeacherDivision> getTeacherDivisions() {
    return teacherDivisions;
  }

  public void setTeacherDivisions(Set<TeacherDivision> teacherDivisions) {
    this.teacherDivisions = teacherDivisions;
  }

  public Teacher teacherDivisions(Set<TeacherDivision> teacherDivisions) {
    this.teacherDivisions = teacherDivisions;
    return this;
  }

  public Teacher addTeacherDivision(TeacherDivision teacherDivision) {
    this.teacherDivisions.add(teacherDivision);
    teacherDivision.setTeacher(this);
    return this;
  }

  public Teacher removeTeacherDivision(TeacherDivision teacherDivision) {
    this.teacherDivisions.remove(teacherDivision);
    teacherDivision.setTeacher(null);
    return this;
  }

}