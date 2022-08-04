package olcha.uz.domains;

import lombok.*;
import olcha.uz.domains.auth.AuthUser;
import olcha.uz.domains.poduct.Product;
import olcha.uz.enams.FavoritesStatus;

import javax.persistence.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 10:34 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "favorites")
@ToString
@Builder
@Entity
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = AuthUser.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "authUser_id")
    private AuthUser authUser;

    @OneToOne(targetEntity = Product.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
}
