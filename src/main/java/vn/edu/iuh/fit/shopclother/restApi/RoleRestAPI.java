package vn.edu.iuh.fit.shopclother.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.shopclother.entity.Role;
import vn.edu.iuh.fit.shopclother.services.RoleService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/role")
public class RoleRestAPI {

    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    public List<Role> getAllRole() {
        return roleService.findAll();
    }
}
