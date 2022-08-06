package olcha.uz.onlineShop.domains;

import lombok.*;
import olcha.uz.onlineShop.domains.auth.AuthUser;
import olcha.uz.onlineShop.domains.poduct.Product;

import javax.persistence.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 11:17 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "basket")
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    @OneToOne(targetEntity = AuthUser.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "authUser_id")
    private AuthUser authUser;

    @OneToOne(targetEntity = Product.class,fetch = FetchType.EAGER)
     @JoinColumn(name = "product_id")
    private Product product;
}
