package lt.jonas.accounting.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.ManagerType;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "manager")
@Getter
@Setter
@RequiredArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private ManagerType managerType;


}
