package vn.edu.iuh.fit.shopclother.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "order_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
}
