package vn.edu.iuh.fit.shopclother.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.shopclother.entity.Role;
import vn.edu.iuh.fit.shopclother.repositoties.RoleRepository;
import vn.edu.iuh.fit.shopclother.services.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
