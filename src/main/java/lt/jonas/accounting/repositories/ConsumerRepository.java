package lt.jonas.accounting.repositories;

import lt.jonas.accounting.entities.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

    List<Consumer> findByNameIgnoreCaseContaining(String name);

    @Query("SELECT c FROM Consumer c WHERE CAST(c.code AS string) LIKE %:code%")
    List<Consumer> findByCode(String code);


    List<Consumer> findByVatCodeContaining(String vatCode);


}