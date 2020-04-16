package tracker.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tracker.entity.Customer;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        //get list of customers from query
        List<Customer> customers = theQuery.getResultList();

        //return list of customers
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        //get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //save customer to db
        session.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {

        Session session = sessionFactory.getCurrentSession();

        Customer theCustomer = session.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, theId);

        session.delete(customer);

        System.out.println("Customer Deleted");
    }

}
