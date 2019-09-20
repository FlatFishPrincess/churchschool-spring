package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.Teacher;
import gracehanin.org.churchschool.service.dto.TeacherDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends EntityMapper<TeacherDTO, Teacher> {
  TeacherDTO toDto(Teacher teacher);

  Teacher toEntity(TeacherDTO teacherDTO);

}
