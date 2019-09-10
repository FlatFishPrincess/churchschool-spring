package gracehanin.org.churchschool.web;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import gracehanin.org.churchschool.service.DepartmentService;
import gracehanin.org.churchschool.service.dto.DepartmentDTO;

import org.springframework.http.*;

/**
 * Ministry Resource 
 *
 */
@RestController
@RequestMapping(path = "/api")
public class DepartmentResource {
  
  private DepartmentService departmentService;

  public DepartmentResource(DepartmentService departmentService) {
      this.departmentService = departmentService;
  }

  @GetMapping("/departments")
  public Page<DepartmentDTO> getAllDepartments(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
    Page<DepartmentDTO> page = departmentService.findAll(pageable);
    return page;
  }

  @PostMapping("/departments")
  @ResponseStatus(HttpStatus.CREATED)
  public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
    DepartmentDTO result = departmentService.save(departmentDTO);
    return result;
  }

  @GetMapping("/departments/{id}")
  public Optional<DepartmentDTO> getMinistryById(@PathVariable Long id) {
    Optional<DepartmentDTO> dOptional = departmentService.findOne(id);
    return dOptional;
  }

  @PutMapping("/departments/{id}")
  public DepartmentDTO updateMinistryById(@PathVariable Long id, @RequestBody @Validated DepartmentDTO departmentDtoToUpdate){
    verifyDepartmentId(id);
    departmentDtoToUpdate.setId(id);
    DepartmentDTO savedDto = departmentService.save(departmentDtoToUpdate);
    return savedDto;
  }

  private void verifyDepartmentId(Long id) {
    Optional<DepartmentDTO> dOptional = departmentService.findOne(id);
    if(dOptional == null){
      throw new NoSuchElementException("Ministry does not exist " + id);
    }
  }

}