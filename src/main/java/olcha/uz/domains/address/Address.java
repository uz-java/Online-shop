package olcha.uz.domains.address;

import lombok.*;

import javax.persistence.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 03/08/22 22:17 (Wednesday)
 * SpringMyProject/IntelliJ IDEA
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
@Builder
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String apartment;
    private Integer house_number;
}
