package lt.jonas.accounting.controllers;

import lt.jonas.accounting.converters.ItemConverter;
import lt.jonas.accounting.dto.ItemDTO;
import lt.jonas.accounting.exeptions.DeleteExeption;
import lt.jonas.accounting.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@PreAuthorize("hasRole('ADMIN')")
public class ItemController {
    String mesage = "According to the submitted search, nothing was found";
    @Autowired
    ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemService.createItem(ItemConverter.convertItemDTOToItem(itemDTO)));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.updateItem(ItemConverter.convertItemDTOToItem(itemDTO)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@RequestBody Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }
    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(itemService.getItems(pageable));
    }
    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteItemById(Long id) throws DeleteExeption {
        itemService.deleteItemById(id);
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    @GetMapping("/serch")
    public ResponseEntity<?> serchItems(@PageableDefault
                                        @RequestParam(required = false) String code,
                                        @RequestParam(required = false) String title,
                                        @RequestParam(required = false) String description) {
        List<ItemDTO> itemDTOList = itemService.searchItems(code, title, description);
        try {
            if (!itemDTOList.isEmpty()) {
            }
        }catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.OK).body(mesage);
        }
        return ResponseEntity.ok(itemDTOList);
    }
}
