package vn.edu.iuh.fit.shopclother.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role {

    @Id
    @Column(name = "role_id")
    private String id;
    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<Authorities> authoritiesList;
}
