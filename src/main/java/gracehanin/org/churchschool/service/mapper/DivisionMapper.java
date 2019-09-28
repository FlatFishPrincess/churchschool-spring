package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.Division;
import gracehanin.org.churchschool.service.dto.DivisionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { DepartmentMapper.class, TermMapper.class })
public interface DivisionMapper extends EntityMapper<DivisionDTO, Division> {

  @Mapping(source = "department.id", target = "departmentId")
  @Mapping(source = "department.name", target = "departmentName")
  @Mapping(source = "term.id", target = "termId")
  @Mapping(source = "term.name", target = "termName")
  DivisionDTO toDto(Division division);

  @Mapping(source = "departmentId", target = "department.id")
  @Mapping(source = "departmentName", target = "department.name")
  @Mapping(source = "termId", target = "term.id")
  @Mapping(source = "termName", target = "term.name")
  Division toEntity(DivisionDTO divisionDTO);

}
