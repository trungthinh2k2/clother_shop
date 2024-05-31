package vn.edu.iuh.fit.shopclother.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity(name = "account")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account {

    @Id
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name", columnDefinition = "nvarchar(500)")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "avatar")
    private String avatar;

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<Authorities> authoritiesList;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Orders> ordersList;

//    @Override
//    public String toString() {
//        return "Account{" +
//                "userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                ", fullName='" + fullName + '\'' +
//                ", email='" + email + '\'' +
//                ", avatar='" + avatar + '\'' +
//                '}';
//    }
}
