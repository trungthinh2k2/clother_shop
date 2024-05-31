package vn.edu.iuh.fit.shopclother.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.shopclother.entity.Authorities;
import vn.edu.iuh.fit.shopclother.services.AuthoritiesService;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthoritiesRestAPI {

    @Autowired
    AuthoritiesService authoritiesService;

    @PostMapping("/create")
    public Authorities createAuthorities(@RequestBody Authorities authorities) {
        return authoritiesService.createAuthorities(authorities);
    }

    @GetMapping("/list")
    public Map<String, Object> getAuthorities() {
        return authoritiesService.getAuthorities();
    }

}
