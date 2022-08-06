package olcha.uz.onlineShop.domains.auth;

import lombok.*;
import olcha.uz.onlineShop.domains.address.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "authUser")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;

     @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "bool default true")
    private boolean active;

    @ManyToMany(targetEntity = Address.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = @JoinColumn(name = "authUser_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id")
    )
    private List<Address> address = new ArrayList<>();



    @ManyToMany(targetEntity = AuthRole.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "authUser_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authRole_id", referencedColumnName = "id")
    )
    private List<AuthRole> roles = new ArrayList<>();
}
