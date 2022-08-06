package olcha.uz.onlineShop.controller.authController;

import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.dto.auth.UserCreateDto;
import olcha.uz.onlineShop.services.authService.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) throws IOException {
        ModelAndView modelAndView = new ModelAndView("auth/login");
        if (error != null) {
             modelAndView.addObject("error", error);
        }
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public String registerPage(Model model) {
        model.addAttribute("userCreateDto", new UserCreateDto());
        return "auth/register";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute("userCreateDto") @Valid UserCreateDto userCreateDto, BindingResult result) throws IOException {
        if (result.hasErrors() || !userCreateDto.getPassword().equals(userCreateDto.getConfirmPassword())) {
            return "auth/register";
        }
        authService.create(userCreateDto);
        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logoutPage() {
        return "auth/logout";
    }
}
