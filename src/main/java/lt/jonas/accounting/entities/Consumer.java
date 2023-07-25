package lt.jonas.accounting.entities;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.ConsumerRole;
import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "consumer")
@Getter
@Setter
@RequiredArgsConstructor
public class Consumer {
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
    private ConsumerRole consumerRole;
//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Invoice> invoices;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @PrePersist
    void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
