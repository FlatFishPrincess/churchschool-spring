package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.Department;
import gracehanin.org.churchschool.service.dto.DepartmentDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { MinistryMapper.class })
public interface DepartmentMapper extends EntityMapper<DepartmentDTO, Department> {

  @Mapping(source = "ministry.id", target = "ministryId")
  @Mapping(source = "ministry.name", target = "ministryName")
  // @Mapping(target = "pastorDepartments", ignore = true)
  DepartmentDTO toDto(Department department);

  @Mapping(source = "ministryId", target = "ministry.id")
  @Mapping(source = "ministryName", target = "ministry.name")
  // @Mapping(target = "pastorDepartments", ignore = true)
  Department toEntity(DepartmentDTO departmentDTO);

}
