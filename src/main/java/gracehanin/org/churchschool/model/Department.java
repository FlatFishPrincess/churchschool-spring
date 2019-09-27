package gracehanin.org.churchschool.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import gracehanin.org.churchschool.model.enumeration.Room;

@Entity
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String name;

  @Column
  private Room room;

  @ManyToOne
  private Ministry ministry;

  @OneToMany(mappedBy = "department")
  private Set<PastorDepartment> pastorDepartments = new HashSet<>();

  @OneToMany(mappedBy = "department")
  private Set<Division> divisoins = new HashSet<>();

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

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Ministry getMinistry() {
    return ministry;
  }

  public void setMinistry(Ministry ministry) {
    this.ministry = ministry;
  }

  public Set<PastorDepartment> getPastorDepartments() {
    return pastorDepartments;
  }

  public void setPastorDepartments(Set<PastorDepartment> pastorDepartments) {
    this.pastorDepartments = pastorDepartments;
  }

  public Set<Division> getDivisoins() {
    return divisoins;
  }

  public void setDivisoins(Set<Division> divisoins) {
    this.divisoins = divisoins;
  }

  @Override
  public String toString() {
    return "Department [divisoins=" + divisoins + ", id=" + id + ", ministry=" + ministry + ", name=" + name
        + ", pastorDepartments=" + pastorDepartments + ", room=" + room + "]";
  }
}