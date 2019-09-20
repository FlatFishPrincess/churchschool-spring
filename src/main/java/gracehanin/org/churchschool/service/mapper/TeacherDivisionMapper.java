package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.TeacherDivision;
import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { DivisionMapper.class, TeacherMapper.class })
public interface TeacherDivisionMapper extends EntityMapper<TeacherDivisionDTO, TeacherDivision> {

  @Mapping(source = "division.id", target = "divisionId")
  @Mapping(source = "teacher.id", target = "teacherId")
  TeacherDivisionDTO toDto(TeacherDivision teacherDivision);

  @Mapping(source = "divisionId", target = "division.id")
  @Mapping(source = "teacherId", target = "teacher.id")

  TeacherDivision toEntity(TeacherDivisionDTO teacherDivisionDTO);

}
