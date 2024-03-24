package lt.jonas.accounting.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.Role;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name; //nickname
    @Column(name = "username")
    private String userName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Invoice> invoices;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
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
