package lt.jonas.accounting.controllers;

import lt.jonas.accounting.converters.ConsumerConverter;
import lt.jonas.accounting.dto.ConsumerDTO;
import lt.jonas.accounting.entities.Consumer;
import lt.jonas.accounting.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/consumers")
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

    @PostMapping
    public ResponseEntity<ConsumerDTO> createConsumer(@RequestBody ConsumerDTO consumerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(consumerService.createConsumer(ConsumerConverter.convertConsumerDtoToConsumer(consumerDTO)));
    }
//    @GetMapping("/{consumer}")
//    public ResponseEntity<ConsumerDTO> getConsumerByTitle(@PathVariable Consumer consumer){
//        return ResponseEntity.ok(consumerService.getConsumerByTitle(consumer));
//    }


    @GetMapping("/{id}")
    public ResponseEntity<ConsumerDTO> getConsumerById(@PathVariable Long id) {
        return ResponseEntity.ok(consumerService.getConsumerById(id));
    }
    @GetMapping
    public ResponseEntity<List<ConsumerDTO>> getAllConsumers(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(consumerService.getConsumers(pageable));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ConsumerDTO> updateConsumer(@RequestBody ConsumerDTO consumerDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(consumerService.updateConsumer(ConsumerConverter.convertConsumerDtoToConsumer(consumerDTO)));
    }
}
