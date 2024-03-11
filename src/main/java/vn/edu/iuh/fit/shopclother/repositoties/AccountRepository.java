package vn.edu.iuh.fit.shopclother.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.shopclother.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}