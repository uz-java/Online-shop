package olcha.uz.onlineShop.repository;

import olcha.uz.onlineShop.domains.Basket_Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 08/08/22 11:05 (Monday)
 * SpringMyProject/IntelliJ IDEA
 */
public interface BasketItemRepository extends JpaRepository<Basket_Item, Long> {

    Optional<List<Basket_Item>> findAllByAuthUserId(Long id);
    Optional<Basket_Item> findByProductId(Long id);

    Optional<Basket_Item> findByProductIdAndAuthUserId(Long product_id,Long user_id);

    Optional<Basket_Item> removeByProductIdAndAuthUserId(Long productId,Long userId);
}
