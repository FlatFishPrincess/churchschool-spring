package gracehanin.org.churchschool.model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class PastorDepartment {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  @Column
  private Date startDate;

  @Column
  private Date endDate;

  @ManyToOne
  private Department department;

  @ManyToOne
  private Pastor pastor;
  
  @ManyToOne
  private Term term;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public Pastor getPastor() {
    return pastor;
  }

  public void setPastor(Pastor pastor) {
    this.pastor = pastor;
  }

  public Term getTerm() {
    return term;
  }

  public void setTerm(Term term) {
    this.term = term;
  }

  @Override
  public String toString() {
    return "PastorDepartment [department=" + department + ", endDate=" + endDate + ", id=" + id + ", pastor=" + pastor
        + ", startDate=" + startDate + ", term=" + term + "]";
  }

}