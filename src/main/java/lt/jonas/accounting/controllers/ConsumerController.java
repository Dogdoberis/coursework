package lt.jonas.accounting.controllers;

import lt.jonas.accounting.converters.ConsumerConverter;
import lt.jonas.accounting.dto.ConsumerDTO;
import lt.jonas.accounting.exeptions.ConsumerNotFoundExeption;
import lt.jonas.accounting.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/consumers")
@PreAuthorize("hasRole('ADMIN')")
public class ConsumerController {
    String mesage = "According to the submitted search, nothing was found";
    @Autowired
    ConsumerService consumerService;


    @PostMapping
    public ResponseEntity<ConsumerDTO> createConsumer(@RequestBody ConsumerDTO consumerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(consumerService.createConsumer(ConsumerConverter.convertConsumerDtoToConsumer(consumerDTO)));
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<ConsumerDTO> getConsumerById(@PathVariable Long id) {
        return ResponseEntity.ok(consumerService.getConsumerById(id));
    }

    @GetMapping
    public ResponseEntity<List<ConsumerDTO>> getAllConsumers(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(consumerService.getConsumers(pageable));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ConsumerDTO> updateConsumer(@RequestBody ConsumerDTO consumerDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(consumerService.updateConsumer(ConsumerConverter.convertConsumerDtoToConsumer(consumerDTO)));
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchConsumers(@PageableDefault
                                             @RequestParam(required = false) String name,
                                             @RequestParam(required = false) Long code,
                                             @RequestParam(required = false) String vatCode) {
        List<ConsumerDTO> consumers = consumerService.searchConsumers(name, code, vatCode);
        try {
            if (!consumers.isEmpty()) {
            }
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.OK).body(mesage);

        }
        return ResponseEntity.ok(consumers);
    }
}
