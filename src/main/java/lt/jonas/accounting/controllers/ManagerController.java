package lt.jonas.accounting.controllers;

import lt.jonas.accounting.converters.ManagerConverter;

import lt.jonas.accounting.dto.ManagerDTO;

import lt.jonas.accounting.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping
    public ResponseEntity<ManagerDTO> createManager(@RequestBody ManagerDTO managerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(managerService.createManager(ManagerConverter.convertManagerDTOToManager(managerDTO)));
    }

    @PutMapping
    public ResponseEntity<ManagerDTO> updateManager(@RequestBody ManagerDTO managerDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(managerService.updateManager(ManagerConverter.convertManagerDTOToManager(managerDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> getManagerById(@PathVariable Long id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }

    @GetMapping
    public ResponseEntity<List<ManagerDTO>> getAllManagers(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
        Pageable pageable = null;
        if (pageNumber != null) {
            if (pageSize == null) {
                pageSize = 5;
            }
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        return ResponseEntity.ok(managerService.getManagers(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManagerById(@PathVariable Long id) {
        managerService.deleteManagerById(id);
        return ResponseEntity.noContent().build();
    }

}
