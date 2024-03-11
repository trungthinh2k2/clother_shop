package vn.edu.iuh.fit.shopclother.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorities_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "use_name")
    private Account account;

}
