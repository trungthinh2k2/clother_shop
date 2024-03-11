package vn.edu.iuh.fit.shopclother.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.shopclother.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}