package olcha.uz.onlineShop.controller;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.domains.Category;
import olcha.uz.onlineShop.dto.CategoryCreateDto;
import olcha.uz.onlineShop.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 06/08/22 20:18 (Saturday)
 * SpringMyProject/IntelliJ IDEA
 */
@Controller
@RequestMapping("/views")
@RequiredArgsConstructor
public class CategoryController {

   private final CategoryService categoryService;

   /* @GetMapping(value = "/category")
    public String productPage(Model model) {
        model.addAttribute("categoryCreateDto", new CategoryCreateDto());
        return "views/category";
    }

    @PostMapping(value = "/category")
    public String productAdd(@Valid @ModelAttribute("categoryCreateDto") CategoryCreateDto categoryCreateDto, BindingResult result, @RequestParam("image") MultipartFile file) {

        if (result.hasErrors()) {
            return "views/category";
        }
        categoryService.create(categoryCreateDto, file);
        return "redirect:/";
    }*/
}
