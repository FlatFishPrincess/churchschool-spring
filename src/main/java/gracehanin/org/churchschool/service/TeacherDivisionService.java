package gracehanin.org.churchschool.service;

import gracehanin.org.churchschool.model.TeacherDivision;
import gracehanin.org.churchschool.repository.DepartmentRepository;
import gracehanin.org.churchschool.repository.DivisionRepository;
import gracehanin.org.churchschool.repository.TeacherDivisionRepository;
import gracehanin.org.churchschool.repository.TeacherRepository;
import gracehanin.org.churchschool.service.dto.DepartmentDTO;
import gracehanin.org.churchschool.service.dto.DivisionDTO;
import gracehanin.org.churchschool.service.dto.TeacherDTO;
import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;
import gracehanin.org.churchschool.service.mapper.*;
import gracehanin.org.churchschool.web.vm.AllTeacherListVM;
// import gracehanin.org.churchschool.web.vm.TeacherDetailVM;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherDivisionService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private DivisionRepository divisionRepository;
    private DepartmentRepository departmentRepository;
    private TeacherDivisionRepository teacherDivisionRepository;
    private TeacherRepository teacherRepository;
    private DivisionMapper divisionMapper;
    private DepartmentMapper departmentMapper;
    private TeacherMapper teacherMapper;
    private TeacherDivisionMapper teacherDivisionMapper;

    public TeacherDivisionService(TeacherDivisionRepository teacherDivisionRepository,
            TeacherDivisionMapper teacherDivisionMapper, TeacherRepository teacherRepository,
            DivisionMapper divisionMapper, DepartmentRepository departmentRepository, DepartmentMapper departmentMapper,
            DivisionRepository divisionRepository, TeacherMapper teacherMapper) {
        this.teacherDivisionRepository = teacherDivisionRepository;
        this.teacherRepository = teacherRepository;
        this.teacherDivisionMapper = teacherDivisionMapper;
        this.divisionMapper = divisionMapper;
        this.departmentRepository = departmentRepository;
        this.divisionRepository = divisionRepository;
        this.departmentMapper = departmentMapper;
        this.teacherMapper = teacherMapper;
    }

    @Transactional(readOnly = true)
    public Page<TeacherDivisionDTO> findAll(Pageable pageable) {
        System.out.println("---------find all triggered---------");
        return teacherDivisionRepository.findAll(pageable).map(teacherDivisionMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<AllTeacherListVM> findAllTest(Pageable pageable) {
        System.out.println("---------find all teacher list view model triggered---------");
        Page<TeacherDivisionDTO> teacherDivisions = teacherDivisionRepository.findAll(pageable)
                .map(teacherDivisionMapper::toDto);
        List<AllTeacherListVM> teacherListView = new ArrayList<AllTeacherListVM>();
        teacherDivisions.forEach(td -> {
            AllTeacherListVM tVm = new AllTeacherListVM(td);
            DivisionDTO divisionDTO = divisionMapper.toDto(divisionRepository.getOne(tVm.getDivisionId()));
            DepartmentDTO departmentDTO = departmentMapper
                    .toDto(departmentRepository.getOne(divisionDTO.getDepartmentId()));
            tVm.setDepartmentName(departmentDTO.getName());
            tVm.setMinistryName(departmentDTO.getMinistryName());
            tVm.setNumberOfStudents(teacherDivisionRepository.count());
            teacherListView.add(tVm);
        });
        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > teacherListView.size() ? teacherListView.size()
                : (start + pageable.getPageSize());
        Page<AllTeacherListVM> teacherListViewPage = new PageImpl<AllTeacherListVM>(teacherListView.subList(start, end),
                pageable, teacherListView.size());
        return teacherListViewPage;
    }

    // public TeacherDetailVM getTeacherDetail(Long teacherId) {
    //     TeacherDTO teacherDTO = teacherMapper.toDto(teacherRepository.getOne(teacherId));

    //     return null;
    // }

    public TeacherDivisionDTO save(TeacherDivisionDTO teacherDivisionDTO) {
        System.out.println("---------teacherDivision save triggered---------");
        validateTeacherExist(teacherDivisionDTO.getTeacherId());
        TeacherDivision teacherDivision = teacherDivisionMapper.toEntity(teacherDivisionDTO);
        log.info("teacherDivision to entity: {}", teacherDivision);
        teacherDivision = teacherDivisionRepository.save(teacherDivision);
        return teacherDivisionMapper.toDto(teacherDivision);
    }

    public Optional<TeacherDivisionDTO> findOne(Long id) {
        System.out.println("---------Finding one teacherDivision by id triggered---------");
        Optional<TeacherDivisionDTO> tOptional = teacherDivisionRepository.findById(id)
                .map(e -> teacherDivisionMapper.toDto(e));
        return tOptional;
    }

    public void validateTeacherExist(Long id) {
        if (teacherRepository.findById(id) != null) {
            log.info("existing teacherDivision id, valid! ");
        } else {
            new Exception("teacherDivision should exist");
        }
    }

}