package gracehanin.org.churchschool.service.mapper;

import gracehanin.org.churchschool.model.Ministry;
import gracehanin.org.churchschool.service.dto.MinistryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface MinistryMapper extends EntityMapper<MinistryDTO, Ministry>{

  Ministry toEntity(MinistryDTO ministryDTO);
}

//     @Mapping(target = "departments", ignore = true)
//     @Mapping(target = "removeDepartment", ignore = true)
//     Ministry toEntity(MinistryDTO ministryDTO);

//     default Ministry fromId(Long id) {
//         if (id == null) {
//             return null;
//         }
//         Ministry ministry = new Ministry();
//         ministry.setId(id);
//         return ministry;
//     }

