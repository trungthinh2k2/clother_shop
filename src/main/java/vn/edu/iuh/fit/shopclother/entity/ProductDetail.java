package vn.edu.iuh.fit.shopclother.entity;


import javax.persistence.*;
import lombok.*;

@Entity(name = "product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_properties_id")
    private ProductProperties productProperties;
}
