package gracehanin.org.churchschool.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gracehanin.org.churchschool.model.Teacher;
import gracehanin.org.churchschool.repository.TeacherRepository;
import gracehanin.org.churchschool.service.dto.TeacherDTO;
import gracehanin.org.churchschool.service.mapper.TeacherMapper;

@Service
public class TeacherService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private TeacherRepository teacherRepository;
    private TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Transactional(readOnly = true)
    public Page<TeacherDTO> findAll(Pageable pageable) {
        System.out.println("---------find all triggered---------");
        return teacherRepository.findAll(pageable).map(teacherMapper::toDto);
    }

    public TeacherDTO register(TeacherDTO teacherDTO) {
        System.out.println("---------teacher register triggered---------");
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        log.info("teacher to entity: {}", teacher);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    public TeacherDTO save(TeacherDTO teacherDTO) {
        System.out.println("---------teacher save triggered---------");
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        log.info("teacher to entity: {}", teacher);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    public Optional<TeacherDTO> findOne(Long id) {
        System.out.println("---------Finding one teacher by id triggered---------");
        Optional<TeacherDTO> tOptional = teacherRepository.findById(id).map(dep -> teacherMapper.toDto(dep));
        return tOptional;
    }

}