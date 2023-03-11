package com.consultation.consultation.controller;

import com.consultation.consultation.dto.BaseResponseJson;
import com.consultation.consultation.dto.request.AccountRequestDTO;
import com.consultation.consultation.dto.request.CommentRequestDTO;
import com.consultation.consultation.service.ICommentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.consultation.consultation.constant.GlobalConstant.SUKSES_SIMPAN;

@RestController(value = "Comment Controller")
@RequestMapping("/comment/")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/user/add-comment")
    @Operation(tags = "Comment")
    public ResponseEntity<BaseResponseJson> addComment(@RequestBody CommentRequestDTO request) {
        BaseResponseJson base = new BaseResponseJson();
        base.setMessage(SUKSES_SIMPAN);
        base.setData(commentService.saveComment(request));
        return ResponseEntity.ok().body(base);
    }
}
