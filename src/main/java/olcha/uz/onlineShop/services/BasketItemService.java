package olcha.uz.onlineShop.services;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.domains.Basket_Item;
import olcha.uz.onlineShop.domains.auth.AuthUser;
import olcha.uz.onlineShop.domains.poduct.Product;
import olcha.uz.onlineShop.dto.BasketItemDto;
import olcha.uz.onlineShop.repository.BasketItemRepository;
import olcha.uz.onlineShop.repository.ProductRepository;
import olcha.uz.onlineShop.repository.authRepository.AuthRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author "Tojaliyev Asliddin"
 * @since 08/08/22 11:02 (Monday)
 * SpringMyProject/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class BasketItemService {
    private final BasketItemRepository basketItemRepository;
    private final ProductRepository productRepository;
    private final AuthRepository authRepository;
    public List<Basket_Item> findAllUserId(Long id) {
        return basketItemRepository.findAllByAuthUserId(id).orElse(new ArrayList<>());
    }

    @Transactional
    public void cancelToBasket(Long id, Long userId) {
        basketItemRepository.removeByProductIdAndAuthUserId(id, userId).orElseThrow(() -> {
            throw new RuntimeException("BasketItemFailed to delete BasketItem");
        });
    }

    public void saveToBasket(Long id, Long user_id) {
        Product product= productRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Product not found");
        });
        AuthUser user = authRepository.findById(user_id).orElseThrow(() -> {
            throw new RuntimeException("User not found");
        });

        Basket_Item basket = basketItemRepository.findByProductIdAndAuthUserId(id, user_id).orElse(null);
        if(Objects.isNull(basket)){
            Basket_Item basketItem=Basket_Item.builder()
                    .quantity(0)
                    .authUser(user)
                    .product(product)
                    .build();
            basketItemRepository.save(basketItem);
        }else {
            basket.setQuantity(basket.getQuantity()+1);
            basketItemRepository.save(basket);
        }
    }
}
