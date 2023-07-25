package lt.jonas.accounting.repositories;

import lt.jonas.accounting.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
