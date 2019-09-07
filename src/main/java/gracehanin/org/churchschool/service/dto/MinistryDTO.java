package gracehanin.org.churchschool.service.dto;

/**
 * Ministry DTO
 */
public class MinistryDTO {

  private long id;
  private String name;

  public MinistryDTO(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public long getId() {
    return this.id;
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
    return "MinistryDTO [Id=" + id + ", name=" + name + "]";
  }

}
