package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.service.DepartmentService;
import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;
import gracehanin.org.churchschool.web.vm.AllTeacherListVM2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// @Mapper(componentModel = "spring", uses = { DepartmentService.class })
// public interface AllTeacherListVM2Mapper {
// // extends EntityMapper<AllTeacherListVM2, TeacherDivisionDTO>

// @Mapping(target = "ministryName", expression =
// "java(DepartmentService.findDepartmentByDivisionId(divisionId))")
// @Mapping(source = "id", target = "numberOfStudents")
// AllTeacherListVM2 toVm(TeacherDivisionDTO teacherDivisionDTO);

// TeacherDivisionDTO toDto(AllTeacherListVM2 teacherListVM2);
// }
