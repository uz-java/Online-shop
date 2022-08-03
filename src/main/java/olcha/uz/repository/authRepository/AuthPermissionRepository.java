package olcha.uz.repository.authRepository;

import olcha.uz.domains.auth.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthPermissionRepository extends JpaRepository<AuthRole, Long> {
}
