package dao;

import entity.User;

public interface UserDao {
    boolean login(String nom, String password);
}
