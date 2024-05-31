package vn.edu.iuh.fit.shopclother.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.shopclother.entity.Authorities;
import vn.edu.iuh.fit.shopclother.repositoties.AccountRepository;
import vn.edu.iuh.fit.shopclother.repositoties.AuthoritiesRepository;
import vn.edu.iuh.fit.shopclother.repositoties.RoleRepository;
import vn.edu.iuh.fit.shopclother.services.AuthoritiesService;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Authorities createAuthorities(Authorities authorities) {
        return authoritiesRepository.save(authorities);
    }

    @Override
    public Map<String, Object> getAuthorities() {

        Map<String, Object> data = new HashMap<>();
        data.put("authorities", authoritiesRepository.findAll());
        data.put("roles", roleRepository.findAll());
        data.put("accounts", accountRepository.findAll());

        return data;
    }

    @Override
    public void removeAuthorities(int id) {
        authoritiesRepository.deleteById(id);
    }
}
