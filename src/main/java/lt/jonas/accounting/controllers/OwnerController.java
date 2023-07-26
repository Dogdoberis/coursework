package lt.jonas.accounting.controllers;

import lt.jonas.accounting.converters.OwnerConverter;
import lt.jonas.accounting.dto.OwnerDTO;
import lt.jonas.accounting.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;
    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ownerService.createOwner(OwnerConverter.convertOwnerDtoToOwner(ownerDTO)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTO> updateOwner(@RequestBody OwnerDTO OwnerDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(ownerService.updateOwner(OwnerConverter.convertOwnerDtoToOwner(OwnerDTO)));
    }
}
