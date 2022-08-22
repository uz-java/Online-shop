package olcha.uz.onlineShop.services;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.domains.Basket_Item;
import olcha.uz.onlineShop.domains.Uploads;
import olcha.uz.onlineShop.domains.poduct.Product;
import olcha.uz.onlineShop.dto.ProductCreateDto;
import olcha.uz.onlineShop.dto.ProductUpdateDto;
import olcha.uz.onlineShop.enams.FavoritesStatus;
import olcha.uz.onlineShop.repository.BasketItemRepository;
import olcha.uz.onlineShop.repository.FileStorageRepository;
import olcha.uz.onlineShop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 20:59 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;
    private final BasketItemRepository basketItemRepository;
    private final FileStorageRepository fileStorageRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void create(ProductCreateDto productCreateDto, MultipartFile file) {

        Uploads upload = fileStorageService.upload(file);
        if (Objects.isNull(upload)) {
            throw new RuntimeException("Upload is null");
        }

        Product product = Product.builder()
                .name(productCreateDto.getName())
                .image(upload)
                .description(productCreateDto.getDescription())
                .price(productCreateDto.getPrice())
                .status(FavoritesStatus.UNLIKE)
                .build();
        productRepository.save(product);
    }


    public void cancelToBasket(Long id, Long userId) {
        basketItemRepository.removeByProductIdAndAuthUserId(id, userId).orElseThrow(() -> {
            throw new RuntimeException("BasketItemFailed to delete BasketItem");
        });
    }

    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Product not found");
        });
    }

    public void update(ProductUpdateDto dto) {
        Uploads uploads= fileStorageRepository.findById(dto.getImageId()).orElseThrow(() -> {
            throw new RuntimeException("Uploads not found");
        });
        Product product = Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .image(uploads)
                .active(dto.isActive())
                .build();
        productRepository.save(product);
    }

    public List<Product> findAllBasketItemsId(List<Basket_Item> basketItems) {
        List<Product> products = new ArrayList<>();
        for (Basket_Item item : basketItems) {
            Product product = productRepository.findById(item.getProduct().getId()).orElseThrow(() -> {
                throw new RuntimeException("Product not found");
            });
            products.add(product);
        }
        return products;
    }
}
