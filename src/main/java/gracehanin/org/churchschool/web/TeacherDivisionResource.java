package gracehanin.org.churchschool.web;

import java.util.List;
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

import gracehanin.org.churchschool.service.TeacherDivisionService;
import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;
import gracehanin.org.churchschool.web.vm.AllTeacherListVM;

/**
 * Teacher Resource
 *
 */
@RestController
@RequestMapping(path = "/api")
public class TeacherDivisionResource {

  private TeacherDivisionService teacherDivisionService;

  public TeacherDivisionResource(TeacherDivisionService teacherDivisionService) {
    this.teacherDivisionService = teacherDivisionService;
  }

  @GetMapping("/teacher-divisions")
  public Page<TeacherDivisionDTO> getAllTeacherDivisions(Pageable pageable,
      @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
    Page<TeacherDivisionDTO> page = teacherDivisionService.findAll(pageable);
    return page;
  }

  @GetMapping("/teacher-divisions/list")
  public List<AllTeacherListVM> getList(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams,
      UriComponentsBuilder uriBuilder) {
    List<AllTeacherListVM> list = teacherDivisionService.findAllTest(pageable);
    return list;
  }

  @PostMapping("/teacher-divisions")
  @ResponseStatus(HttpStatus.CREATED)
  public TeacherDivisionDTO assignTeacherToDivision(@RequestBody TeacherDivisionDTO teacherDTO) {
    TeacherDivisionDTO result = teacherDivisionService.save(teacherDTO);
    return result;
  }

  @GetMapping("/teacher-divisions/{id}")
  public Optional<TeacherDivisionDTO> getTeacherById(@PathVariable Long id) {
    Optional<TeacherDivisionDTO> tOptional = teacherDivisionService.findOne(id);
    return tOptional;
  }

  @PutMapping("/teacher-divisions/{id}")
  public TeacherDivisionDTO updateTeacherById(@PathVariable Long id,
      @RequestBody @Validated TeacherDivisionDTO teacherDivisionDTO) {
    TeacherDivisionDTO savedDto = teacherDivisionService.save(teacherDivisionDTO);
    return savedDto;
  }

}