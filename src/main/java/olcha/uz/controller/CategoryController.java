package olcha.uz.controller;

import lombok.RequiredArgsConstructor;
import olcha.uz.services.CategoryService;
import org.springframework.stereotype.Controller;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 18:04 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


}
