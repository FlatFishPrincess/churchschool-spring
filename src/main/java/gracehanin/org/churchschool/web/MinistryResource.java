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

import gracehanin.org.churchschool.service.MinistryService;
import gracehanin.org.churchschool.service.dto.MinistryDTO;

import org.springframework.http.*;

/**
 * Ministry Resource 
 *
 */
@RestController
@RequestMapping(path = "/api")
public class MinistryResource {
  
  private final MinistryService ministryService;

  public MinistryResource(MinistryService ministryService) {
      this.ministryService = ministryService;
  }

  @GetMapping("/test")
  public String test(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
    return "return test";
  }

  @GetMapping("/ministries")
  public Page<MinistryDTO> getAllMinistries(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
    Page<MinistryDTO> page = ministryService.findAll(pageable);
    return page;
  }

  @PostMapping("/ministries")
  @ResponseStatus(HttpStatus.CREATED)
  public MinistryDTO addMinistry(@RequestBody MinistryDTO ministryDTO) {
    MinistryDTO result = ministryService.save(ministryDTO);
    return result;
  }

  @GetMapping("/ministries/{id}")
  public Optional<MinistryDTO> getMinistryById(@PathVariable Long id) {
    Optional<MinistryDTO> ministryDTO = ministryService.findOne(id);
    return ministryDTO;
  }

  @PutMapping("/ministries/{id}")
  public MinistryDTO updateMinistryById(@PathVariable Long id, @RequestBody @Validated MinistryDTO ministryDtoToUpdate){
    verifyMinistryId(id);
    ministryDtoToUpdate.setId(id);
    MinistryDTO savedDto = ministryService.save(ministryDtoToUpdate);
    return savedDto;
  }

  private void verifyMinistryId(Long id) {
    Optional<MinistryDTO> ministryDto = ministryService.findOne(id);
    if(ministryDto == null){
      throw new NoSuchElementException("Ministry does not exist " + id);
    }
  }

}