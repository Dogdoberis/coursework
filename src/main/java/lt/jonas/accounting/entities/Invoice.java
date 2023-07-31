package lt.jonas.accounting.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "invoice")
@Getter
@Setter
@RequiredArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String invoiceNr;
    @Column
    private LocalDate invoiceDate;
    @ManyToOne
    private Owner ownerId;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Consumer customer;
    @OneToMany(mappedBy = "invoice")
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @PrePersist
    void prePersist() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate() {
        this.updated = LocalDateTime.now();
    }
}