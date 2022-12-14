package olcha.uz.onlineShop.handler;

import olcha.uz.onlineShop.exceptions.MethodNotAllowedException;
import olcha.uz.onlineShop.exceptions.NotFoundException;
import olcha.uz.onlineShop.exceptions.UnAuthorizedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author "Tojaliyev Asliddin"
 * @since 03/08/22 15:26 (Wednesday)
 * SpringMyProject/IntelliJ IDEA
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NoHandlerFoundException.class})
    public String handler_404(NoHandlerFoundException e) {
        return "error/404";
    }

    @ExceptionHandler({NotFoundException.class})
    public String NotFoundHandler(NotFoundException e) {
        return "error/404";
    }
    @ExceptionHandler({MethodNotAllowedException.class})
    public String NotAllowedHandler(MethodNotAllowedException e) {
        return "error/400";
    }

    @ExceptionHandler({UnAuthorizedException.class})
    public String handle401(UnAuthorizedException e,
                            Model model,
                            WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
        model.addAttribute("message", e.getMessage());
        model.addAttribute("path", path);
        return "errors/401";
    }
}
