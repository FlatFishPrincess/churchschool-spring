package gracehanin.org.churchschool.model;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

import org.springframework.lang.Nullable;

import gracehanin.org.churchschool.model.enumeration.TeacherType;

@Entity
public class TeacherDivision {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  private Teacher teacher;

  @OneToMany(mappedBy = "teacherDivision")
  private Set<Attendance> attendances;

  @ManyToOne
  private Division division;

  @ManyToOne
  private Term term;

  private TeacherType teacherType;

  private LocalDate startDate;

  @Nullable
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

  public Set<Attendance> getAttendances() {
    return attendances;
  }

  public void setAttendances(Set<Attendance> attendances) {
    this.attendances = attendances;
  }

  public Division getDivision() {
    return division;
  }

  public void setDivision(Division division) {
    this.division = division;
  }

  public TeacherType getTeacherType() {
    return teacherType;
  }

  public void setTeacherType(TeacherType teacherType) {
    this.teacherType = teacherType;
  }

  @Override
  public String toString() {
    return "TeacherDivision [attendances=" + attendances + ", division=" + division + ", endDate=" + endDate + ", id="
        + id + ", startDate=" + startDate + ", teacher=" + teacher + ", teacherType=" + teacherType + ", term=" + "]";
  }

}