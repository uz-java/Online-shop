package olcha.uz.onlineShop.controller.productController;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.domains.poduct.Product;
import olcha.uz.onlineShop.dto.ProductCreateDto;
import olcha.uz.onlineShop.dto.ProductUpdateDto;
import olcha.uz.onlineShop.services.CategoryService;
import olcha.uz.onlineShop.services.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
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


    @GetMapping("/basket")
    public String ProductPage(Model model) {
        List<Product> products=productService.findAllByTrue();
        model.addAttribute("products",products);
        return "views/basket";
    }

    @GetMapping("/{id}")
    public String saveCartPage(@PathVariable Long id) {
        productService.saveToBasket(id);
        return "redirect:/";
    }

    @GetMapping("/cancel/{id}")
    public String cancelCartPage(@PathVariable Long id) {
        productService.cancelToBasket(id);
        return "redirect:/";
    }
    @GetMapping(value = "/product")
    public String productPage(Model model) {
        model.addAttribute("productCreateDto", new ProductCreateDto());
        return "views/product";
    }

    @PostMapping(value = "/product")
    public String productAdd(@Valid @ModelAttribute("productCreateDto") ProductCreateDto productCreateDto, BindingResult result, @RequestParam("image") MultipartFile file) {

        if (result.hasErrors()) {
            return "views/product";
        }
        productService.create(productCreateDto, file);
        return "redirect:/";
    }

    @GetMapping("/product/update/{id}")
    public String updatePage(@PathVariable Long id,Model model){
        System.out.println("id = " + id);
        model.addAttribute("product",productService.get(id));
        return "views/productUpdate";
    }

    @GetMapping("/productUpdate")
    public String getUpdatePage(){
        return "views/productUpdate";
    }

    @PostMapping("/product/update")
    public String update(@ModelAttribute ProductUpdateDto dto){
        productService.update(dto);
        return "redirect:/";
    }


}
