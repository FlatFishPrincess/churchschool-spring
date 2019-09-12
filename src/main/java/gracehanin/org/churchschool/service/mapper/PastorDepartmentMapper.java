package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.PastorDepartment;
import gracehanin.org.churchschool.service.dto.PastorDepartmentDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // , uses = {MinistryMapper.class}
public interface PastorDepartmentMapper extends EntityMapper<PastorDepartmentDTO, PastorDepartment>{

  @Mapping(source = "department.id", target = "departmentId" )
  @Mapping(source = "department.name", target = "departmentName" )
  @Mapping(source = "pastor.id", target = "pastorId" )
  @Mapping(source = "pastor.personId", target = "personId" )
  @Mapping(source = "term.id", target = "termId" )
  @Mapping(source = "term.name", target = "termName" )
  PastorDepartmentDTO toDto(PastorDepartment pastorDepartment);

  @Mapping(source = "departmentId", target = "department.id" )
  @Mapping(source = "departmentName", target = "department.name" )
  @Mapping(source = "pastorId", target = "pastor.id")
  @Mapping(source = "personId", target = "pastor.personId")
  @Mapping(source = "termId", target = "term.id")
  @Mapping(source = "termName", target = "term.name" )
  PastorDepartment toEntity(PastorDepartmentDTO pastorDepartmentDTO);

}
