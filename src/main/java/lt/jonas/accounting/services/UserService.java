package lt.jonas.accounting.services;

import lombok.RequiredArgsConstructor;
import lt.jonas.accounting.converters.UserConverter;
import lt.jonas.accounting.dto.UserDTO;
import lt.jonas.accounting.entities.User;
import lt.jonas.accounting.repositories.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserDTO createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserConverter.convertUserToUserDTO(user);
    }

    public UserDTO getUserById(Long id) {
        return UserConverter.convertUserToUserDTO(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public List<UserDTO> getUsers(Pageable pageable) {
        if (pageable != null) {
            return UserConverter.convertUserPageToUserDTOList(userRepository.findAll(pageable));
        }
        return UserConverter.convertUserListToUserDTOList(userRepository.findAll());
    }


    public UserDTO updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId()).orElseThrow(NoSuchElementException::new);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setRole(user.getRole());
        userRepository.save(userToUpdate);
        return UserConverter.convertUserToUserDTO(userToUpdate);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
