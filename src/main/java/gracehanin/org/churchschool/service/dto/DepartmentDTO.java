package gracehanin.org.churchschool.service.dto;

import gracehanin.org.churchschool.model.enumeration.Room;

/**
 * Department DTO
 */
public class DepartmentDTO {

  private long id;
  private String name;
  private Room room;
  private Long ministryId;
  private String ministryName;
  // private Set<PastorDepartment> pastorDepartments;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public Long getMinistryId() {
    return ministryId;
  }

  public void setMinistryId(Long ministryId) {
    this.ministryId = ministryId;
  }

  public String getMinistryName() {
    return ministryName;
  }

  public void setMinistryName(String ministryName) {
    this.ministryName = ministryName;
  }

  // public Set<PastorDepartment> getPastorDepartments() {
  // return pastorDepartments;
  // }

  // public void setPastorDepartments(Set<PastorDepartment> pastorDepartments) {
  // this.pastorDepartments = pastorDepartments;
  // }

  @Override
  public String toString() {
    return "DepartmentDTO [id=" + id + ", ministryId=" + ministryId + ", ministryName=" + ministryName + ", name="
        + name + ", room=" + room + "]";
  }

}
