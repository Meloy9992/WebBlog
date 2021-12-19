package com.webBlog.webBlog.userManager.dao.impl;

import com.webBlog.webBlog.userManager.dao.UserBlogDao;
import com.webBlog.webBlog.userManager.model.UserBlog;
import com.webBlog.webBlog.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserBlogDaoImpl implements UserBlogDao {

    @Override
    public void addBlog(UserBlog userBlog) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(userBlog);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<UserBlog> getAll() {
        try{
            Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserBlog.class);
            List<UserBlog> notesList = criteria.list();
            return notesList;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    @Override
    public UserBlog getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserBlog userBlog = (UserBlog) session.createQuery("FROM UserBlog WHERE id = " + id).list().get(0);
        session.close();
        return userBlog;
    }

    @Override
    public UserBlog updateBlog(int id, String title, String description) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserBlog originalBlog = getById(id);
        if (originalBlog != null){
            session.beginTransaction();
            originalBlog.setTitle(title);
            originalBlog.setDescription(description);
            session.saveOrUpdate(originalBlog);
            session.getTransaction().commit();
        }
        session.close();
        return originalBlog;
    }

    @Override
    public void deleteBlog(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(getById(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<UserBlog> searchBlog(String title, String description) {
        Criteria criteria = HibernateUtil.getSessionFactory().openSession().createCriteria(UserBlog.class);

        if (title != null && !title.equals("")){
            criteria.add(Restrictions.like("title", title ));
        }

        if (description != null && !description.equals("")){
            criteria.add(Restrictions.like("description", description));
        }

        return criteria.list();
    }
}
