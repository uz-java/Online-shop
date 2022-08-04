package olcha.uz.controller.productController;

import lombok.RequiredArgsConstructor;
import olcha.uz.domains.poduct.Product;
import olcha.uz.dto.ProductCreateDto;
import olcha.uz.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.IntStream;

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
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String homePage(@RequestParam(name = "page")Optional<Integer> pageOptional,Model model){
        Integer pageNumber = pageOptional.orElse(0);
        Page<Product> page=productService.findAll(pageNumber);
        model.addAttribute("page",page);
        model.addAttribute("pageNumbers", IntStream.range(0,page.getTotalPages()).toArray());
        return "index";
    }

    @GetMapping(value = "/product")
    public String productPage(Model model){
        model.addAttribute("productCreateDto",new ProductCreateDto());
        return "views/product";
    }
    @PostMapping(value = "/product")
    public String product(@Valid @ModelAttribute("productCreateDto") ProductCreateDto productCreateDto, BindingResult result){
        if (result.hasErrors()) {
            return "views/product";
        }
        productService.create(productCreateDto);
        return "redirect:/";
    }
}
