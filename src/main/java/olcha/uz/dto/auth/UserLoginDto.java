package olcha.uz.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author "Tojaliyev Asliddin"
 * @since 03/08/22 15:24 (Wednesday)
 * SpringMyProject/IntelliJ IDEA
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginDto {
    private String username;
    private String password;
}
