package lt.jonas.accounting.entities;

import lombok.*;
import lt.jonas.accounting.enumerators.ItemType;
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
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToMany
    @JoinTable(
            name = "invoice_item",
            joinColumns = @JoinColumn(name = "invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;
    @Column
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

}