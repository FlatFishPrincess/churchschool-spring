package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.Ministry;
import gracehanin.org.churchschool.service.dto.MinistryDTO;
import org.mapstruct.Mapper;

import antlr.collections.List;

// @Mapper
// public interface MinistryMapper {

//   MinistryDTO toProductDTO(Ministry ministry);

//   List<MinistryDTO> toProductDTOs(List<Ministry> products);

//   Ministry toEntity(MinistryDTO ministryDTO);


//   Ministry toEntity(MinistryDTO ministryDTO);

//   default Ministry fromId(Long id) {
//     if (id == null) {
//         return null;
//     }
//     Ministry ministry = new Ministry();
//     ministry.setId(id);
//     return ministry;
//   }
// }


@Mapper(componentModel = "spring", uses = {})
public interface MinistryMapper extends EntityMapper<MinistryDTO, Ministry>{

  Ministry toEntity(MinistryDTO ministryDTO);

  default Ministry fromId(Long id) {
    if (id == null) {
        return null;
    }
    Ministry ministry = new Ministry();
    ministry.setId(id);
    return ministry;
  }
}

//     @Mapping(target = "departments", ignore = true)
//     @Mapping(target = "removeDepartment", ignore = true)
//     Ministry toEntity(MinistryDTO ministryDTO);
