package olcha.uz.onlineShop.repository.authRepository;

import olcha.uz.onlineShop.domains.auth.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<AuthUser, Long> {
     Optional<AuthUser> findByUsername(String username);
     Optional<AuthUser> findById(Long id);
}
