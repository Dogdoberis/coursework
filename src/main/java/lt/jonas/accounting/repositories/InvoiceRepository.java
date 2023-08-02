package lt.jonas.accounting.repositories;
import lt.jonas.accounting.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByInvoiceDateBetween(LocalDate fromDate, LocalDate toDate);
    List<Invoice> findInvoiceByItemsId(Long id);


}
