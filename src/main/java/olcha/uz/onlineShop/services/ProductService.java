package olcha.uz.onlineShop.services;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.domains.Category;
import olcha.uz.onlineShop.domains.Uploads;
import olcha.uz.onlineShop.domains.poduct.Product;
import olcha.uz.onlineShop.dto.ProductCreateDto;
import olcha.uz.onlineShop.dto.ProductUpdateDto;
import olcha.uz.onlineShop.enams.FavoritesStatus;
import olcha.uz.onlineShop.exceptions.NotFoundException;
import olcha.uz.onlineShop.repository.CategoryRepository;
import olcha.uz.onlineShop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
                .active(false)
                .build();
        productRepository.save(product);
    }

    public List<Product> findAllByTrue() {
        return productRepository.findByActiveTrue().orElseThrow(() -> {
            throw new RuntimeException("Product list not found");
        });
    }

    public void saveToBasket(Long id) {
        Product product_not_found = productRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Product not found");
        });
        product_not_found.setActive(true);
        productRepository.save(product_not_found);
    }
    public void cancelToBasket(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Product not found");
        });
        product.setActive(false);
        productRepository.save(product);
    }

    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Product not found");
        });
    }

    public void update(ProductUpdateDto dto) {
        Product product=Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
        productRepository.save(product);
    }
}
