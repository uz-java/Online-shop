package olcha.uz.controller.authController;

import lombok.RequiredArgsConstructor;
import olcha.uz.dto.auth.UserCreateDto;
import olcha.uz.dto.auth.UserLoginDto;
import olcha.uz.services.authService.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @PostMapping("/login")
    public void login(@ModelAttribute UserLoginDto userLoginDto, HttpServletResponse response) throws IOException {
        Long userId = authService.login(userLoginDto);
        Cookie cookie = new Cookie("userId", String.valueOf(userId));
        response.addCookie(cookie);
        response.sendRedirect("/");
    }

    @GetMapping(value = "/register")
    public String registerPage(@ModelAttribute("userCreateDto") UserCreateDto userCreateDto) {
        return "auth/register";
    }

    @PostMapping(value = "/register")
    public void register(@ModelAttribute("userCreateDto") UserCreateDto userCreateDto,HttpServletResponse response) throws IOException {
        System.out.println(userCreateDto);
        Long userId=authService.create(userCreateDto);
        System.out.println(userId);
        Cookie cookie=new Cookie("userId",String.valueOf(userId));
        response.addCookie(cookie);
        response.sendRedirect("/");
    }


    @GetMapping("/logout")
    public String logoutPage() {
        return "auth/logout";
    }
}
