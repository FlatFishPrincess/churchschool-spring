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
  private Set<ClassTeacher> classTeachers = new HashSet<>();

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

  public Set<ClassTeacher> getClassTeachers() {
    return classTeachers;
  }

  public void setClassTeachers(Set<ClassTeacher> classTeachers) {
    this.classTeachers = classTeachers;
  }

  @Override
  public String toString() {
    return "Teacher [classTeachers=" + classTeachers + ", id=" + id + ", personId=" + personId + "]";
  }

}