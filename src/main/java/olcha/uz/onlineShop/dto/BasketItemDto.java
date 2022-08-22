package olcha.uz.onlineShop.dto;

import lombok.*;

import javax.validation.constraints.Positive;

/**
 * @author "Tojaliyev Asliddin"
 * @since 08/08/22 10:22 (Monday)
 * SpringMyProject/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BasketItemDto {

    @Positive(message = "{Positive.Quantity}")
    private Integer quantity;
}
