package am.gitc.mportal.action;

import am.gitc.mportal.dao.impl.CategoryDaoImpl;
import am.gitc.mportal.dao.impl.FriendDaoImpl;
import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.User;

import java.util.List;

/**
 * Created by gtc-user29 on 12/8/2016.
 */
public class UserAction extends GlobalAction {

    private User senderUser = new User();
    private UserDaoImpl userDao;
    private List<User> userList;
    private int requestCount;
    private int friendId;
    private FriendDaoImpl friendDao;
    private CategoryDaoImpl categoryDao;


    public UserAction() throws Exception {
        userDao = new UserDaoImpl();
        friendDao = new FriendDaoImpl();
        categoryDao = new CategoryDaoImpl();
    }


    public String execute() throws Exception {
        super.getUserFromSession();
        return SUCCESS;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(User senderUser) {
        this.senderUser = senderUser;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }
}


