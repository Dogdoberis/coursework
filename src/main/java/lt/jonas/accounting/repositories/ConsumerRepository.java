package lt.jonas.accounting.repositories;

import lt.jonas.accounting.entities.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    Consumer findByTitle(String title);
}
