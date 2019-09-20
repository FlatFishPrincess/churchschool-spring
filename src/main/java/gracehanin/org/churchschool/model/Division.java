package gracehanin.org.churchschool.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Division {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @Column
  private String description;

  @OneToMany(mappedBy = "division")
  private Set<TeacherDivision> teacherDivisions = new HashSet<>();

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

  public Set<TeacherDivision> getTeacherDivisions() {
    return teacherDivisions;
  }

  public void setTeacherDivisions(Set<TeacherDivision> teacherDivisions) {
    this.teacherDivisions = teacherDivisions;
  }

  @Override
  public String toString() {
    return "Division [description=" + description + ", id=" + id + ", name=" + name + ", teacherDivisions="
        + teacherDivisions + "]";
  }

}