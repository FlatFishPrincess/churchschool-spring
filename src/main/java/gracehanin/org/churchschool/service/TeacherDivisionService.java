package gracehanin.org.churchschool.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gracehanin.org.churchschool.model.TeacherDivision;
import gracehanin.org.churchschool.repository.TeacherDivisionRepository;
import gracehanin.org.churchschool.repository.TeacherRepository;
import gracehanin.org.churchschool.service.dto.TeacherDivisionDTO;
import gracehanin.org.churchschool.service.mapper.TeacherDivisionMapper;
import gracehanin.org.churchschool.web.vm.AllTeacherListVM;

@Service
public class TeacherDivisionService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private TeacherDivisionRepository teacherDivisionRepository;
    private TeacherDivisionMapper teacherDivisionMapper;
    private TeacherRepository teacherRepository;

    public TeacherDivisionService(TeacherDivisionRepository teacherDivisionRepository,
            TeacherDivisionMapper teacherDivisionMapper, TeacherRepository teacherRepository) {
        this.teacherDivisionRepository = teacherDivisionRepository;
        this.teacherRepository = teacherRepository;
        this.teacherDivisionMapper = teacherDivisionMapper;
    }

    @Transactional(readOnly = true)
    public Page<TeacherDivisionDTO> findAll(Pageable pageable) {
        System.out.println("---------find all triggered---------");
        return teacherDivisionRepository.findAll(pageable).map(teacherDivisionMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<TeacherDivisionDTO> findAllTest(Pageable pageable) {
        System.out.println("---------find all teacher list view model triggered---------");
        List<TeacherDivision> test = teacherDivisionRepository.findAll();
        // List<TeacherDivisionDTO> test2 =

        // Page<AllTeacherListVM> dtoPage = test.map(new Converter<TeacherDivisionDTO,
        // AllTeacherListVM>() {
        // @Override
        // public AllTeacherListVM convert(TeacherDivisionDTO dto) {
        // AllTeacherListVM vm = new AllTeacherListVM();
        // // Conversion logic

        // return vm;
        // }
        // });
        return null;
    }

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