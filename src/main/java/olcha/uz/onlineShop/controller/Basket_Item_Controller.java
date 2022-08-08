package olcha.uz.onlineShop.controller;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.configs.security.UserDetails;
import olcha.uz.onlineShop.domains.Basket_Item;
import olcha.uz.onlineShop.domains.poduct.Product;
import olcha.uz.onlineShop.dto.BasketItemDto;
import olcha.uz.onlineShop.services.BasketItemService;
import olcha.uz.onlineShop.services.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 08/08/22 10:14 (Monday)
 * SpringMyProject/IntelliJ IDEA
 */

@Controller
@RequestMapping("/views")
@RequiredArgsConstructor
public class Basket_Item_Controller {
    private final BasketItemService basketItemService;

    @GetMapping("/basketItemAdd")
    public String getCartPage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<Basket_Item> basketItems=basketItemService.findAllUserId(userDetails.getId());
        model.addAttribute("basketItems",basketItems);
        model.addAttribute("basketItemDto",new BasketItemDto());
        return "views/basketItemAdd";
    }

    @GetMapping("/basket{id}")
    public String saveCartPage(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
        basketItemService.saveToBasket(id,userDetails.getId());
        return "redirect:/";
    }
}
