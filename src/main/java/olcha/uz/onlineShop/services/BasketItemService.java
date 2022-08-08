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

import java.util.ArrayList;
import java.util.List;

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
        return basketItemRepository.findAllByAuthUserIdAndActive(id,Boolean.TRUE).orElse(new ArrayList<>());
    }

    public void saveToBasket(Long id, Long user_id) {
        Product product= productRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Product not found");
        });
        AuthUser user = authRepository.findById(user_id).orElseThrow(() -> {
            throw new RuntimeException("User not found");
        });

        Basket_Item basketItem=Basket_Item.builder()
                .quantity(0)
                .authUser(user)
                .product(product)
                .active(true)
                .build();

        basketItemRepository.save(basketItem);

    }
}
