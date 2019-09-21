package gracehanin.org.churchschool.service;

import gracehanin.org.churchschool.model.Department;
import gracehanin.org.churchschool.repository.DepartmentRepository;
import gracehanin.org.churchschool.service.dto.DepartmentDTO;
import gracehanin.org.churchschool.service.mapper.DepartmentMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DepartmentService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Transactional(readOnly = true)
    public Page<DepartmentDTO> findAll(Pageable pageable) {
        System.out.println("---------find all triggered---------");
        return departmentRepository.findAll(pageable).map(departmentMapper::toDto);
    }

    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        System.out.println("---------dept save all triggered---------");
        log.info("save department, get dto: {}", departmentDTO);
        Department department = departmentMapper.toEntity(departmentDTO);
        log.info("department to entity: {}", department);
        department = departmentRepository.save(department);
        return departmentMapper.toDto(department);
    }

    public Optional<DepartmentDTO> findOne(Long id) {
        System.out.println("---------Finding one department by id triggered---------");
        Optional<DepartmentDTO> dOptional = departmentRepository.findById(id).map(dep -> departmentMapper.toDto(dep));
        return dOptional;
    }

    // public Optional<DepartmentDTO> findDepartmentByDivisionId(Long id) {
    //     System.out.println("---------Finding DepartmentDTO by id triggered---------");
    //     Optional<DepartmentDTO> dOptional = departmentRepository.findDepartmentByDivisionId(id)
    //             .map(departmentMapper::toDto);
    //     return dOptional;
    // }

}