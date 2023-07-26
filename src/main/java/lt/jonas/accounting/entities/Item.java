package lt.jonas.accounting.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.ItemType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Getter
@Setter
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private Double price;
    @Column
    private String description;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;
    @Column
    @Enumerated(EnumType.STRING)
    private ItemType itemType;
    @PrePersist
    void prePersist() {
        this.created = LocalDateTime.now();
    }
    @PreUpdate
    void preUpdate() {
        this.updated = LocalDateTime.now();
    }
}
