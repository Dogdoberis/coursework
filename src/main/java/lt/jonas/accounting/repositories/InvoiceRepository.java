package lt.jonas.accounting.repositories;

import lt.jonas.accounting.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
