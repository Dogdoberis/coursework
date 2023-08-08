package lt.jonas.accounting.entities;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.ConsumerType;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "consumer")
@Getter
@Setter
@RequiredArgsConstructor
public class Consumer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String name;
    @Column
    private Long code;
    @Column(name = "vat_code")
    private String vatCode;
    @Column
    private String city;
    @Column
    private String street;
    @Column(name= "house_number")
    private String houseNumber;
    @Column(name = "post_code")
    private Integer postCode;
    @Column
    private String email;
    @Column(name = "phone_number")
    private BigInteger phoneNumber;
    @Column
    @Enumerated(EnumType.STRING)
    private ConsumerType consumerType;

    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;
    @OneToMany(mappedBy = "consumer")
    private List<Invoice> invoices;
    @PrePersist
    void prePersist() {
        this.created = LocalDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        this.updated = LocalDateTime.now();
    }

}
