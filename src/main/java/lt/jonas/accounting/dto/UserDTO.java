package lt.jonas.accounting.dto;

import lombok.*;
import lt.jonas.accounting.enumerators.Role;


@RequiredArgsConstructor
@Setter
@Getter
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String userNmae;
    private String password;
    private Role role;
}
