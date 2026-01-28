package com.zepto.password.reset.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zepto.password.reset.entity.UserPasswordReset;

@Repository
public class UserPasswordHistoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void savePassword(String userName, String lastThree) {
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            txn = session.beginTransaction();

            UserPasswordReset upr = new UserPasswordReset();
            upr.setUserName(userName);
            upr.setPassword(lastThree);

            session.save(upr);

            txn.commit();
        } catch (Exception ex) {
            if (txn != null) txn.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }
    public boolean exist(String userName, String lastThree) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "SELECT 1 FROM UserPasswordReset u "
                       + "WHERE u.userName = :userName AND u.password = :lastThree";
            Object result = session.createQuery(hql)
                                   .setParameter("userName", userName)
                                   .setParameter("lastThree", lastThree)
                                   .setMaxResults(1)
                                   .uniqueResult();
            return result != null;
        } finally {
            session.close();
        }
    }
    public void keepLastN(String userName, int n) {
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            txn = session.beginTransaction();

            String hqlFetch = "SELECT u.id FROM UserPasswordReset u "
                            + "WHERE u.userName = :userName ORDER BY u.id DESC";
            @SuppressWarnings("unchecked")
            List<Long> ids = (List<Long>) session.createQuery(hqlFetch)
                    .setParameter("userName", userName)
                    .list();

            if (ids != null && ids.size() > n) {
                List<Long> toDelete = ids.subList(n, ids.size());
                // Bulk delete
                String delHql = "DELETE FROM UserPasswordReset u WHERE u.id IN (:ids)";
                session.createQuery(delHql)
                       .setParameterList("ids", toDelete)
                       .executeUpdate();
            }

            txn.commit();
        } catch (Exception ex) {
            if (txn != null) txn.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }
}
