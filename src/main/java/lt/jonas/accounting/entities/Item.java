package lt.jonas.accounting.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.ItemType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private String code;
    @Column
    private String title;
    @Column
    private Double price;
    @Column
    private String description;
    @ManyToOne
    private Invoice invoice;
    @Column(name = "created")
    private LocalDateTime created;
    @Column(name = "updated")
    private LocalDateTime updated;
    @Column
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

}
