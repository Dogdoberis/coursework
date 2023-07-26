package lt.jonas.accounting.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.ManagerRole;
import javax.persistence.*;
import java.time.LocalDateTime;

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
    private ManagerRole managerRole;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;
    @PrePersist
    void prePersist() {
        this.created = LocalDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        this.updated = LocalDateTime.now();
    }


}
