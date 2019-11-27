package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.pos.entity.Customer;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;


@Repository
public class CustomerDAOImpl extends CrudDAOImpl<Customer, String> implements CustomerDAO {

    @Override
    public String getLastCustomerId() throws Exception {
        Query nativeQuery = entityManager.
                createNativeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        return nativeQuery.getResultList().size() > 0? (String) nativeQuery.getSingleResult() : null;
    }
}
