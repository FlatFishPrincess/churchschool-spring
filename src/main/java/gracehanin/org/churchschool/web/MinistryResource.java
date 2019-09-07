package gracehanin.org.churchschool.web;

import java.net.URISyntaxException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("/ministries")
  public Page<MinistryDTO> getAllMinistries(Pageable pageable) {
      Page<MinistryDTO> ministryPage = ministryService.findAll(pageable);
      return ministryPage;
  }

  @GetMapping("/test")
  public String test() {
    System.out.println("test triggered?");
    return "TEST";
  }

  @PostMapping("/ministries")
  @ResponseStatus(HttpStatus.CREATED)
  public MinistryDTO createMinistry(@RequestBody MinistryDTO ministryDTO) throws URISyntaxException {
      // if (ministryDTO.getId() != 0L ) {
      //     throw new Exception("A new ministry cannot already have an ID");
      // }
      System.out.println("ministr triggered??!?!?!?!?");
      MinistryDTO result = ministryService.save(ministryDTO);
      return result;
  }

}