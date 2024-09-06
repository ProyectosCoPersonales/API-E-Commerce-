package jordancode.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jordancode.project.Model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

