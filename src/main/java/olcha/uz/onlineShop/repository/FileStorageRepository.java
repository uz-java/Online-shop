package olcha.uz.onlineShop.repository;

import olcha.uz.onlineShop.domains.Uploads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 06/08/22 14:34 (Saturday)
 * SpringMyProject/IntelliJ IDEA
 */
public interface FileStorageRepository extends JpaRepository<Uploads,Long> {
    Optional<Uploads> findByGeneratedName(String generatedName);
}
