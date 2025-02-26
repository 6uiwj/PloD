package ming.dCommunity.user.repository;

import ming.dCommunity.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
