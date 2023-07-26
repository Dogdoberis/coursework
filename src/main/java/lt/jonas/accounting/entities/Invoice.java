package lt.jonas.accounting.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


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