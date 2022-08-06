package olcha.uz.onlineShop.init;

import olcha.uz.onlineShop.domains.auth.AuthRole;
import olcha.uz.onlineShop.domains.auth.AuthUser;
import olcha.uz.onlineShop.repository.authRepository.AuthPermissionRepository;
import olcha.uz.onlineShop.repository.authRepository.AuthRepository;
import olcha.uz.onlineShop.repository.authRepository.AuthRoleRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 05/08/22 15:11 (Friday)
 * SpringMyProject/IntelliJ IDEA
 */

//@Component
public class DBInitializer implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {

        AuthRoleRepository authRoleRepository = context.getBean(AuthRoleRepository.class);
        AuthPermissionRepository authPermissionRepository = context.getBean(AuthPermissionRepository.class);
        AuthRepository repository = context.getBean(AuthRepository.class);
        authPermissionRepository.deleteAll();
        authRoleRepository.deleteAll();
        repository.deleteAll();
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);

        AuthUser adminUser = new AuthUser();
        adminUser.setUsername("admin");
        adminUser.setFullName("Tojaliyev Asliddin");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        adminUser.setActive(true);


        AuthRole admin = new AuthRole();
        admin.setCode("ADMIN");
        admin.setName("Admin");


        adminUser.setRoles(Collections.singletonList(admin));
        repository.saveAll(List.of(adminUser));
    }
}
