package lt.jonas.accounting.repositories;

import lt.jonas.accounting.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
