package olcha.uz.onlineShop.domains.poduct;

import lombok.*;
import olcha.uz.onlineShop.domains.Category;
import olcha.uz.onlineShop.domains.Uploads;
import olcha.uz.onlineShop.enams.FavoritesStatus;

import javax.persistence.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 03/08/22 21:28 (Wednesday)
 * SpringMyProject/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private Uploads image;

    private String description;
    private Double price;

    @Enumerated(EnumType.STRING)
    private FavoritesStatus status = FavoritesStatus.UNLIKE;

    @Column(nullable = false, columnDefinition = "bool default true")
    private boolean active;

}
