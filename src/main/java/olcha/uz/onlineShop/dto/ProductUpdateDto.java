package olcha.uz.onlineShop.dto;

import lombok.*;
import olcha.uz.onlineShop.domains.Uploads;

/**
 * @author "Tojaliyev Asliddin"
 * @since 07/08/22 23:15 (Sunday)
 * SpringMyProject/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductUpdateDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
}
