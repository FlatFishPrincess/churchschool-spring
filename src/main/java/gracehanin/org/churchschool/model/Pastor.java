package gracehanin.org.churchschool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

// pastordepartment id, pastorId, departmentid, termid, startdate, enddate
// term id, name
// pastor id, personid, departmentid
@Entity
public class Pastor {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String personId;

  @OneToMany(mappedBy = "pastor")
  private Set<PastorDepartment> pastorDepartments = new HashSet<>();

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

  public Set<PastorDepartment> getPastorDepartments() {
    return pastorDepartments;
  }

  public void setPastorDepartments(Set<PastorDepartment> pastorDepartments) {
    this.pastorDepartments = pastorDepartments;
  }

  @Override
  public String toString() {
    return "Pastor [id=" + id + ", pastorDepartments=" + pastorDepartments + ", personId=" + personId + "]";
  }


}