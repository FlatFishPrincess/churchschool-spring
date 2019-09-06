package gracehanin.org.churchschool.service.dto;

/**
 * Ministry DTO
 */
public class MinistryDTO {

  private long Id;
  private String name;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "MinistryDTO [Id=" + Id + ", name=" + name + "]";
  }

}
