package vn.edu.iuh.fit.shopclother.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private float price;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "image")
    private String image;
    @Column(name = "available")
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductDetail> productDetailList;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetailList;


}
