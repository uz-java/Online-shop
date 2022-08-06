package olcha.uz.onlineShop.domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 08:36 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "vendor")
@Entity

public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String notion_food;
    private LocalDateTime delivery_time_from;
    private LocalDateTime delivery_time_to;
     private Double delivery_price;
}
