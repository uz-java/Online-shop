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
public class Basket_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @ManyToOne
    private AuthUser authUser;
    @ManyToOne
    private Product product;
}
