package olcha.uz.services;

import lombok.RequiredArgsConstructor;
import olcha.uz.domains.Category;
import olcha.uz.domains.poduct.Product;
import olcha.uz.dto.ProductCreateDto;
import olcha.uz.enams.FavoritesStatus;
import olcha.uz.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public void create(ProductCreateDto productCreateDto) {

       /* if (productRepository.findByName(productCreateDto.getName()).isPresent()) {
            throw new RuntimeException("The product has already been added");
        }*/

        Optional<Category> byCategoryCode = productRepository.findByCategoryCode("PHONE");
        if (byCategoryCode.isEmpty()) {
            throw new RuntimeException("Category not found");
        }

        Product product = Product.builder()
                .name(productCreateDto.getName())
                .image(productCreateDto.getImage())
                .description(productCreateDto.getDescription())
                .price(productCreateDto.getPrice())
                .status(FavoritesStatus.UNLIKE)
                .category(byCategoryCode.get())
                .build();
        productRepository.save(product);

    }

    public Page<Product> findAll(Integer page) {
        int size=10;
        Pageable pageable= PageRequest.of(page,size, Sort.by("id").descending());
        return productRepository.findAll(pageable);
    }
}
