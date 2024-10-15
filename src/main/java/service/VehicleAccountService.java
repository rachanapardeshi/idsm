package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealersocket.idsm.model.VehicleDetailsModel;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


@Service
public class VehicleAccountService {

    @Autowired
    private EntityManager entityManager;

    
    @Autowired
    private AccountRepository accountRepository;

    // Method to validate and save account
    public void saveAccount(VehicleDetailsModel account) {
        if (isDuplicateAcctID(account.getAcctID())) {
            throw new IllegalArgumentException("Duplicate AcctID: " + account.getAcctID());
        }
        accountRepository.save(account);
    }

    // Method using CriteriaBuilder to check for duplicates
    private boolean isDuplicateAcctID(String acctID) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<VehicleDetailsModel> accountRoot = query.from(VehicleDetailsModel.class);

        // Build the query: SELECT COUNT(a) FROM Account a WHERE a.acctID = :acctID
        query.select(cb.count(accountRoot))
             .where(cb.equal(accountRoot.get("acctID"), acctID));

        // Execute the query and get the result
        Long count = entityManager.createQuery(query).getSingleResult();
        return count > 0;
    }
}
