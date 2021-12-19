package com.webBlog.webBlog.userManager.services.impl;

import com.webBlog.webBlog.userManager.dao.UserBlogDao;
import com.webBlog.webBlog.userManager.model.UserBlog;
import com.webBlog.webBlog.userManager.services.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBlogServiceImpl implements UserBlogService {
    private UserBlogDao userBlogDao;

    @Autowired
    public UserBlogServiceImpl(UserBlogDao userBlogDao) {
        this.userBlogDao = userBlogDao;
    }

    @Override
    public void addBlog(UserBlog userBlog) {
        userBlogDao.addBlog(userBlog);
    }

    @Override
    public List<UserBlog> getAll() {
        return userBlogDao.getAll();
    }

    @Override
    public UserBlog getById(int id) {
        return userBlogDao.getById(id);
    }

    @Override
    public UserBlog updateBlog(int id, String title, String description) {
        return userBlogDao.updateBlog(id, title, description);
    }

    @Override
    public void deleteBlog(int id) {
        userBlogDao.deleteBlog(id);
    }

    @Override
    public void createBlog(String title, String description) {
        userBlogDao.addBlog(new UserBlog(title, description));
    }

    @Override
    public List<UserBlog> searchBlog(String title, String description) {
        return userBlogDao.searchBlog(title, description);
    }
}
