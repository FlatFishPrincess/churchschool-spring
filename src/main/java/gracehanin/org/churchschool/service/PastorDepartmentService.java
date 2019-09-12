package gracehanin.org.churchschool.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gracehanin.org.churchschool.model.PastorDepartment;
import gracehanin.org.churchschool.repository.PastorDepartmentRepository;
import gracehanin.org.churchschool.service.dto.PastorDepartmentDTO;
import gracehanin.org.churchschool.service.mapper.PastorDepartmentMapper;

@Service
public class PastorDepartmentService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    private PastorDepartmentRepository pastorDepartmentRepository;
    private PastorDepartmentMapper pastorDepartmentMapper;

    public PastorDepartmentService(PastorDepartmentRepository pastorDepartmentRepository, PastorDepartmentMapper pastorDepartmentMapper){
        this.pastorDepartmentRepository = pastorDepartmentRepository;
        this.pastorDepartmentMapper = pastorDepartmentMapper;
    }
    
    @Transactional(readOnly = true)
    public Page<PastorDepartmentDTO> findAll(Pageable pageable) {
        System.out.println("---------find all triggered---------");
        return pastorDepartmentRepository.findAll(pageable)
            .map(pastorDepartmentMapper::toDto);
    }

    public PastorDepartmentDTO save(PastorDepartmentDTO pastorDepartmentDTO) {
        System.out.println("---------dept save all triggered---------");
        log.error("save pastorDepartment, get dto: {}", pastorDepartmentDTO);
        PastorDepartment pastorDepartment = pastorDepartmentMapper.toEntity(pastorDepartmentDTO);
        log.error("pastorDepartment to entity: {}", pastorDepartment);
        pastorDepartment = pastorDepartmentRepository.save(pastorDepartment);
        return pastorDepartmentMapper.toDto(pastorDepartment);
    }

    public Optional<PastorDepartmentDTO> findOne(Long id) {
        System.out.println("---------Finding one pastor pastorDepartment by id triggered---------");
        Optional<PastorDepartmentDTO> dOptional = pastorDepartmentRepository.findById(id).map(dep -> pastorDepartmentMapper.toDto(dep));
        return dOptional;
    }

}