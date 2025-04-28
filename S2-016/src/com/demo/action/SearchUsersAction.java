package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchUsersAction extends ActionSupport implements SessionAware {
    private String searchQuery;
    private List<User> users;
    private Map<String, Object> session;

    @Override
    public String execute() {
        List<User> allUsers = (List<User>) session.get("allUsers");
        if (allUsers == null) {
            allUsers = new ArrayList<>();
        }

        users = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getName().toLowerCase().contains(searchQuery.toLowerCase()) ||
                user.getEmail().toLowerCase().contains(searchQuery.toLowerCase())) {
                users.add(user);
            }
        }

        return SUCCESS;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}