package lt.jonas.accounting.controllers;

import lt.jonas.accounting.converters.UserConverter;
import lt.jonas.accounting.dto.UserDTO;
import lt.jonas.accounting.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Users")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createUser(UserConverter.convertUserDTOToUser(userDTO)));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateUser(UserConverter.convertUserDTOToUser(userDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
        Pageable pageable = null;
        if (pageNumber != null) {
            if (pageSize == null) {
                pageSize = 5;
            }
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        return ResponseEntity.ok(userService.getUsers(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
