package olcha.uz.services;

import lombok.RequiredArgsConstructor;
import olcha.uz.repository.CategoryRepository;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 18:05 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
}
