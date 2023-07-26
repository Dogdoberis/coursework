package lt.jonas.accounting.repositories;

import lt.jonas.accounting.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
