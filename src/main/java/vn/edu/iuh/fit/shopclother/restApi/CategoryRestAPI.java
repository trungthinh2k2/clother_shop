package vn.edu.iuh.fit.shopclother.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.shopclother.entity.Category;
import vn.edu.iuh.fit.shopclother.services.CategoryService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/category")
public class CategoryRestAPI {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public List<Category> getAllCategory(){
        return categoryService.findAll();
    }
}
