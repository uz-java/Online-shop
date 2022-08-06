package olcha.uz.onlineShop.repository;

import olcha.uz.onlineShop.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 18:07 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
public interface  CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findById(Long id);
}
