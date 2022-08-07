package olcha.uz.onlineShop.services;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.domains.Category;
import olcha.uz.onlineShop.domains.Uploads;
import olcha.uz.onlineShop.dto.CategoryCreateDto;
import olcha.uz.onlineShop.exceptions.NotFoundException;
import olcha.uz.onlineShop.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 18:05 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class  CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileStorageService fileStorageService;

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Category not found");
        });
    }

    public void create(CategoryCreateDto categoryCreateDto, MultipartFile file) {

        Uploads upload = fileStorageService.upload(file);
        if(Objects.isNull(upload)){
            throw new RuntimeException("Upload is null");
        }

        Category category=Category.builder()
                .name(categoryCreateDto.getName())
                .image(upload)
                .build();

        categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
