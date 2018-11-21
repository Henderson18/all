package org.orion.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.orion.app.entity.User;
import org.orion.app.persistence.configuration.HibernateH2Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateH2ConfigurationTest {

    private Logger logger = LoggerFactory.getLogger(HibernateH2ConfigurationTest.class);
    @Test
    void Save() {
        HibernateH2Configuration configuration = new HibernateH2Configuration();
        configuration.configure();         configuration.addClass(User.class);
        configuration.buildSessionFactory();

        User user = new User();
        user.setName("Chendjou");
        user.setSurname("Caleb");

        SessionFactory sessionFactory = configuration.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();         session.close();

        logger.info("New user id: " + user.getId());
    }
}
