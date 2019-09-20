package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.Division;
import gracehanin.org.churchschool.service.dto.DivisionDTO;

import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface DivisionMapper extends EntityMapper<DivisionDTO, Division> {

  DivisionDTO toDto(Division division);

  Division toEntity(DivisionDTO divisionDTO);

}
