package olcha.uz.controller.authController;

import lombok.RequiredArgsConstructor;
import olcha.uz.dto.auth.UserCreateDto;
import olcha.uz.dto.auth.UserLoginDto;
import olcha.uz.services.authService.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("userLoginDto", new UserLoginDto());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userLoginDto") UserLoginDto userLoginDto, HttpServletResponse response, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "auth/login";
        }
        authService.login(userLoginDto);
        return "redirect:/";
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
