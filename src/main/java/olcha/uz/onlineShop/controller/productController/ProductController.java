package olcha.uz.onlineShop.controller.productController;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.domains.poduct.Product;
import olcha.uz.onlineShop.dto.ProductCreateDto;
import olcha.uz.onlineShop.services.CategoryService;
import olcha.uz.onlineShop.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 03/08/22 19:40 (Wednesday)
 * SpringMyProject/IntelliJ IDEA
 */
@Controller
@RequestMapping("/views")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public String getProducts(@PathVariable Long id,Model model){
        List<Product> productList=productService.getAll(id);
        model.addAttribute("productList",productList);
        model.addAttribute("category",categoryService.findById(id));
        return "views/product";
    }
    @GetMapping(value = "/product")
    public String productPage(Model model){
        model.addAttribute("productCreateDto",new ProductCreateDto());
        return "views/product";
    }

    @PostMapping(value = "/product")
    public String productAdd(@Valid @ModelAttribute("productCreateDto") ProductCreateDto productCreateDto, BindingResult result, @RequestParam("image") MultipartFile file, @RequestParam("categoryId") Long id){
        System.out.println("productCreateDto = " + productCreateDto);
        if (result.hasErrors()) {
            return "views/product";
        }
        productService.create(productCreateDto,file,id);
        return "redirect:/"+id;
    }
}
