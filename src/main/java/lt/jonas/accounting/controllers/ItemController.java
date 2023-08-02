package lt.jonas.accounting.controllers;

import lt.jonas.accounting.converters.ItemConverter;
import lt.jonas.accounting.dto.ItemDTO;
import lt.jonas.accounting.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@PreAuthorize("hasRole('ADMIN')")
public class ItemController {
    @Autowired
    ItemService itemService;
    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemService.createItem(ItemConverter.convertItemDTOToItem(itemDTO)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.updateItem(ItemConverter.convertItemDTOToItem(itemDTO)));
    }
    @GetMapping("/{id}")
    public  ResponseEntity<ItemDTO> getItemById(@RequestBody Long id){
        return ResponseEntity.ok(itemService.getItemById(id));
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id){
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}
