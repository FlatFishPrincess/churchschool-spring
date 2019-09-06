package gracehanin.org.churchschool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Ministry {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @OneToMany(mappedBy = "ministry")
  private Set<Department> departments = new HashSet<>();

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

  public Set<Department> getDepartments() {
    return departments;
  }

  public void setDepartments(Set<Department> departments) {
    this.departments = departments;
  }

  @Override
  public String toString() {
    return "Ministry [departments=" + departments + ", id=" + id + ", name=" + name + "]";
  }

}