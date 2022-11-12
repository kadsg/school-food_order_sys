package service;

import bean.Merchant;
import bean.User;
import dao.UserDao;

import java.util.LinkedList;
import java.util.List;

public class UserManage {
    UserDao dao;

    public boolean addUser(User user) {
        dao = new UserDao();
        return dao.add(user);
    }

    /**
     *
     * @param id 用户id
     * @return
     */
    public User getUserById(String id) {
        dao = new UserDao();
        return (User) dao.search(id);
    }

    /**
     * 返回系统的所有用户
     * @return
     */
    public List<User> getAllUser() {
        dao = new UserDao();
        List<User> userList = new LinkedList<>();
        List<Object> list = dao.search();

        if (list != null) {
            for (Object o : list) {
                userList.add((User) o);
            }
        }
        return userList;
    }

    /**
     * 查询是否存在用户
     * @param id 用户id
     * @return
     */
    public boolean isExist(String id) {
        return getUserById(id) != null;
    }
}
