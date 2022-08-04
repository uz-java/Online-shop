package olcha.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 17:54 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductCreateDto {
    private String name;
    private String image;
    private String description;
    private Double price;
}
