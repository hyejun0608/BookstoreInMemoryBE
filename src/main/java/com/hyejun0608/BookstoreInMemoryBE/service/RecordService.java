package com.hyejun0608.BookstoreInMemoryBE.service;

import com.hyejun0608.BookstoreInMemoryBE.dto.response.RecordResponseDTO;
import com.hyejun0608.BookstoreInMemoryBE.entity.Record;
import com.hyejun0608.BookstoreInMemoryBE.entity.RecordRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {

    private RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Transactional
    public List<RecordResponseDTO> getRecordList() {
        List<Record> records = recordRepository.findAll();
        List<RecordResponseDTO> recordResponseDTOList = new ArrayList<>();

        for(Record record : records) {
            recordResponseDTOList.add(
                    RecordResponseDTO.builder()
                            .id(record.getId())
                            .title(record.getTitle())
                            .author(record.getAuthor())
                            .content(record.getContent())
                            .count(record.getCount())
                            .build()
            );
        }
        return recordResponseDTOList;
    }

}
