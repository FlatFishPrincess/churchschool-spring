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

  @OneToMany(mappedBy = "term")
  private Set<PastorDepartment> pastorDepartments = new HashSet<>();

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

  public Set<PastorDepartment> getPastorDepartments() {
    return pastorDepartments;
  }

  public void setPastorDepartments(Set<PastorDepartment> pastorDepartments) {
    this.pastorDepartments = pastorDepartments;
  }

  @Override
  public String toString() {
    return "Term [id=" + id + ", name=" + name + ", pastorDepartments=" + pastorDepartments + "]";
  }

}