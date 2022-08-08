package olcha.uz.onlineShop.controller;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.configs.security.UserDetails;
import olcha.uz.onlineShop.domains.Category;
import olcha.uz.onlineShop.domains.poduct.Product;
import olcha.uz.onlineShop.services.CategoryService;
import olcha.uz.onlineShop.services.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 05/08/22 14:35 (Friday)
 * SpringMyProject/IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProductService productService;

    @RequestMapping(value = "")
    @PreAuthorize("permitAll()")
     public String homePage(Model model) {
        List<Product> productList=productService.findAll();
        model.addAttribute("productList",productList);
        return "index";
    }

    @ResponseBody
    @PreAuthorize("isAuthenticated() || hasAuthority('create')")
    @RequestMapping("/user")
    public String user(@AuthenticationPrincipal UserDetails userDetails) {
        return "" + userDetails;
    }


    @ResponseBody
    @RequestMapping("/create")
    public String hasAuthorityCreate() {
        return "hasAuthorityCreate";
    }
}
