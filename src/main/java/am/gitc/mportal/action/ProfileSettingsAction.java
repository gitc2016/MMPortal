package am.gitc.mportal.action;

import am.gitc.mportal.action.utils.MD5;
import am.gitc.mportal.dao.impl.CountryDaoImpl;
import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.Country;
import am.gitc.mportal.domain.User;
import am.gitc.mportal.util.Global_Keys;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by gtc-user29 on 12/16/2016.
 */
public class ProfileSettingsAction extends GlobalAction implements ModelDriven<User> {

    private User user;
    private String newPassword;
    private UserDaoImpl userDao;
    private int countryId;
    private CountryDaoImpl countryDao;


    public ProfileSettingsAction() throws Exception {
        userDao = new UserDaoImpl();
        countryDao = new CountryDaoImpl();
    }

//    public String execute() throws Exception {
//        super.getUserFromSession();
//        return SUCCESS;
//    }

    public String updateProfile() throws Exception {
        Country country = countryDao.getById(countryId);
        int id = (Integer) mapSession.get(Global_Keys.LOGIN);
        User users = userDao.getById(id);
        users.setName(user.getName());
        users.setSurname(user.getSurname());
        users.setBirthDate(user.getBirthDate());
        users.setPassword(MD5.encryptPassword(newPassword));
        users.setCountry(country);
        userDao.update(users);
        return SUCCESS;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public void validate() {
        int id = (Integer) mapSession.get(Global_Keys.LOGIN);
        try {
            if (!(user.getPassword().isEmpty()) && !(userDao.getById(id).getPassword()).equals(MD5.encryptPassword(user.getPassword()))) {
                if (newPassword.isEmpty()) {
                    addFieldError("user.password", "Please enter your right passsword");
                } else if (newPassword.length() < 2 || newPassword.length() > 20) {
                    addFieldError("newPassword", "Please enter valid new password");
                } else if (!newPassword.equals(user.getConfirmPassword())) {
                    addFieldError("user.confirmPassword", "Please enter valid confirmPassword");
                }
            } else if (!newPassword.isEmpty()) {
                if (user.getConfirmPassword().isEmpty()) {
                    addFieldError("user.confirmPassword", "Please enter confirmPassword");
                } else if (!newPassword.equals(user.getConfirmPassword())) {
                    addFieldError("user.confirmPassword", "Please enter valid confirmPassword");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getModel() {
        return user;
    }
}
