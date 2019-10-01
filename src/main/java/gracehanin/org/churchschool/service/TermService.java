package gracehanin.org.churchschool.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gracehanin.org.churchschool.model.Term;
import gracehanin.org.churchschool.repository.TermRepository;
import gracehanin.org.churchschool.service.dto.TermDTO;
import gracehanin.org.churchschool.service.mapper.TermMapper;

@Service
public class TermService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private TermRepository termRepository;
    private TermMapper termMapper;

    public TermService(TermRepository termRepository, TermMapper termMapper) {
        this.termRepository = termRepository;
        this.termMapper = termMapper;
    }

    @Transactional(readOnly = true)
    public Page<TermDTO> findAll(Pageable pageable) {
        System.out.println("---------find all triggered---------");
        return termRepository.findAll(pageable).map(termMapper::toDto);
    }

    public TermDTO save(TermDTO termDTO) {
        System.out.println("---------term term save triggered---------");
        Term term = termMapper.toEntity(termDTO);
        log.info("term to entity: {}", term);
        term = termRepository.save(term);
        return termMapper.toDto(term);
    }

    public Optional<TermDTO> findOne(Long id) {
        System.out.println("---------Finding one term by id triggered---------");
        Optional<TermDTO> tOptional = termRepository.findById(id).map(e -> termMapper.toDto(e));
        return tOptional;
    }

}