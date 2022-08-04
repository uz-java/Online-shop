package olcha.uz.domains.poduct;

import lombok.*;
import olcha.uz.domains.Category;
import olcha.uz.domains.Favorites;
import olcha.uz.domains.Uploads;
import olcha.uz.enams.FavoritesStatus;

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
   private String image;
   private String description;
   private Double price;

   @Enumerated(EnumType.STRING)
   private FavoritesStatus status=FavoritesStatus.UNLIKE;

   @OneToOne(targetEntity = Category.class,fetch = FetchType.EAGER)
   @JoinColumn(name = "category_id")
   private Category category;
}
