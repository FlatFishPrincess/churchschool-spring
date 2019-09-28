package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.TeacherDivision;
import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { DivisionMapper.class, TeacherMapper.class, TermMapper.class })
public interface TeacherDivisionMapper extends EntityMapper<TeacherDivisionDTO, TeacherDivision> {

  @Mapping(source = "division.id", target = "divisionId")
  @Mapping(source = "division.name", target = "divisionName")
  @Mapping(source = "teacher.id", target = "teacherId")
  @Mapping(source = "teacher.personId", target = "personId")
  @Mapping(source = "term.id", target = "termId")
  @Mapping(source = "term.name", target = "termName")
  TeacherDivisionDTO toDto(TeacherDivision teacherDivision);

  @Mapping(source = "divisionId", target = "division.id")
  @Mapping(source = "divisionName", target = "division.name")
  @Mapping(source = "teacherId", target = "teacher.id")
  @Mapping(source = "personId", target = "teacher.personId")
  @Mapping(source = "termId", target = "term.id")
  @Mapping(source = "termName", target = "term.name")
  TeacherDivision toEntity(TeacherDivisionDTO teacherDivisionDTO);

}
