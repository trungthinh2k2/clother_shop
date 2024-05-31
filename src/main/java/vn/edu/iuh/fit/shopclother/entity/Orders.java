package vn.edu.iuh.fit.shopclother.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    @Column(name = "address", columnDefinition = "nvarchar(500)")
    private String address;
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;


    @ManyToOne
    @JoinColumn(name = "user_name")
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetailList;
}
