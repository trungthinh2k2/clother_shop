package vn.edu.iuh.fit.shopclother.entity;

import jakarta.persistence.*;
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
    @Column(name = "address")
    private String address;
    @Column(name = "created_date")
    private Date createdDate;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetailList;
}
