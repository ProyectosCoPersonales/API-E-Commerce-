package jordancode.project.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jordancode.project.User.User;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username); 
}
