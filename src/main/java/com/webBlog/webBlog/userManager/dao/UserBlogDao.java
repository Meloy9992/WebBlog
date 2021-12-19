package com.webBlog.webBlog.userManager.dao;

import com.webBlog.webBlog.userManager.model.UserBlog;

import java.util.List;

public interface UserBlogDao {
    void addBlog(UserBlog userBlog);

    List<UserBlog>getAll();

    UserBlog getById(int id);

    UserBlog updateBlog(int id, String title, String description);

    void deleteBlog(int id);

    List<UserBlog>searchBlog(String title, String description);
}
