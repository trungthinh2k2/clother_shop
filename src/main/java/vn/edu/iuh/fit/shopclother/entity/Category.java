package vn.edu.iuh.fit.shopclother.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity(name = "category")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

}
