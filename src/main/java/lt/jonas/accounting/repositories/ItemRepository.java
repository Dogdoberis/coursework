package lt.jonas.accounting.repositories;

import lt.jonas.accounting.dto.ItemDTO;
import lt.jonas.accounting.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findItemByCodeIgnoreCaseContaining(String code);
    List<Item> findItemByTitleIgnoreCaseContaining(String title);
    List<Item> findItemByDescriptionIgnoreCaseContaining(String description);
}
