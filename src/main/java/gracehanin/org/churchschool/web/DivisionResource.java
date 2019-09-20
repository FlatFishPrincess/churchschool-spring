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

import gracehanin.org.churchschool.service.DivisionService;
import gracehanin.org.churchschool.service.dto.DivisionDTO;
import gracehanin.org.churchschool.web.vm.AllTeacherListVM;

/**
 * Teacher Resource
 *
 */
@RestController
@RequestMapping(path = "/api")
public class DivisionResource {

  private DivisionService divisionService;

  public DivisionResource(DivisionService divisionService) {
    this.divisionService = divisionService;
  }

  @GetMapping("/divisions")
  public Page<DivisionDTO> getAllTeacherDivisions(Pageable pageable,
      @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
    Page<DivisionDTO> page = divisionService.findAll(pageable);
    return page;
  }

  @PostMapping("/divisions")
  @ResponseStatus(HttpStatus.CREATED)
  public DivisionDTO assignTeacherToDivision(@RequestBody DivisionDTO teacherDTO) {
    DivisionDTO result = divisionService.save(teacherDTO);
    return result;
  }

  @GetMapping("/divisions/{id}")
  public Optional<DivisionDTO> getTeacherById(@PathVariable Long id) {
    Optional<DivisionDTO> tOptional = divisionService.findOne(id);
    return tOptional;
  }

  @PutMapping("/divisions/{id}")
  public DivisionDTO updateTeacherById(@PathVariable Long id, @RequestBody @Validated DivisionDTO teacherDivisionDTO) {
    DivisionDTO savedDto = divisionService.save(teacherDivisionDTO);
    return savedDto;
  }

}