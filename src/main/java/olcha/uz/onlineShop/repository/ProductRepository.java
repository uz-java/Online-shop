package olcha.uz.onlineShop.repository;

import olcha.uz.onlineShop.domains.poduct.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 21:00 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    Optional<Product> findById(Long id);

    Optional<List<Product>> findByActiveTrue();

}
