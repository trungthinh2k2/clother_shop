package vn.edu.iuh.fit.shopclother.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity(name = "product_properties")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_properties_id")
    private int id;

    @Column(name = "type", columnDefinition = "nvarchar(500)")
    private String type;
    @Column(name = "image_small")
    private String imageSmall;
    @Column(name = "gender")
    private String gender;
    @Column(name = "color")
    private String color;
    @Column(name = "size")
    private String size;

    @OneToMany(mappedBy = "productProperties")
    private List<ProductDetail> productDetailList;


}
