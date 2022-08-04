package olcha.uz.dto.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @author "Tojaliyev Asliddin"
 * @since 03/08/22 15:24 (Wednesday)
 * SpringMyProject/IntelliJ IDEA
 */
@Getter
@Setter
@ToString
public class UserLoginDto {
    @NotBlank(message = "Username can not be null")
    private String username;
    @NotBlank(message = "Password can not be null")
    private String password;
}
