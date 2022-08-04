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
    @NotBlank(message = "{NotBlank.Username}")
    private String username;
    @NotBlank(message = "{NotBlank.Password}")
    private String password;
}
