package olcha.uz.onlineShop.controller;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.configs.security.UserDetails;
import olcha.uz.onlineShop.services.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String homePage() {
        return "index";
    }



/*    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }*/

  /*  @ResponseBody
    @PreAuthorize("hasRole('MANAGER')")
    @RequestMapping("/mana")
    public String manager() {
        return "MANAGER PAGE";
    }

    @ResponseBody
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @RequestMapping("/admin-manager")
    public String adminManager() {
        return "ADMIN AND MANAGER PAGE";
    }*/

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
