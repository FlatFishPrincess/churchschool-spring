package gracehanin.org.churchschool.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import gracehanin.org.churchschool.service.MinistryService;
import gracehanin.org.churchschool.service.dto.MinistryDTO;

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

  @GetMapping("/ministries")
  public String getAllMinistries(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
  // public ResponseEntity<List<MinistryDTO>> getAllMinistries(Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
    return "return ministries";
      // Page<MinistryDTO> page = ministryService.findAll(pageable);
      // HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
      // return ResponseEntity.ok().headers(headers).body(page.getContent());
  }
}