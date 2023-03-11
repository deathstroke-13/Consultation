package com.consultation.consultation.service.impl;

import com.consultation.consultation.constant.GlobalConstant;
import com.consultation.consultation.dto.queryDto.GetAllRatingConsultant;
import com.consultation.consultation.dto.request.ConsultantRequestDTO;
import com.consultation.consultation.dto.request.PagingBaseRequestDTO;
import com.consultation.consultation.dto.response.ConsultantResponseDTO;
import com.consultation.consultation.entity.Comment;
import com.consultation.consultation.entity.Consultant;
import com.consultation.consultation.exception.ResourceNotAcceptableException;
import com.consultation.consultation.exception.ResourceNotFoundException;
import com.consultation.consultation.mapper.CommentMapper;
import com.consultation.consultation.mapper.ConsultantMapper;
import com.consultation.consultation.repository.CommentRepository;
import com.consultation.consultation.repository.ConsultantRepository;
import com.consultation.consultation.service.IConsultantService;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultantService implements IConsultantService {

    @Autowired
    private ConsultantMapper consultantMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ConsultantRepository consultantRepo;

    @Autowired
    private CommentRepository commentRepo;

    @Override
    public ConsultantResponseDTO viewConsultant(Long id) {

        Consultant consultant = consultantRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data Consultant Not Found"));

        List<Comment> comments = commentRepo.findAllWithConsultantIdAndTypeComment(id, GlobalConstant.CommentTypeConsul.USERTOCONS.toString());

        double ratings = 5.0;
        if(comments.size() > 0){
            ratings = comments.stream().mapToDouble(Comment::getRating).average().orElse(0);
        }

        ConsultantResponseDTO response = consultantMapper.mapEntityToDTO(consultant);
        response.setRating(ratings);
        response.setComments(commentMapper.mapListCommentEntitiesToDTO(comments));

        return response;
    }

    @Override
    public ConsultantResponseDTO saveConsultant(ConsultantRequestDTO request) {

        Optional<Consultant> consultant = consultantRepo.findByConsultantCode(request.getConsultantCode());
        if (consultant.isPresent()){
            throw new ResourceNotAcceptableException("Code Consultant Sudah Terdaftar oleh Consultant Lainnya");
        }

        Consultant consultantRequest = consultantMapper.mapDTOtoEntity(request);
        consultantRequest.setId(0L);
        return consultantMapper.mapEntityToDTO(consultantRepo.save(consultantRequest));
    }

    @Override
    public ConsultantResponseDTO updateConsultant(ConsultantRequestDTO request) {

        Optional<Consultant> consultant = consultantRepo.findByConsultantCodeAndIdIsNot(request.getConsultantCode(), request.getId());
        if (consultant.isPresent()){
            throw new ResourceNotAcceptableException("Code Consultant Sudah Terdaftar oleh Consultant Lainnya");
        }

        Consultant consultantRequest = consultantMapper.mapDTOtoEntity(request);
        return consultantMapper.mapEntityToDTO(consultantRepo.save(consultantRequest));
    }

    @Override
    public List<ConsultantResponseDTO> viewAllConsultant() {
        List<ConsultantResponseDTO> result = consultantMapper.mapListEntityToDTO(consultantRepo.findAll());
        List<Tuple> tuples = commentRepo.getAllConsultantRatings();
        List<GetAllRatingConsultant> ratings = tuples.stream().map(t -> new GetAllRatingConsultant(
                t.get(0, Long.class),
                Double.valueOf(t.get(1, BigDecimal.class).toString())
        )).toList();
        for (ConsultantResponseDTO cons :result) {
            for (GetAllRatingConsultant rating: ratings) {
                if(rating.getConsultantId().equals(cons.getId())){
                    cons.setRating(rating.getRatings());
                }
            }
        }
        return result;
    }

    @Override
    public Page<Consultant> viewPaging(PagingBaseRequestDTO request) {

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), Sort.by(createSortOrder(request.getColumnName(), request.getSort())));

        return consultantRepo.findAll(pageable);
    }

    private List<Sort.Order> createSortOrder(List<String> columnName, String sortDirection) {
        List<Sort.Order> sorts = new ArrayList<>();
        Sort.Direction direction;
        for (String sort : columnName) {
            if (sortDirection != null) {
                direction = Sort.Direction.fromString(sortDirection);
            } else {
                direction = Sort.Direction.DESC;
            }
            sorts.add(new Sort.Order(direction, sort));
        }
        return sorts;
    }
}
