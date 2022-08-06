package olcha.uz.onlineShop.services;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.domains.Category;
import olcha.uz.onlineShop.domains.Uploads;
import olcha.uz.onlineShop.domains.poduct.Product;
import olcha.uz.onlineShop.dto.ProductCreateDto;
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
    private final CategoryRepository categoryRepository;


    public Page<Product> findAll(Integer page) {
        int size = 10;
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return productRepository.findAll(pageable);
    }

    public void create(ProductCreateDto productCreateDto, MultipartFile file, Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            throw new NotFoundException("Category not found");
        }


        Uploads upload = fileStorageService.upload(file);
        Product product = Product.builder()
                .name(productCreateDto.getName())
                .image(upload)
                .description(productCreateDto.getDescription())
                .price(productCreateDto.getPrice())
                .status(FavoritesStatus.UNLIKE)
                .category(category.get())
                .build();
        productRepository.save(product);
     }

    public List<Product> getAll(Long id) {
        Optional<List<Product>> productList = productRepository.findAllById(id);
        if (productList.isEmpty()) {
            throw new NotFoundException("Product list not found");
        }
        return productList.get();
    }
}
