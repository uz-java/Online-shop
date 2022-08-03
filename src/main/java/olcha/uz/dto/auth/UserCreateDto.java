package olcha.uz.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import olcha.uz.domains.auth.AuthRole;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 03/08/22 15:24 (Wednesday)
 * SpringMyProject/IntelliJ IDEA
 */
@Getter
@Setter
@ToString
@Builder
public class UserCreateDto {
    private String fullName;
    private String username;
    private String password;
    private String configPassword;
    private List<AuthRole> authRoles;
}
