package gracehanin.org.churchschool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class CMClass {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @OneToMany(mappedBy = "cmClass")
  private Set<ClassTeacher> classTeachers = new HashSet<>();

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

  public Set<ClassTeacher> getClassTeachers() {
    return classTeachers;
  }

  public void setClassTeachers(Set<ClassTeacher> classTeachers) {
    this.classTeachers = classTeachers;
  }

  @Override
  public String toString() {
    return "Class [classTeachers=" + classTeachers + ", id=" + id + ", name=" + name + "]";
  }

}