package vn.edu.iuh.fit.shopclother.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity(name = "Accounts")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account {

    @Id
    @Column(name = "use_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "account")
    private List<Authorities> authoritiesList;

    @OneToMany(mappedBy = "account")
    private List<Orders> ordersList;

}
