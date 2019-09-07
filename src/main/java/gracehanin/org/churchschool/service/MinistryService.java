package gracehanin.org.churchschool.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gracehanin.org.churchschool.model.Ministry;
import gracehanin.org.churchschool.repository.MinistryRepository;
import gracehanin.org.churchschool.service.dto.MinistryDTO;
import gracehanin.org.churchschool.service.mapper.MinistryMapper;

@Service
public class MinistryService {

    private MinistryRepository ministryRepository;
    private MinistryMapper ministryMapper;
    
    public MinistryService(MinistryRepository ministryRepository, MinistryMapper ministryMapper){
        this.ministryRepository = ministryRepository;
        this.ministryMapper = ministryMapper;
    }
    
    @Transactional(readOnly = true)
    public Page<MinistryDTO> findAll(Pageable pageable) {
        System.out.println("---------find all triggered---------");
        return ministryRepository.findAll(pageable)
            .map(ministryMapper::toDto);
    }

    public MinistryDTO save(MinistryDTO ministryDTO) {
        System.out.println("---------save all triggered---------");
        Ministry ministry = ministryMapper.toEntity(ministryDTO);
        ministry = ministryRepository.save(ministry);
        return ministryMapper.toDto(ministry);
    }

}