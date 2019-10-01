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

import gracehanin.org.churchschool.service.TermService;
import gracehanin.org.churchschool.service.dto.TermDTO;
import gracehanin.org.churchschool.web.vm.AllTeacherListVM;

/**
 * Teacher Resource
 *
 */
@RestController
@RequestMapping(path = "/api")
public class TermResource {

  private TermService termService;

  public TermResource(TermService termService) {
    this.termService = termService;
  }

  @GetMapping("/terms")
  public Page<TermDTO> getAllTeacherDivisions(Pageable pageable,
      @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
    Page<TermDTO> page = termService.findAll(pageable);
    return page;
  }

  @PostMapping("/terms")
  @ResponseStatus(HttpStatus.CREATED)
  public TermDTO assignTeacherToDivision(@RequestBody TermDTO teacherDTO) {
    TermDTO result = termService.save(teacherDTO);
    return result;
  }

  @GetMapping("/terms/{id}")
  public Optional<TermDTO> getTeacherById(@PathVariable Long id) {
    Optional<TermDTO> tOptional = termService.findOne(id);
    return tOptional;
  }

  @PutMapping("/terms/{id}")
  public TermDTO updateTeacherById(@PathVariable Long id, @RequestBody @Validated TermDTO teacherTermDTO) {
    TermDTO savedDto = termService.save(teacherTermDTO);
    return savedDto;
  }

}