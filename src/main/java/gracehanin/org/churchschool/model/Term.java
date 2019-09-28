package gracehanin.org.churchschool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Term {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @Column
  private String description;

  @OneToMany(mappedBy = "term")
  private Set<PastorDepartment> pastorDepartments = new HashSet<>();

  @OneToMany(mappedBy = "term")
  private Set<TeacherDivision> teacherDivisions = new HashSet<>();

  @OneToMany(mappedBy = "term")
  private Set<Division> divisions = new HashSet<>();

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

  public Set<PastorDepartment> getPastorDepartments() {
    return pastorDepartments;
  }

  public void setPastorDepartments(Set<PastorDepartment> pastorDepartments) {
    this.pastorDepartments = pastorDepartments;
  }

  public Set<TeacherDivision> getTeacherDivisions() {
    return teacherDivisions;
  }

  public void setTeacherDivisions(Set<TeacherDivision> teacherDivisions) {
    this.teacherDivisions = teacherDivisions;
  }

  public Set<Division> getDivisions() {
    return divisions;
  }

  public void setDivisions(Set<Division> divisions) {
    this.divisions = divisions;
  }

  @Override
  public String toString() {
    return "Term [description=" + description + ", divisions=" + divisions + ", id=" + id + ", name=" + name
        + ", pastorDepartments=" + pastorDepartments + ", teacherDivisions=" + teacherDivisions + "]";
  }

}