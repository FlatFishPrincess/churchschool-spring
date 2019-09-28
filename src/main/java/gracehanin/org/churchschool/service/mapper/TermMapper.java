package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.Term;
import gracehanin.org.churchschool.service.dto.TermDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { })
public interface TermMapper extends EntityMapper<TermDTO, Term> {

  TermDTO toDto(Term term);
  
  Term toEntity(TermDTO termDTO);

}
