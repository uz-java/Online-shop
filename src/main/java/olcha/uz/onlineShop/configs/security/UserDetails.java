package olcha.uz.onlineShop.configs.security;

import lombok.ToString;
import olcha.uz.onlineShop.domains.auth.AuthPermission;
import olcha.uz.onlineShop.domains.auth.AuthRole;
import olcha.uz.onlineShop.domains.auth.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@ToString
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private final AuthUser user;

    public UserDetails(AuthUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (AuthRole role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            for (AuthPermission permission : role.getPermissions()) {
                authorities.add(new SimpleGrantedAuthority(permission.getAuthority()));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public  String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }

    public Long getId(){
        return user.getId();
    }
}
