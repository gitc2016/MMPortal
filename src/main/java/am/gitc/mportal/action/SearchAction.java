package am.gitc.mportal.action;

import am.gitc.mportal.dao.impl.CategoryDaoImpl;
import am.gitc.mportal.dao.impl.MentorCategoryImpl;
import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.Status;
import am.gitc.mportal.domain.User;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchAction extends GlobalAction implements ApplicationAware {
//region fields
    private UserDaoImpl userDao;

    private List<User> userList;
    private int countryId;
    private CategoryDaoImpl categoryDao;
    private MentorCategoryImpl mentorCategory;
    private String searchKeyword;
    private String userName;
    private List<User> searchList;
    private User user = new User();
    private List<User> userStatusList;
    private boolean searchStatus;
    private int categoryId;

    //endregion
    public SearchAction() throws Exception{
        try {
            userDao = new UserDaoImpl();
            categoryDao = new CategoryDaoImpl();
            mentorCategory = new MentorCategoryImpl();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }


    public String advancedSearch(){

        return SUCCESS;
    }

    @SkipValidation
    public String mentorSearch(){
        userStatusList = new ArrayList<User>();
        searchList = new ArrayList<User>();
        searchList = userDao.getUserByStatus(Status.MENTOR.name());
       if (searchList != null) {
           for (User userByStatus : searchList) {
               userStatusList.add(userByStatus);
           }
       }
        try {
            super.getUserFromSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
       searchStatus = true;
        return SUCCESS;
    }

    @SkipValidation
    public String menteeSearch(){
        userStatusList = new ArrayList<User>();
        searchList = new ArrayList<User>();
        searchList = userDao.getUserByStatus(Status.MENTEE.name());
        if (searchList != null) {
            for (User userByStatus : searchList) {
                userStatusList.add(userByStatus);
            }
        }
        try {
            super.getUserFromSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchStatus = false;
        return SUCCESS;
    }



    @Override
    public void setApplication(Map<String, Object> map) {
        mapApp = map;
    }
//region geter And seter

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<User> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<User> searchList) {
        this.searchList = searchList;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserStatusList() {
        return userStatusList;
    }

    public void setUserStatusList(List<User> userStatusList) {
        this.userStatusList = userStatusList;
    }

    public boolean isSearchStatus() {
        return searchStatus;
    }

    public void setSearchStatus(boolean searchStatus) {
        this.searchStatus = searchStatus;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    //endregion
}
