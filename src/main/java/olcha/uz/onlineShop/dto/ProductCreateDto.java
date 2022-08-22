package olcha.uz.onlineShop.dto;

import lombok.Getter;
import lombok.Setter;
import olcha.uz.onlineShop.domains.Uploads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 17:54 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */
@Getter
@Setter

public class ProductCreateDto {
    @NotBlank(message = "{NotBlank.ProductName}")
    private String name;
    @NotBlank(message = "{NotBlank.Description}")
     private String description;
    @Positive(message = "{Positive.Price}")
    private Double price;
}
