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

import gracehanin.org.churchschool.service.PastorDepartmentService;
import gracehanin.org.churchschool.service.dto.PastorDepartmentDTO;

import org.springframework.http.*;

/**
 * Ministry Resource 
 *
 */
@RestController
@RequestMapping(path = "/api")
public class PastorDepartmentResource {
  
  private PastorDepartmentService pastorDepartmentService;

  public PastorDepartmentResource(PastorDepartmentService pastorDepartmentService) {
      this.pastorDepartmentService = pastorDepartmentService;
  }

  @GetMapping("/pastordepartments")
  public Page<PastorDepartmentDTO> getAllPastorDepartments(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
    Page<PastorDepartmentDTO> page = pastorDepartmentService.findAll(pageable);
    return page;
  }

  @PostMapping("/pastordepartments")
  @ResponseStatus(HttpStatus.CREATED)
  public PastorDepartmentDTO addPastorDepartment(@RequestBody PastorDepartmentDTO departmentDTO) {
    PastorDepartmentDTO result = pastorDepartmentService.save(departmentDTO);
    return result;
  }

  @GetMapping("/pastordepartments/{id}")
  public Optional<PastorDepartmentDTO> getPastorDepartmentById(@PathVariable Long id) {
    Optional<PastorDepartmentDTO> dOptional = pastorDepartmentService.findOne(id);
    return dOptional;
  }

  @PutMapping("/pastordepartments/{id}")
  public PastorDepartmentDTO updatePastorDepartmentById(@PathVariable Long id, @RequestBody @Validated PastorDepartmentDTO departmentDtoToUpdate){
    verifyPastorDepartmentId(id);
    departmentDtoToUpdate.setId(id);
    PastorDepartmentDTO savedDto = pastorDepartmentService.save(departmentDtoToUpdate);
    return savedDto;
  }

  private void verifyPastorDepartmentId(Long id) {
    Optional<PastorDepartmentDTO> pdOptional = pastorDepartmentService.findOne(id);
    if(pdOptional == null){
      throw new NoSuchElementException("PastorDepartment does not exist " + id);
    }
  }

}