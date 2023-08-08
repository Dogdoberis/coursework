package lt.jonas.accounting.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ownner")
@Getter
@Setter
@RequiredArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String name;
    @Column
    private BigInteger code;
    @Column(name = "vat_code")
    private String vatCode;
    @Column
    private String city;
    @Column
    private String street;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "post_code")
    private Integer postCode;
    @Column
    private String email;
    @Column(name = "phone_number")
    private BigInteger phoneNumber;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;
//    @OneToMany(mappedBy = "owner")
//    private List<Invoice> invoices;

    @PrePersist
    void prePersist() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {
        this.updated = LocalDateTime.now();
    }
}
