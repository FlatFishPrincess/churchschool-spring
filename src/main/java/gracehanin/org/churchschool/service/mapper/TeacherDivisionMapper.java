package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.TeacherDivision;
import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { DivisionMapper.class, TeacherMapper.class })
public interface TeacherDivisionMapper extends EntityMapper<TeacherDivisionDTO, TeacherDivision> {

  @Mapping(source = "division.id", target = "divisionId")
  @Mapping(source = "division.name", target = "divisionName")
  @Mapping(source = "teacher.id", target = "teacherId")
  @Mapping(source = "teacher.personId", target = "personId")
  TeacherDivisionDTO toDto(TeacherDivision teacherDivision);

  @Mapping(source = "divisionId", target = "division.id")
  @Mapping(source = "divisionName", target = "division.name")
  @Mapping(source = "teacherId", target = "teacher.id")
  @Mapping(source = "personId", target = "teacher.personId")
  TeacherDivision toEntity(TeacherDivisionDTO teacherDivisionDTO);

  List<TeacherDivision> toEntity(List<TeacherDivisionDTO> dtoList);

  List<TeacherDivisionDTO> toDto(List<TeacherDivision> entityList);
}
