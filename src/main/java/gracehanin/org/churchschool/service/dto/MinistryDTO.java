package gracehanin.org.churchschool.service.dto;

/**
 * Ministry DTO
 */
public class MinistryDTO {

  private long id;
  private String name;

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

  @Override
  public String toString() {
    return "MinistryDTO [id=" + id + ", name=" + name + "]";
  }

}
