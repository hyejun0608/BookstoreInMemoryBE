package com.hyejun0608.BookstoreInMemoryBE.controller;

import com.hyejun0608.BookstoreInMemoryBE.dto.request.RecordRequestDTO;
import com.hyejun0608.BookstoreInMemoryBE.dto.response.RecordResponseDTO;
import com.hyejun0608.BookstoreInMemoryBE.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // REST API를 처리하는 controller로 등록
@RequestMapping("/record") // 리소스 설정
@RequiredArgsConstructor // final 필드에 대해 생성자를 만들어줌
public class RecordController {

    private final RecordService recordService;

    @GetMapping
    public List<RecordResponseDTO> getRecord() {
        return recordService.getRecordList();
    }

    @PostMapping
    public void createRecord(@RequestBody RecordRequestDTO request) {
        recordService.createRecord(request);
    }
}
