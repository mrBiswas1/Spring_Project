package com.zepto.password.reset.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zepto.password.reset.entity.UserEntity;

@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void updatePassword(String userName, String hashedPassword) {
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();

        UserEntity user = session.createQuery("FROM UserEntity u WHERE u.userName = :userName", UserEntity.class)
                                 .setParameter("userName", userName)
                                 .uniqueResult();
        if (user != null) {
            user.setPassword(hashedPassword);
            session.update(user);
        }

        txn.commit();
        session.close();
    }
}
