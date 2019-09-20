package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.TeacherDivision;
import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { DivisionMapper.class })
public interface TeacherDivisionMapper extends EntityMapper<TeacherDivisionDTO, TeacherDivision> {

  @Mapping(source = "division.id", target = "divisionId")
  TeacherDivisionDTO toDto(TeacherDivision teacherDivision);

  @Mapping(source = "divisionId", target = "division.id")
  TeacherDivision toEntity(TeacherDivisionDTO teacherDivisionDTO);

}
