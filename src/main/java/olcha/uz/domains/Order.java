package olcha.uz.domains;

import lombok.*;
import olcha.uz.domains.auth.AuthUser;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 04/08/22 10:10 (Thursday)
 * SpringMyProject/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "orders")
@Builder
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime created_at;

    @OneToOne(targetEntity = AuthUser.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "authUser_id")
    private AuthUser authUser;
}
