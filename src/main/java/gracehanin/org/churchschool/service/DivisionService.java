package gracehanin.org.churchschool.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gracehanin.org.churchschool.model.Division;
import gracehanin.org.churchschool.repository.DivisionRepository;
import gracehanin.org.churchschool.service.dto.DivisionDTO;
import gracehanin.org.churchschool.service.mapper.DivisionMapper;
import gracehanin.org.churchschool.web.vm.AllTeacherListVM;

@Service
public class DivisionService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private DivisionRepository divisionRepository;
    private DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
    }

    @Transactional(readOnly = true)
    public Page<DivisionDTO> findAll(Pageable pageable) {
        System.out.println("---------find all triggered---------");
        return divisionRepository.findAll(pageable).map(divisionMapper::toDto);
    }

    public DivisionDTO save(DivisionDTO divisionDTO) {
        System.out.println("---------division division save triggered---------");
        Division division = divisionMapper.toEntity(divisionDTO);
        log.info("division to entity: {}", division);
        division = divisionRepository.save(division);
        return divisionMapper.toDto(division);
    }

    public Optional<DivisionDTO> findOne(Long id) {
        System.out.println("---------Finding one division by id triggered---------");
        Optional<DivisionDTO> tOptional = divisionRepository.findById(id).map(e -> divisionMapper.toDto(e));
        return tOptional;
    }

}