package vn.edu.iuh.fit.shopclother.services;

import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.iuh.fit.shopclother.entity.Authorities;

import java.util.Map;

public interface AuthoritiesService {

    public Authorities createAuthorities(Authorities authorities);

    public Map<String, Object> getAuthorities();

    public void removeAuthorities(@PathVariable("id") int id);
}
