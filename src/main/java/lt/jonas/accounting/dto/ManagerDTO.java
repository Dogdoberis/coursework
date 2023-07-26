package lt.jonas.accounting.dto;

import lombok.*;
import lt.jonas.accounting.enumerators.ManagerRole;


@RequiredArgsConstructor
@Setter
@Getter
public class ManagerDTO {
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private ManagerRole managerRole;
}
