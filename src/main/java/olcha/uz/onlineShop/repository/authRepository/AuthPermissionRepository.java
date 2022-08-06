package olcha.uz.onlineShop.repository.authRepository;

import olcha.uz.onlineShop.domains.auth.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  AuthPermissionRepository extends JpaRepository<AuthRole, Long> {
}
