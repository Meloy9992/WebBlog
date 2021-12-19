package com.webBlog.webBlog.userManager.services;

import com.webBlog.webBlog.userManager.model.UserBlog;

import java.util.List;

public interface UserBlogService {

    void addBlog(UserBlog userBlog);

    List<UserBlog> getAll();

    UserBlog getById(int id);

    UserBlog updateBlog(int id, String title, String description);

    void deleteBlog(int id);

    void createBlog(String title, String description);

    List<UserBlog>searchBlog(String title, String description);
}
