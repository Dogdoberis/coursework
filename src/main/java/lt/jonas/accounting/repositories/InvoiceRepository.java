package lt.jonas.accounting.repositories;

import lt.jonas.accounting.entities.Consumer;
import lt.jonas.accounting.entities.Invoice;
import lt.jonas.accounting.entities.Item;
import lt.jonas.accounting.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByInvoiceDateBetween(LocalDate fromDate, LocalDate toDate);
//    @Query("SELECT i FROM Invoice i JOIN i.items it WHERE it = :item")
//    List<Invoice> findByItem(@Param("item") Item item);
//    @Query("SELECT i FROM Invoice i JOIN i.consumer it WHERE it = :consumer")
//    List<Invoice> findByConsumer(@Param("item")Consumer consumer);
//    @Query("SELECT i FROM Invoice i JOIN i.user it WHERE it = :user")
//    List<Invoice> findByUser(@Param("item")User user);

}
