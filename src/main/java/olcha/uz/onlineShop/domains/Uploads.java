package olcha.uz.onlineShop.domains;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 09:40 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "uploads")
@Entity
public class Uploads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private String originalName;
    private String generatedName;
    private long size;
     private String contentType;


 /*   @OneToOne(targetEntity = Product.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;*/
}