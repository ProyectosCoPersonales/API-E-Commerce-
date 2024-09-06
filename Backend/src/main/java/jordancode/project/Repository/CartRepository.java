package jordancode.project.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import jordancode.project.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}

