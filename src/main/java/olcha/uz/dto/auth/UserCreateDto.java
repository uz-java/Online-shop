package olcha.uz.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import olcha.uz.domains.auth.AuthRole;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 03/08/22 15:24 (Wednesday)
 * SpringMyProject/IntelliJ IDEA
 */
@Getter
@Setter
@ToString
public class UserCreateDto {

    @NotBlank(message = "FullName can not be null")
    private String fullName;
    @NotBlank(message = "Username can not be null")
    private String username;
    @NotBlank(message = "Password can not be null")
    private String password;
    @NotBlank(message = "ConfirmPassword can not be null")
    private String confirmPassword;

}
