package gracehanin.org.churchschool.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class ClassTeacher {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(cascade = {CascadeType.ALL})
  private Teacher teacher;

  @OneToMany(mappedBy = "classTeacher")
  private Attendance attendance;

  @ManyToOne(cascade = {CascadeType.ALL})
  private CMClass cmClass;

  @ManyToOne(cascade = {CascadeType.ALL})
  private Term term;

  private LocalDate startDate;

  private LocalDate endDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Attendance getAttendance() {
    return attendance;
  }

  public void setAttendance(Attendance attendance) {
    this.attendance = attendance;
  }

  public CMClass getCmClass() {
    return cmClass;
  }

  public void setCmClass(CMClass cmClass) {
    this.cmClass = cmClass;
  }

  public Term getTerm() {
    return term;
  }

  public void setTerm(Term term) {
    this.term = term;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "ClassTeacher [attendance=" + attendance + ", cmClass=" + cmClass + ", endDate=" + endDate + ", id=" + id
        + ", startDate=" + startDate + ", teacher=" + teacher + ", term=" + term + "]";
  }

  
}