package olcha.uz.repository;

import olcha.uz.domains.Category;
import olcha.uz.domains.poduct.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 21:00 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    Optional<Category> findByCategoryCode(String code);
}
