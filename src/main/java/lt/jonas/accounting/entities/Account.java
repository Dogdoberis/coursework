package lt.jonas.accounting.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lt.jonas.accounting.enumerators.AccountType;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "account"/*vartotojas tiekejai klientai*/)
@Getter
@Setter
@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private BigInteger code;
    @Column(name = "vat_code")
    private String vatCode;
    @Column
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Invoice> invoices;


}
