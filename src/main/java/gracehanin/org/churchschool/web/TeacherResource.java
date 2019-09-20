package gracehanin.org.churchschool.web;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import gracehanin.org.churchschool.service.TeacherService;
import gracehanin.org.churchschool.service.dto.TeacherDTO;
import gracehanin.org.churchschool.web.vm.AllTeacherListVM;

/**
 * Teacher Resource
 *
 */
@RestController
@RequestMapping(path = "/api")
public class TeacherResource {

  private TeacherService teacherService;

  public TeacherResource(TeacherService teacherService) {
    this.teacherService = teacherService;
  }

  @GetMapping("/teachers")
  public Page<TeacherDTO> getAllTeachers(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams,
      UriComponentsBuilder uriBuilder) {
    Page<TeacherDTO> page = teacherService.findAll(pageable);
    return page;
  }

  @PostMapping("/teachers")
  @ResponseStatus(HttpStatus.CREATED)
  public TeacherDTO registerTeacher(@RequestBody TeacherDTO teacherDTO) {
    TeacherDTO result = teacherService.register(teacherDTO);
    return result;
  }

  // @PostMapping("/teachers")
  // @ResponseStatus(HttpStatus.CREATED)
  // public TeacherDTO addTeacher(@RequestBody AllTeacherListVM allTeacherListVM)
  // {
  // TeacherDTO result = teacherService.save(allTeacherListVM);
  // return result;
  // }

  @GetMapping("/teachers/{id}")
  public Optional<TeacherDTO> getTeacherById(@PathVariable Long id) {
    Optional<TeacherDTO> tOptional = teacherService.findOne(id);
    return tOptional;
  }

  // @PutMapping("/teachers/{id}")
  // public TeacherDTO updateTeacherById(@PathVariable Long id, @RequestBody
  // @Validated TeacherDTO teacherDto) {
  // verifyDepartmentId(id);
  // teacherDto.setId(id);
  // // FIXME: ugly code@@
  // AllTeacherListVM allTeacherListVM = new AllTeacherListVM();
  // allTeacherListVM.setDepartmentId(id);
  // TeacherDTO savedDto = teacherService.save(allTeacherListVM);
  // return savedDto;
  // }

  // private void verifyDepartmentId(Long id) {
  // Optional<TeacherDTO> tOptional = teacherService.findOne(id);
  // if (tOptional == null) {
  // throw new NoSuchElementException("Teacher does not exist " + id);
  // }
  // }

}