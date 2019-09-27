package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.Division;
import gracehanin.org.churchschool.service.dto.DivisionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { DepartmentMapper.class })
public interface DivisionMapper extends EntityMapper<DivisionDTO, Division> {

  @Mapping(source = "department.id", target = "departmentId")
  @Mapping(source = "department.name", target = "departmentName")
  DivisionDTO toDto(Division division);

  @Mapping(source = "departmentId", target = "department.id")
  @Mapping(source = "departmentName", target = "department.name")
  Division toEntity(DivisionDTO divisionDTO);

}
